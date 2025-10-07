package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            Employee employee = new Employee(0,"",0,0);
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine(); // This skips the first line, please don't remove again

            String input;
            while((input = bufReader.readLine()) != null){
                String[] parts = input.split(Pattern.quote("|"));

                int id = Integer.parseInt(parts[0]); // Employee id
                String name = parts[1]; // Employee's Name
                Double hours = Double.parseDouble(parts[2]); // Employee Hours
                Double payRate = Double.parseDouble(parts[3]); // Employee PayRate

                employee.setName(name);
                employee.setEmployeeId(id);
                employee.setHoursWorked(hours);
                employee.setPayRate(payRate);
                System.out.printf("%d %s %.2f $%.2f\n",employee.getEmployeeId(),employee.getName(),employee.getHoursWorked(),employee.getPayRate());

                System.out.printf("$%.2f\n",employee.getGrossPay());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
