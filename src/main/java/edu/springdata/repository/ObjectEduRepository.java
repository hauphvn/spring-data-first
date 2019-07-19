package edu.springdata.repository;

import edu.springdata.model.ObjectEdu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjectEduRepository extends JpaRepository<ObjectEdu, Integer> {
    ObjectEdu findByName(String name);

    @Query("from ObjectEdu")
    List<ObjectEdu> getAllObjectHauphn();
}
