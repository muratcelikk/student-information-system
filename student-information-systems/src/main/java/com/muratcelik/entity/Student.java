package com.muratcelik.entity;

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
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "number", length = 5)
    private Integer number;

    @Column(name = "classroom", length = 5)
    private Integer classroom;

    @Column(name = "explanation", length = 500)
    private String explanation;

    @ManyToMany
//    @Size(max = 2)
    private List<Lesson> lesson;
}
