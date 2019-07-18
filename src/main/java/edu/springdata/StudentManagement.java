package edu.springdata;

import edu.springdata.dao.StudentJdbcTemplateDao;
import edu.springdata.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcTemplateDao dao = context.getBean("studentJdbcTemplateDao", StudentJdbcTemplateDao.class);
//        dao.insertStudent(new Student(10,"jack","code jack"));
//        dao.deleteStudent(10);
//        System.out.println(dao.getAllStudent());
        System.out.println(dao.countStudent());

    }
}
