package com.orangehrm.utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.orangehrm.pojos.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSVFile(String fileName) {
        File file = new File(System.getProperty("user.dir") +  "/src/test/resources/testdata/" + fileName + ".csv");
        FileReader  reader = null;
        CSVReader csvReader;
        String[] strArr;
        List<User> userList = new ArrayList<>();
        User user;

        try {
            reader = new FileReader(file);
            csvReader = new CSVReader(reader);

            while(csvReader.iterator().hasNext()){
                strArr = csvReader.readNext();
                user = new User(strArr[0], strArr[1]);
                userList.add(user);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList.iterator();

    }
}
