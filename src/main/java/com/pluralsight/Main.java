package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee();
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine(); // This skips the first line, please don't remove again

            String input;
            while((input = bufReader.readLine()) != null){
                String[] parts = input.split(Pattern.quote("|"));
                employee.setEmployeeId(Integer.parseInt(parts[0])); // Employee id
                employee.setName(parts[1]); // Employee's Name
                employee.setHoursWorked(Double.parseDouble(parts[2])); // Employee Hours
                employee.setPayRate(Double.parseDouble(parts[3])); // Employee PayRate
                System.out.println(employee.getEmployeeId()+" "+employee.getName()+" "+ employee.getHoursWorked()+" "+ employee.getPayRate());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
