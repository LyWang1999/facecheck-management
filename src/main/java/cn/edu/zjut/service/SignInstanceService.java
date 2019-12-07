package cn.edu.zjut.service;

import cn.edu.zjut.dao.InstanceMapper;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.dao.StudentSignMapper;
import cn.edu.zjut.dao.TemplateMapper;
import cn.edu.zjut.po.SignInstance;
import cn.edu.zjut.po.SignInstanceTemplate;
import cn.edu.zjut.po.Student;
import cn.edu.zjut.po.StudentSign;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class SignInstanceService implements ISignInstanceService {
    private Map<String, Object> request, session;

    @Autowired
    private TemplateMapper templateMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private InstanceMapper instanceMapper;
    @Autowired
    private StudentSignMapper studentSignMapper;

    private SignInstanceTemplate temp;

    private List<Student> studentlist = new ArrayList<Student>();//存储学生信息的List

    private List<SignInstance> signInstances = new ArrayList<SignInstance>();//存储实例信息的List


    /**
     *
     * @param stu 学生的id
     * @param dates 需要打卡的日期
     * @param templateid 选择的模板id
     * @param chooseid 选择的计划id
     * @Describe 生成签到信息的实现类
     * @return
     */
    public int insertSignInstance(String[] stu, String[] dates, int templateid, int chooseid) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");




        try {

            temp = templateMapper.getTemplateByid(templateid);//根据id得到签到模板

            for (int i = 0; i < stu.length; i++) {
                studentlist.add(studentMapper.getStudentById(Integer.parseInt(stu[i])));//根据学生id获得相应学生的信息插入List
            }

            for (int j = 0; j < dates.length; j++) {
                signInstances.add(new SignInstance(chooseid, temp.getStartTime(), temp.getEndTime(), temp.getLongitude(), temp.getLatitude(), temp.getRadius(), temp.getPlaceName(), sdf.parse(dates[j])));//根据模板学生以日期个特征插入相应的签到实例
            }
            instanceMapper.insertSignInstance(signInstances);//签到实例表插入
            StudentSign studentSig = new StudentSign();
            /**
             * 学生信息表的插入
             */
            for (int i = 0; i < dates.length; i++)
                for (int j = 0; j < stu.length; j++) {
                    studentSig.setStuID(studentlist.get(j).getStuID());
                    studentSig.setSignInstID(signInstances.get(i).getSignInstID());
                    studentSignMapper.insertRecord(studentSig);

                }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return 1;
    }


    /**
     * @Describe 得到所有的学生信息 为选择学生生成实例做铺垫
     * @return
     */
    public List<Student> listAllStudents() {
        try {
            List<Student> studentList = studentMapper.listAllStudent();
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
