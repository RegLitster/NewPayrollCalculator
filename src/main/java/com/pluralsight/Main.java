package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("Enter the name of the employee file to process:");
        String fileName = user.nextLine();
        System.out.println("Enter the name of the payroll file to create:");
        String payroll = user.nextLine();

        try {
            FileReader fileReader = new FileReader("src/main/resources/" + fileName); // there's probably a better way
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();

            FileWriter fileWriter = new FileWriter("src/main/resources/" + payroll);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            bufWriter.write("ID|Name|Gross Pay\n");
            String input;

            while ((input = bufReader.readLine()) != null) {
                String[] parts = input.split(Pattern.quote("|"));

                int id = Integer.parseInt(parts[0]); // Employee id
                String name = parts[1]; // Employee's Name
                double hours = Double.parseDouble(parts[2]); // Employee Hours
                double payRate = Double.parseDouble(parts[3]); // Employee PayRate

                Employee employee = new Employee(id, name, hours, payRate);

                bufWriter.write("ID" + "|" + id + "|" + "Name" + "|" + name + "|$" + employee.getGrossPay());
                bufWriter.newLine();

            }
            bufWriter.close();
            bufReader.close();

        } catch (IOException e) {
            System.out.println("An Unexpected Error Has Occurred");
            e.printStackTrace();
        }
    }
}
