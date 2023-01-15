package ru.rustamtut;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import ru.rustamtut.entity.Test;
import ru.rustamtut.entity.Tests;
import ru.rustamtut.entity.Value;
import ru.rustamtut.entity.Values;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("NEED 2 ARGUMENTS");
            return;
        }
        try (FileReader frT = new FileReader(args[0]);
             FileReader frV = new FileReader(args[1]);
             Writer wr = Files.newBufferedWriter(Paths.get("report.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Tests tests = gson.fromJson(frT, Tests.class);
            Values values = gson.fromJson(frV, Values.class);
            Map<Integer, String> data = new HashMap<>();

            for (Value val: values.getValues()) {
                data.put(val.getId(), val.getValue());
            }

            updateJsonDataDFS(data, tests.getTests());
            gson.toJson(tests, wr);

        } catch (JsonIOException | JsonSyntaxException | NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateJsonDataDFS(Map<Integer, String> map, List<Test> tests) {
        for (Test test : tests) {
            if (map.containsKey(test.getId()))
                test.setValue(map.get(test.getId()));
            if (test.getValues() != null)
                updateJsonDataDFS(map, test.getValues());
        }
    }

}