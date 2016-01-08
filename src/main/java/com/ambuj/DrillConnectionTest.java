package com.ambuj;

import org.apache.drill.jdbc.*;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Ambuj Jauhari on 07-01-2016.
 */
public class DrillConnectionTest {

    /* Drill JDBC Uri for local/cluster zookeeper */
    public static final String DRILL_JDBC_LOCAL_URI = "jdbc:drill:drillbit=localhost:31010";

    /* Sample query used by Drill */
    public static final String DRILL_SAMPLE_QUERY = "select file1.columns[0], file2.columns[1] from dfs.`E:\\drill\\test\\file1.txt` as file1 join dfs.`E:\\drill\\test\\file2.txt` as file2 on file1.columns[0] = file2.columns[0] where file1.columns[0] in (3500000, 400, 1, 6000, 69999996)";

    public static void main(String[] args) {
        Connection con = null;

        try {
            Class.forName("org.apache.drill.jdbc.Driver");

            System.out.println("Success part - 1");
            con = DriverManager.getConnection(DRILL_JDBC_LOCAL_URI);

            System.out.println("Success part - 2");
            Statement stmt = con.createStatement();

            System.out.println("Success part - 3");
            System.out.println("Before-" + System.currentTimeMillis());
            ResultSet rs = stmt.executeQuery(DRILL_SAMPLE_QUERY);

            int count = 0;
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                count++;
            }

            System.out.println("After-" + System.currentTimeMillis());
            System.out.print("-------------------------------");
            System.out.print(count);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
