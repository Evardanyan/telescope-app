package com.epam.telescope.model;

import com.epam.telescope.model.enums.Degree;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "education")
public class Education {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "institution")
    private String institution;

    @Column(name = "college")
    private String college;

    @Column(name = "department")
    private String department;

    @Column(name = "degree")
    private Degree degree;

    @Column(name = "graduation_year")
    private int graduationYear;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "is_incomplete")
    private boolean isIncomplete;
}