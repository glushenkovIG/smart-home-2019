package ru.sbt.mipt.oop.SmartHome;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;

// will change only with json architecture changings, SRP adhered
public class SmartHomeGsonReader implements SmartHomeReader {
    String path;
    public SmartHomeGsonReader(String path_){
        path = path_;
    }

    public SmartHome Read() {
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            SmartHome smartHome = gson.fromJson(json, SmartHome.class);
            smartHome.normalize();
            return smartHome;

        } catch (Exception IOException) {
            System.out.println("IOException");
        }
        return null;
    }
}
