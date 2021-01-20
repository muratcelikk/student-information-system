package com.muratcelik.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Murat Çelik
 */


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lessonCode", length = 20)
    private String lessonCode;

    @Column(name = "lessonName", length = 20)
    private String lessonName;

    @Column(name = "explanation", length = 500)
    private String explanation;

    @ManyToMany
    @JsonIgnore
    private List<Student> student;
}