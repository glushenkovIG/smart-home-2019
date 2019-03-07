package ru.sbt.mipt.oop.SmartHome;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;

// will change only with json architecture changings, SRP adhered
public class SmartHomeGsonReader implements SmartHomeReader {
    public SmartHome Read(Object path_) {
        String path = path_.toString();
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            return (gson.fromJson(json, SmartHome.class));

        } catch (Exception IOException) {
            System.out.println("IOException");
        }
        return null;
    }
}
