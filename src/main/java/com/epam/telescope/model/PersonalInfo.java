package com.epam.telescope.model;

import com.epam.telescope.model.enums.Gender;
import com.epam.telescope.model.enums.TShirtSize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "personal_info")
public class PersonalInfo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "native_name")
    private String nativeName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "governmental_id")
    private String governmentalId;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column(name = "t_shirt_size")
    private TShirtSize tShirtSize;

    @Column(name = "remote_work_possibility")
    private boolean remoteWorkPossibility;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "personalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children;

    @OneToMany(mappedBy = "personalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
    
    @OneToOne(mappedBy = "personalInfo")
    private Profile profile;
}