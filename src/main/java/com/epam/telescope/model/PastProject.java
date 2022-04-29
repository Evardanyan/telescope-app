package com.epam.telescope.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "past_project")
public class PastProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "customer")
    private String customer;

    @Column(name = "description")
    private String description;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_url")
    private String companyUrl;

    @Column(name = "tools")
    private String tools;

    @Column(name = "technologies")
    private String technologies;

    @Column(name = "participation")
    private String participation;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "database_name")
    private String database;

    @Column(name = "team")
    private String team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "epam_project")
    private Project epamProject;
}
