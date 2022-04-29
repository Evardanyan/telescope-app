package com.epam.telescope.model;

import com.epam.telescope.model.enums.JobFunctionLevel;
import com.epam.telescope.model.enums.JobStatus;
import com.epam.telescope.model.enums.Language;
import com.epam.telescope.model.enums.LanguageLevel;
import com.epam.telescope.model.enums.ProductionCategory;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.util.Map;

@Data
@Entity
@Table(name = "general_info")
public class GeneralInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_status")
    private JobStatus jobStatus;

    @Column(name = "production_category")
    private ProductionCategory productionCategory;

    @Column(name = "job_function")
    private String jobFunction;

    @Column(name = "job_function_level")
    private JobFunctionLevel jobFunctionLevel;

    @Column(name = "unit")
    private String unit;

    @Column(name = "unit_manager")
    private String unitManager;

    @Column(name = "uid")
    private Long uid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_skill_id")
    private Skill primarySkill;

    @ElementCollection
    @CollectionTable(name = "language_level_map",
            joinColumns = {@JoinColumn(name = "general_info_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
    @Column(name = "level")
    private Map<Language, LanguageLevel> languages;
}