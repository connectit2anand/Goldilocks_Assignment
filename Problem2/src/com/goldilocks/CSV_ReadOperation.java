package com.goldilocks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV_ReadOperation {
	
	public static void main(String[] args) {
		String inputFile = "input.csv";
        String outputFile = "output.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;
            double sum = 0.0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                	Integer num1 = Integer.parseInt(values[0]);
                	Integer num2 = Integer.parseInt(values[1]);
                	Integer num3 = Integer.parseInt(values[2]);
                    sum += num1 + num2 + num3;

                    writer.write(line + "," + (num1 + num2 + num3));
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();

            System.out.println("Output written to " + outputFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
