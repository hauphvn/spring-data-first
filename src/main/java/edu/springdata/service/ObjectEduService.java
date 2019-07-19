package edu.springdata.service;

import edu.springdata.dao.ObjectHibernateDao;
import edu.springdata.model.ObjectEdu;
import edu.springdata.repository.ObjectEduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectEduService {

    /*
    Cach truyen thong, khong su dung repository jpa
    @Autowired
    private ObjectHibernateDao objectHibernateDao;

    public void save(ObjectEdu objectEdu){
        objectHibernateDao.save(objectEdu);
    }
     */

    //Su dung Repository Jpa
    @Autowired
    private ObjectEduRepository objectEduRepository;

    public void save(ObjectEdu objectEdu){
        objectEduRepository.save(objectEdu);
    }

    public void test(){
//        System.out.println(objectEduRepository.count());
//        System.out.println(objectEduRepository.findAll());
//        System.out.println(objectEduRepository.findByName("Math"));
        System.out.println(objectEduRepository.getAllObjectHauphn());
    }

}
