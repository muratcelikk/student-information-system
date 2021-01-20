package com.muratcelik.repository;

import com.muratcelik.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Murat Çelik
 */

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Integer> {
}
