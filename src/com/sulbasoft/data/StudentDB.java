/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.data;

import com.sulbasoft.business.Student;
import com.sulbasoft.utility.DBConnection;
import com.sulbasoft.utility.DBException;
import com.sulbasoft.utility.GenderType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author M. S. Ali (CCS)
 */
public class StudentDB {

    public static List<Student> getAll() throws DBException {
        List<Student> students = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM students";
        try (PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String sex = rs.getString("sex");
                GenderType gender = GenderType.valueOf(sex.toUpperCase());
                Date dob = rs.getDate("dob");
                double gpa = rs.getDouble("gpa");
                LocalDate birthDate = dob.toLocalDate();
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");

                Student s = new Student(id, fname, lname, gender, 
                                            birthDate, gpa, email, phone);
                students.add(s);
            }
        } catch (SQLException e) {
            throw new DBException(e.toString());
        }
        return students;
    }

    public static Student get(String stuId) throws DBException {
        String query = "SELECT * FROM students WHERE id = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, stuId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String sex = rs.getString("sex");
                GenderType gender = GenderType.valueOf(sex.toUpperCase());
                Date dob = rs.getDate("dob");
                double gpa = rs.getDouble("gpa");
                LocalDate birthDate = dob.toLocalDate();
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                rs.close();

                Student s = new Student(id, fname, lname, gender, 
                                            birthDate, gpa, email, phone);

                return s;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e.toString());
        }

    }

    public static boolean add(Student s) throws DBException {
        String query = "INSERT INTO students(id, first_name, "
                + "last_name, sex, dob, gpa, email, phone_number)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, s.getId());
            ps.setString(2, s.getfName());
            ps.setString(3, s.getlName());
            GenderType gender = s.getGender();
            String sex = gender.toString();
            ps.setString(4, sex);
            ps.setDate(5, Date.valueOf(s.getBirthDate()));
            ps.setDouble(6, s.getGpa());
            ps.setString(7, s.getEmail());
            ps.setString(8, s.getPhone());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print(e.toString());
            return false;
        }
    }

    public static boolean update(Student s) throws DBException {
        String query = "UPDATE students SET "
                + "first_name = ?, "
                + "last_name = ?, "
                + "sex = ?, "
                + "dob = ?, "
                + "gpa = ?, "
                + "email = ?, "
                + "phone_number = ?"
                + "WHERE id = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, s.getfName());
            ps.setString(2, s.getlName());
            GenderType gender = s.getGender();
            String sex = gender.toString();
            ps.setString(3, sex);
            ps.setDate(4, Date.valueOf(s.getBirthDate()));
            ps.setDouble(5, s.getGpa());
            ps.setString(6, s.getEmail());
            ps.setString(7, s.getPhone());
            ps.setString(8, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print(e.toString());
            return false;
        }
    }

    public static boolean delete(Student s) throws DBException {
        String query = "DELETE FROM students "
                     + "WHERE id= ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print(e.toString());
            return false;
        }
    }

    public static List<Student> filterStudents(List<Student> students,
            Predicate<Student> condition) {
        List<Student> filteredStudents = new ArrayList<>();
        students.stream().filter((s) -> (condition.test(s))).forEachOrdered((s) -> {
            filteredStudents.add(s);
        });
        return filteredStudents;
    }
}
