package com.orangehrm.utilities;

import com.google.gson.Gson;
import com.orangehrm.Constants.Env;
import com.orangehrm.pojos.Config;
import com.orangehrm.pojos.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtiltity {

    private static String Env;

    public static Environment readJson(Env env) {
       // public static void main(String[] args) {
        File jsonFile = new File(System.getProperty("user.dir") +  "/src/test/resources/config/config.json");
        Gson gson = new Gson();
        Config config;
        try {
            FileReader reader = new FileReader(jsonFile);
            config = gson.fromJson(reader, Config.class);
            Environment environment = config.getenvironments().get("qa");
            System.out.println(environment.getUrl());
            return environment;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }


}
