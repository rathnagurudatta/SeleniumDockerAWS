package com.orangehrm.listeners;

import com.orangehrm.Constants.Env;
import com.orangehrm.utilities.JsonUtiltity;
import com.orangehrm.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
    public static final int MAX_NUM_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.loadPropertiesFile(Env.qa, "max_number_of_attempts"));
//    public static final int MAX_NUM_OF_ATTEMPTS = JsonUtiltity.readJson(Env.qa).getMax_number_of_attempts();
    public static int current_num_of_attempts = 1;


    @Override
    public boolean retry(ITestResult iTestResult) {
        while(current_num_of_attempts < MAX_NUM_OF_ATTEMPTS){
            current_num_of_attempts ++;
            return true;
        }

        return false;
    }
}
