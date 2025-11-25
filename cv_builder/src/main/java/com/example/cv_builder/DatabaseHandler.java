package com.example.cv_builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

    private static final String DB_URL = "jdbc:sqlite:cv_builder.db";

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS cv_data (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " full_name TEXT NOT NULL,\n"
                + " email TEXT NOT NULL,\n"
                + " phone TEXT,\n"
                + " address TEXT,\n"
                + " education TEXT,\n"
                + " skills TEXT,\n"
                + " experience TEXT,\n"
                + " projects TEXT,\n"
                + " image_path TEXT\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCV(CVData data) throws SQLException {
        String sql = "INSERT INTO cv_data(full_name, email, phone, address, education, skills, experience, projects, image_path) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, data.getFullName());
            pstmt.setString(2, data.getEmail());
            pstmt.setString(3, data.getPhone());
            pstmt.setString(4, data.getAddress());
            pstmt.setString(5, data.getEducation());
            pstmt.setString(6, data.getSkills());
            pstmt.setString(7, data.getExperience());
            pstmt.setString(8, data.getProjects());
            pstmt.setString(9, data.getImagePath());
            pstmt.executeUpdate();
            System.out.println("CV inserted successfully.");
        }
    }

    public static java.util.List<CVData> getAllCVs() {
        java.util.List<CVData> cvList = new java.util.ArrayList<>();
        String sql = "SELECT * FROM cv_data";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CVData cv = new CVData(
                    rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("education"),
                    rs.getString("skills"),
                    rs.getString("experience"),
                    rs.getString("projects"),
                    rs.getString("image_path")
                );
                cvList.add(cv);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cvList;
    }

    public static CVData getCVById(int id) {
        String sql = "SELECT * FROM cv_data WHERE id = ?";
        CVData cv = null;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cv = new CVData(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("education"),
                        rs.getString("skills"),
                        rs.getString("experience"),
                        rs.getString("projects"),
                        rs.getString("image_path")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cv;
    }
}
