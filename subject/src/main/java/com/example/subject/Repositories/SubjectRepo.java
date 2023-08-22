package com.example.subject.Repositories;

import com.example.subject.Entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {

    @Query("SELECT s FROM Subject s WHERE s.class_id = :classId")
    List<Subject> findByClassId(Long classId);
    @Query("SELECT s FROM Subject s WHERE s.id_Teacher = :classId")
    List<Subject> findByTeacherId(Long classId);
}
