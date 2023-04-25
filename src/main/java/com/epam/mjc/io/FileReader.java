package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {


    public Profile getDataFromFile(File file) {

        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        try (java.io.FileReader fileReader = new java.io.FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line = reader.readLine();

            while (line != null) {

                if(line.split(":", 2)[0].equals("Name")){
                    name = line.split(": ", 2)[1];
                } else if(line.split(":", 2)[0].equals("Age")){
                    age = Integer.parseInt(line.split(": ", 2)[1]);
                } else if(line.split(":", 2)[0].equals("Email")){
                    email = line.split(": ", 2)[1];
                } else if(line.split(":", 2)[0].equals("Phone")){
                    phone = Long.parseLong(line.split(": ", 2)[1]);
                }

                line = reader.readLine();
            }
        } catch (IOException ex){
            System.out.print(ex.getMessage());
        }

        return new Profile(name, age, email, phone);
    }
}
