package com.muratcelik.repository;

import com.muratcelik.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Murat Çelik
 */

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByName(String studentName);
}
