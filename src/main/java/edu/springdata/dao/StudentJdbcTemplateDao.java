package edu.springdata.dao;

import edu.springdata.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentJdbcTemplateDao {
    private Connection connection = null;
    private Statement statement = null;


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Khong su dung jdbc template

    /*public void insertStudent(Student student){
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
    }*/

    //Su dung jdbc template
    public void insertStudent(Student student){
        String query = "insert into Student(id, code, name) values (" +
                ""+student.getId()+",'" + student.getCode()+"','"+student.getName()+"')";
        jdbcTemplate.execute(query);
        shutDown();
    }

    public void deleteStudent(int id){
        String query = "delete from Student where id = " + id;
        jdbcTemplate.execute(query);
        shutDown();
    }

    public int countStudent(){
        String query = "select count(*) from Student";
        int result = jdbcTemplate.queryForObject(query, Integer.class);
        shutDown();
        return result;
    }

    //Su dung Rowmapper de lay du lieu map voi 1 object trong java
    // su dung class StudentMapper ben duoi
    public Student getStudentById(int id){
        String query = "select * from Student where id = ?";
        return jdbcTemplate.queryForObject(query, new Integer[]{id}, new StudentMapper());
    }

    public List<Student> getAllStudent(){
        String query = "select * from Student";
        return jdbcTemplate.query(query, new StudentMapper());
    }

    //Khong su dung jdbc template and rowmapper
  /*  public List<Student> getAllStudent(){
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

    }*/



    private void createConnection(){
        if (connection == null){
            try {
                connection = dataSource.getConnection();
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

    private static final class StudentMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("code"));
        }
    }

}
