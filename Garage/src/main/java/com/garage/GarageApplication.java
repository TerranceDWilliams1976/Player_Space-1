package com.garage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarageApplication.class, args);

        	    // connection to the database
                Connection con;

                // connecting to the database can potentially result in an error, so a try-catch block is used to catch this
                try {
                    // connect to the "chinook.db" database
                    // the last two empty strings in the method are for username and password, which aren't necessary here
                    con = DriverManager.getConnection("jdbc:mysql:test.cyjqic58ue0v.us-east-2.rds.amazonaws.com", "", "");

                    // prepare a Statement object for SQL queries
                    Statement stmt = con.createStatement();

                    // get all columns from the table "Album"
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Test");

                    // variables for each column in the database
                    String FirstName;

                    // access each row in the table
                    while (rs.next()) {
                        // get the values from each column of the current row
                        FirstName = rs.getString("FirstName");

                        // print the values of the row
                        System.out.println("First Name: '" + FirstName);
                    }
                } catch (SQLException e) {
                    // print the stack trace of the error
                    e.printStackTrace();
                }
    }
}