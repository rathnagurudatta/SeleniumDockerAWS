package com.orangehrm.dataproviders;

import com.google.gson.Gson;
import com.orangehrm.pojos.TestData;
import com.orangehrm.pojos.User;
import com.orangehrm.utilities.CSVReaderUtility;
import com.orangehrm.utilities.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProviders {

    @DataProvider(name  = "LoginDataProvider")
    public Iterator<Object[]> loginDataProviders(){
        File jsonFile = new File(System.getProperty("user.dir") +  "/src/test/resources/testdata/logindata.json");
        Gson gson = new Gson();
        TestData testData;
        try {
            FileReader reader = new FileReader(jsonFile);
            testData = gson.fromJson(reader, TestData.class);
            List<Object[]> dataToReturn = new ArrayList<Object[]>();
            for(User user: testData.getData()){
                dataToReturn.add(new Object[]{user});
            }
            return dataToReturn.iterator();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @DataProvider(name = "LoginCsvDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CSVReaderUtility.readCSVFile("logindata");
    }

    @DataProvider(name = "LoginExcelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("LoginData");
    }
}
