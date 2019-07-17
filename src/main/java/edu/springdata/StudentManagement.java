package edu.springdata;

import edu.springdata.dao.StudentJdbcDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJdbcDao dao = context.getBean("studentJdbcDao", StudentJdbcDao.class);
    }
}
