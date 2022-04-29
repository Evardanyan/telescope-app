package com.epam.telescope.model;

import com.epam.telescope.model.enums.ProjectHealthStatus;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "project_health")
    private ProjectHealthStatus projectHealth;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> technologies;

    @Column(name="profile_id")
    @ElementCollection
    @CollectionTable(name = "profile_project",
            joinColumns = {@JoinColumn(name = "project_id")})
    private Set<Long> assignedProfileIds;
}