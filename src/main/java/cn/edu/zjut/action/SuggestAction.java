package cn.edu.zjut.action;

import cn.edu.zjut.service.ISuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("prototype")
@Controller
public class SuggestAction {
    private String teaID;
    private String suggest;

    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Autowired
    private ISuggestService suggestService = null;

    /**
     * @author 吴一帆
     * @Describe 调用suggestService的getStudentSuggest方法
     * 根据结果返回对应的字符串
     * @return
     */
    public String checkStudentSuggest(){
        try{
            if(suggestService.getStudentSuggest()){
                return "checkStudentSuggestSuccess";
            }else {
                return "checkStudentSuggestFail";
            }
        }catch (Exception e){
            return "login";
        }
    }

    /**
     * @author 吴一帆
     * @Describe 调用suggestService的getTeacherSuggest方法
     * 根据结果返回对应的字符串
     * @return
     */
    public String checkTeacherSuggest(){
        try{
            if(suggestService.getTeacherSuggest()){
                return "checkTeacherSuggestSuccess";
            }else {
                return "checkTeacherSuggestFail";
            }
        }catch (Exception e){
            return "login";
        }
    }

    /**
     * @author 吴一帆
     * @Describe 传入教师的teaID和输入的建议suggest
     * 调用suggestService的insertTeacherSuggest方法
     * @return
     */
    public String insertTeacherSuggest(){
        try{
            if(suggestService.insertTeacherSuggest(teaID,suggest)){
                return "insertTeacherSuggestSuccess";
            }else{
                return "insertTeacherSuggestFail";
            }
        }catch (Exception e){
            return "login";

        }
    }
}
