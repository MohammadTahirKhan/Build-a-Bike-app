package SQL;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

public class Utils {

//    Lists the drivers
    public static void main(String[] args) throws Exception {
        System.out.println("\nDrivers loaded as properties:");
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println("\nDrivers loaded by DriverManager:");
        Enumeration<Driver> list = DriverManager.getDrivers();
        while (list.hasMoreElements())
            System.out.println(list.nextElement());
    }

//    Retrieves the credentials from Credentials.txt
    static String[] getCredentials(){
        String[] creds = new String[2];

        try {
            File myObj = new File("Credentials.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                creds[0] = myReader.nextLine().split("=")[1];
                creds[1] = myReader.nextLine().split("=")[1];
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return creds;
    }




}