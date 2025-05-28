package com.blackduck.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLI {

    private String connectionString = "jdbc:mysql://localhost:3306/mydb";
    private String dbUser = "user";
    private String dbPassword = "password";

    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement stmt = conn.createStatement();

            // ⚠️ SQLインジェクションの脆弱性がある箇所
            String query = "SELECT * FROM users WHERE name = '" + name + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new SQLI().test();
    }
}
