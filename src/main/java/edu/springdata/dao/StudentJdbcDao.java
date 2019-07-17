package edu.springdata.dao;

import edu.springdata.model.Student;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentJdbcDao {
    private String dbURL = "jdbc:mysql://localhost:3306/education";
    private Connection connection = null;
    private Statement statement = null;

    public void insertStudent(Student student){
        createConnection();
        try {
            statement = connection.createStatement();
            statement.execute("insert into Student(id, code, name) values (" +
                    ""+student.getId()+",'" + student.getCode()+"','"+student.getName()+"')");
            statement.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        shutDown();
    }

    public List<Student> getAllStudent(){
        createConnection();
        List<Student> studentList = new ArrayList<Student>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Student");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String code = resultSet.getString("code");
                studentList.add(new Student(id,name,code));
            }
            resultSet.close();
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        shutDown();
        return studentList;

    }

    private void createConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(dbURL,"root","1");
                if (connection == null){
                    System.out.println("Failed to make connection");
                }

            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }

    private void shutDown(){
        try {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
