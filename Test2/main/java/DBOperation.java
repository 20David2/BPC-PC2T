package main.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperation {
    
    public static void fillDatabase(ArrayList<Students> students)
    {
        Connection conn = DBConnection.getDBConnection();
                        
        String insertUser = "INSERT INTO Students (name, surname, dateOfbirth, specialization, programId) VALUES (?, ?, ?, ?, ?)";
        String insertMark = "INSERT INTO Marks (mark, studentId) VALUES (?, ?)";
    
        for (var student : students)
        {
            try (PreparedStatement prStmt = conn.prepareStatement(insertUser);
                 PreparedStatement prStmt2 = conn.prepareStatement(insertMark))
            {
                    Date date = Date.valueOf(student.getDateOfBirthDB());
                    prStmt.setString(1, student.getName());
                    prStmt.setString(2, student.getSurname());
                    prStmt.setDate(3, date);
                    if(student instanceof TechStudents)
                    {
                        prStmt.setInt(4, 0);
                    }
                    else if (student instanceof HumanStudents)
                    {
                        prStmt.setInt(4, 1);
                    }
                    else if (student instanceof CombStudents)
                    {
                        prStmt.setInt(4, 2);
                    }
                    prStmt.setInt(5, student.getID());

                    prStmt.executeUpdate();
            
                    ArrayList<Float> marks = student.getMarks();

                    String selectQuery = "SELECT studentid FROM Students where programid = " + student.getID();
                    int studentId = 0;

                    try (PreparedStatement prStmt3 = conn.prepareStatement(selectQuery);
                        ResultSet rs = prStmt3.executeQuery())
                    {
                        while(rs.next())
                        {
                            studentId = rs.getInt("studentId");
                        }
                        

                    for (var mark : marks) {
                            prStmt2.setFloat(1, mark);
                            prStmt2.setInt(2, studentId);
                    
                            prStmt2.executeUpdate();
                        }
                    }
                    

            } catch (SQLException e) {
            }
        }
        System.out.println("Uspesne zapsano do databaze");
    }

    public static ArrayList<Students> readFromDatabase()
    {
        Connection conn = DBConnection.getDBConnection();
        ArrayList<Students> studentsDB = new ArrayList<>();
        String selectQuery = "select studentid, name, surname, dateOfBirth, specialization from students";

        try (PreparedStatement prStmt = conn.prepareStatement(selectQuery);
            ResultSet rs = prStmt.executeQuery())
        {
            while(rs.next())
            {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int year = rs.getDate("dateOfBirth").toLocalDate().getYear();
                int month = rs.getDate("dateOfBirth").toLocalDate().getMonth().getValue()+1;
                int day = rs.getDate("dateOfBirth").toLocalDate().getDayOfMonth();
                int id = rs.getInt("studentId");

                switch(rs.getInt("specialization"))
                {
                    case 0:
                        studentsDB.add(new TechStudents(name, surname, year, month, day));
                        break;
                    case 1:
                        studentsDB.add(new HumanStudents(name, surname, year, month, day));
                        break;
                    case 2:
                        studentsDB.add(new CombStudents(name, surname, year, month, day));
                        break;
                }
                
                String selectQuery2 = "SELECT students.studentId, marks.mark FROM students INNER JOIN marks ON marks.studentId = students.studentId;";

                try (PreparedStatement prStmt2 = conn.prepareStatement(selectQuery2);
                    ResultSet rs2 = prStmt2.executeQuery())
                {
                    while(rs2.next())
                    {
                        if(id == rs2.getInt("studentId"))
                        {
                            Test.getStudentByID(studentsDB, Students.getIDCount()).addMark(rs2.getFloat("mark"));
                        }
                    }
            
                }
                catch (SQLException e)
                {
                }

            }
            
        }
        catch (SQLException e)
        {
        }
        return studentsDB;
    }

    public static void deleteDB()
    {
        Connection conn = DBConnection.getDBConnection();

        try
        {
        Statement stmt = conn.createStatement();

        String sql = "DELETE FROM marks";; // Use delete
        stmt.executeUpdate(sql); // Execute deletion

        sql = "DELETE FROM students"; // Use delete
        stmt.executeUpdate(sql); // Execute deletion

        }
        catch(Exception e)
        {
        }
    }
}
