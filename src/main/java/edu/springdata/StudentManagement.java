package edu.springdata;

import edu.springdata.dao.StudentJdbcDaoSupport;
import edu.springdata.dao.StudentJdbcTemplateDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcDaoSupport dao = context.getBean("studentJdbcDaoSupport", StudentJdbcDaoSupport.class);
//        dao.insertStudent(new Student(10,"jack","code jack"));
//        dao.deleteStudent(10);
        System.out.println(dao.getAllStudent());
//        System.out.println(dao.countStudent());
//        System.out.println(dao.getStudentById(6));

    }
}
