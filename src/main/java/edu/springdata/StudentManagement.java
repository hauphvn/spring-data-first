package edu.springdata;

import edu.springdata.model.ObjectEdu;
import edu.springdata.service.ObjectEduService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        StudentJdbcDaoSupport dao = context.getBean("studentJdbcDaoSupport", StudentJdbcDaoSupport.class);
//        dao.insertStudent(new Student(10,"jack","code jack"));
//        dao.deleteStudent(10);
//        System.out.println(dao.getAllStudent());
//        System.out.println(dao.countStudent());
//        System.out.println(dao.getStudentById(6));

//        ObjectHibernateDao dao = context.getBean("objectHibernateDao", ObjectHibernateDao.class);
//        dao.save(new ObjectEdu("Math"));

        ObjectEduService objectEduService = context.getBean("objectEduService", ObjectEduService.class);
//        objectEduService.save(new ObjectEdu("Physical"));
//        objectEduService.save(new ObjectEdu("Math"));
        objectEduService.test();

    }
}
