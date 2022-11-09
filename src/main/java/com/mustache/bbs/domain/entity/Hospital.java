package com.mustache.bbs.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Table(name="nation_wide_hospitals")
public class Hospital {
    @Id
    private Integer id;
    @Column
    private String openServiceName;
    @Column
    private int openLocalGovernmentCode;
    @Column
    private String managementNumber;
    @Column
    private LocalDateTime licenseDate;
    @Column
    private int businessStatus;
    @Column
    private int businessStatusCode;
    @Column
    private String phone;
    @Column
    private String fullAddress;
    @Column
    private String roadNameAddress;
    @Column
    private String hospitalName;
    @Column
    private String businessTypeName;
    @Column
    private int healthcareProviderCount;
    @Column
    private int patientRoomCount;
    @Column
    private int totalNumberOfBeds;
    @Column
    private float totalAreaSize;

}
