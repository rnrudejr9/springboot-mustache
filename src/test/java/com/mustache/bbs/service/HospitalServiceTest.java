package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {
    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp(){
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("비즈니스 로직 잘되는지?")
    void add(){
        Mockito.when(hospitalRepository.save((any())))
                .thenReturn(Hospital.builder()
                        .id(1)
                        .roadNameAddress(" 2")
                        .businessStatusCode(13)
                        .hospitalName("병원")
                        .businessStatus(13)
                        .openServiceName("")
                        .openLocalGovernmentCode(1)
                        .totalNumberOfBeds(13)
                        .totalAreaSize(13)
                        .patientRoomCount(3)
                        .managementNumber("dg")
                        .healthcareProviderCount(3)
                                .build()
                        );
        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        assertEquals("폐업",hospitalResponse.getBusinessStatusName());

//        hospital.getId(),
//                hospital.getRoadNameAddress(), hospital.getHospitalName(),
//                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
//                hospital.getTotalAreaSize());
    }

}