package cn.edu.zjut.dao;

import cn.edu.zjut.po.ResultDetail;
import cn.edu.zjut.po.Student;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class ExcelFileGenerator {

    private final int SPLIT_COUNT = 1500;

    private XSSFWorkbook workBook = null;


    /**
     * @param fieldName
     * @param stuDataList
     * @return
     * @Describe 传入学生信息，创建Excel表格，将学生信息导入Excel表格。
     */
    public XSSFWorkbook createWorkbook(ArrayList fieldName, ArrayList<Student> stuDataList) {

        workBook = new XSSFWorkbook();
        int rows = stuDataList.size();
        int sheetNum = 0;

        if (rows % SPLIT_COUNT == 0) {
            sheetNum = rows / SPLIT_COUNT;
        } else {
            sheetNum = rows / SPLIT_COUNT + 1;
        }

        for (int i = 1; i <= sheetNum; i++) {
            XSSFSheet sheet = workBook.createSheet("Page " + i);
            XSSFRow headRow = sheet.createRow((short) 0);
            for (int j = 0; j < fieldName.size(); j++) {
                XSSFCell cell = headRow.createCell((short) j);
                sheet.setColumnWidth((short) j, (short) 6000);
                XSSFCellStyle cellStyle = workBook.createCellStyle();
                XSSFFont font = workBook.createFont();
                cellStyle.setFont(font);
                if (fieldName.get(j) != null) {
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(fieldName.get(j).toString());

                } else {
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue("-");
                }
            }
            Iterator itf = stuDataList.iterator();
            for (int tem = 0; tem < (i - 1) * SPLIT_COUNT; tem++) {
                itf.next();
            }
            Iterator it = itf;
            for (int k = 0; k < (rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++) {
                XSSFRow row = sheet.createRow((short) (k + 1));
                ResultDetail resultDetail = (ResultDetail) it.next();
                XSSFCell cell0 = row.createCell(0);
                cell0.setCellValue(resultDetail.getStudentsign().getStuID());
                XSSFCell cell1 = row.createCell(1);
                cell1.setCellValue(resultDetail.getStudent_name());
                XSSFCell cell2 = row.createCell(2);
                cell2.setCellValue(resultDetail.getStudent_class());
                XSSFCell cell3 = row.createCell(3);
                cell3.setCellValue(resultDetail.getStudent_department());
                XSSFCell cell4 = row.createCell(4);
                cell4.setCellValue(resultDetail.getStudentsign().getSignTime());
                XSSFCell cell5 = row.createCell(5);
                cell5.setCellValue(resultDetail.getStudentsign().getSimilar());
                if (resultDetail.getStudentsign().getStatus() == 0) {
                    XSSFCell cell6 = row.createCell(6);
                    cell6.setCellValue("未到");
                } else if (resultDetail.getStudentsign().getStatus() == 1) {
                    XSSFCell cell6 = row.createCell(6);
                    cell6.setCellValue("请假");
                } else {
                    XSSFCell cell6 = row.createCell(6);
                    cell6.setCellValue("已到");
                }
            }
        }
        return workBook;
    }

    public void exportExcel(OutputStream os, ArrayList fieldName, ArrayList stuDataList) throws Exception {
        workBook = createWorkbook(fieldName, stuDataList);
        workBook.write(os);
        os.close();
    }

    /**
     * 前端传来的file缓存并且传入List
     */
    public ArrayList<Student> inputExcel(File file) throws IOException {
        ArrayList<Student> stuField = new ArrayList();
        File target = new File("excel.xls");
        if (target.exists())
            target.delete();
        target.createNewFile();
        System.out.println("copy");
        FileUtils.copyFile((File) file, target);

        System.out.println("inputStream Start");
        FileInputStream is = new FileInputStream("excel.xls");
        System.out.println("generate");
        workBook = new XSSFWorkbook(is);
        try {
            for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
                XSSFSheet sh = workBook.getSheetAt(i);
                for (int j = 0; sh.getRow(j) != null; j++) {
                    XSSFRow row = sh.getRow(j);
                    Student student = new Student();
                    student.setStuID((int) Double.parseDouble(row.getCell(0).toString().trim()));
                    student.setName(row.getCell(1).toString());
                    student.setPassword(row.getCell(2).toString());
                    student.setSex((int) Double.parseDouble(row.getCell(3).toString()));
                    student.setClazz(row.getCell(4).toString());
                    student.setDepart(row.getCell(5).toString());
                    student.setEmail(row.getCell(6).toString());
                    System.out.println(student.getStuID());
                    stuField.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuField;
    }

    public ArrayList getFieldName(InputStream is, File target, ArrayList fieldName) throws IOException {

        XSSFSheet sh = workBook.getSheetAt(0);
        XSSFRow row = sh.getRow(0);
        for (int i = 0; row.getCell(i) != null; i++) {
            XSSFCell cell = row.getCell(i);
            fieldName.add(row.getCell(i).toString());
        }
        return fieldName;
    }


}





