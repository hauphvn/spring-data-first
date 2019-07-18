package edu.springdata;

import edu.springdata.dao.StudentJdbcTemplateDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcTemplateDao dao = context.getBean("studentJdbcTemplateDao", StudentJdbcTemplateDao.class);
//        dao.insertStudent(new Student(10,"jack","code jack"));
        System.out.println(dao.getAllStudent());

    }
}
