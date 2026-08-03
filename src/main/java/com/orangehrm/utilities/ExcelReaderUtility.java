package com.orangehrm.utilities;

import com.orangehrm.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName + ".xlsx");
        XSSFWorkbook xssfWorkbook;
        List<User>  userlist = new ArrayList<>();
        User user;
        Row row;
        try {
            xssfWorkbook = new XSSFWorkbook(file);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            Iterator<Row> rowIterator = xssfSheet.iterator();
            rowIterator.next();
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                Cell usernameCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);
                user = new User(usernameCell.toString(), passwordCell.toString());
                userlist.add(user);
                return userlist.iterator();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return null;
    }


}
