package cn.edu.zjut.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public interface IUserService {
    /**
     * Excel导入学生信息
     * @param fieldName
     * @param fieldData
     * @return
     */
    public ByteArrayOutputStream exportExcel(ArrayList fieldName, ArrayList fieldData);

    /**
     * Excel导出学生信息
     * @param file
     * @return
     */
    public boolean inputExcel(File file);

}
