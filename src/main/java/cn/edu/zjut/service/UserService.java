package cn.edu.zjut.service;


import cn.edu.zjut.dao.ExcelFileGenerator;
import cn.edu.zjut.dao.StudentMapper;
import cn.edu.zjut.po.Student;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.zjut.po.ResultDetail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private Map<String, Object> request, session;

    @Autowired
    private ExcelFileGenerator excelFileGenerator;
    @Autowired
    private StudentMapper studentMapper;


    public ByteArrayOutputStream exportExcel(ArrayList fieldName, ArrayList fieldData) {
        System.out.println("Service Start");
        ActionContext ctx = ActionContext.getContext();
        try {
            // 初始化fieldName，fieldDate
            fieldName = getFieldName(); // excel标题数据集
            fieldData = getFieldData(); // excel数据内容
            String myexcel = "myexcel";
            // 回去输出流
            ByteArrayOutputStream out = new ByteArrayOutputStream();



            excelFileGenerator.exportExcel(out, fieldName, fieldData);

            System.out.println(11111);

            // 刷新输出流
            out.flush();
            // 关闭输出流
            if (out != null) {
                out.close();
            }
            return out;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    public ArrayList getFieldName() {
        String str[] = {"学生学号", "姓名", "班级名称", "系名", "签到时间", "相似度", "签到情况"};
        ArrayList list = new ArrayList();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }

    // 模拟提供excel中的标题数据内容
    public ArrayList<ResultDetail> getFieldData() {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        session = (Map) ctx.getSession();
        ArrayList list1 = (ArrayList) session.get("list");
        System.out.println(list1.size());
        Iterator i = list1.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().getClass());
        }
        return list1;
    }

    public void setExcelFileGenerator(ExcelFileGenerator excelFileGenerator) {
        this.excelFileGenerator = excelFileGenerator;
    }

    public ExcelFileGenerator getExcelFileGenerator() {
        return excelFileGenerator;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public boolean inputExcel(File file) {
        ActionContext ctx = ActionContext.getContext();
        ArrayList<Student> stuField = null;
        try {
            System.out.println("UserService Start");
            stuField = excelFileGenerator.inputExcel(file);
            for (Iterator i = stuField.iterator(); i.hasNext(); )
                System.out.println(((Student) i.next()).getStuID());
            studentMapper.insertStudentExcel(stuField);
            studentMapper.insertStudentFace(stuField);
            studentMapper.insertStudentScore(stuField);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("youwenti");
        return false;
    }


}
