package com.ambuj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.*;

public class DrillFeeder {

    public static void main(String[] args) {
        try {

            File file1 = new File("E:/drill/test/file1.txt");

            File file2 = new File("E:/drill/test/file2.txt");

            File file3 = new File("E:/drill/test/file3.txt");

            File file4 = new File("E:/drill/test/file4.txt");

            // if file doesnt exists, then create it
            if (!file1.exists()) {
                file1.createNewFile();
            }

            if (!file2.exists()) {
                file2.createNewFile();
            }

            if (!file3.exists()) {
                file3.createNewFile();
            }

            if (!file4.exists()) {
                file4.createNewFile();
            }

            FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
            BufferedWriter bw1 = new BufferedWriter(fw1);

            for(int i=0; i < 70000000; i++) {
                String content = i + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID();
                bw1.write(content);
                bw1.write("\n");
                bw1.flush();

            }

            bw1.close();

            FileWriter fw2 = new FileWriter(file2.getAbsoluteFile());
            BufferedWriter bw2 = new BufferedWriter(fw2);

            for(int i=0; i < 30000; i++) {
                String content = i + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID();
                bw2.write(content);
                bw2.write("\n");
                bw2.flush();

            }

            bw2.close();

            FileWriter fw3 = new FileWriter(file3.getAbsoluteFile());
            BufferedWriter bw3 = new BufferedWriter(fw3);

            for(int i=0; i < 40000; i++) {
                String content = i + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID();
                bw3.write(content);
                bw3.write("\n");
                bw3.flush();

            }

            bw3.close();

            FileWriter fw4 = new FileWriter(file4.getAbsoluteFile());
            BufferedWriter bw4 = new BufferedWriter(fw4);

            for(int i=0; i < 10; i++) {
                String content = i + "\t" + randomUUID() + "\t" + randomUUID() + "\t" + randomUUID();
                bw4.write(content);
                bw4.write("\n");
                bw4.flush();

            }

            bw4.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
