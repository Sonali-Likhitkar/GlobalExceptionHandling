package com.example.demo.helper;

import com.example.demo.entity.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }

    // its convert excel to list of products
    public static List<Column> convertExcelToListOfColumns(InputStream is) {
        List<Column> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 1;
                Column e = new Column();
                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
//                        case 0:
//                           // c.setColumnId((int)cell.getNumericCellValue());
//                            System.out.println(":::: Type of the cell  "+cell.getCellType());
//                            e.setEmpId((int) cell.getNumericCellValue());
//                            break;
                        case 1:
                            //c.setColumnName(cell.getStringCellValue());
                            e.setFirstName(cell.getStringCellValue());
                            break;
                        case 2:
                            //c.setBroker(cell.getStringCellValue());
                            e.setLastName(cell.getStringCellValue());
                            break;
                        case 3:
                            //  c.setBorrower(cell.getStringCellValue());
                            e.setGender(cell.getStringCellValue());
                            break;
                        case 4:
                            // c.setFunder(cell.getStringCellValue());
                            e.setAge((int) cell.getNumericCellValue());
                            break;
                        case 5:
                            e.setEmail(cell.getStringCellValue());
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
