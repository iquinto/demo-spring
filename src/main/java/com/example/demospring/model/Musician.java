package com.example.demospring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Date birth;

    private Date death;

    @NotNull
    @Column(nullable = false)
    private String gender;


    @NotNull
    @Column(nullable = false)
    private String nationality;

    public Musician() {
    }

    public Musician(@NotNull String name, @NotNull Date birth, @NotNull String gender, @NotNull String nationality) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
    }
}
