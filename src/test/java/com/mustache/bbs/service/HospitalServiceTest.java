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
                .thenReturn(new Hospital(1,"",3,"",null,13,13,"","","","","",2,2,2,3)
                        );
        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
        assertEquals("폐업",hospitalResponse.getBusinessStatusName());

//        hospital.getId(),
//                hospital.getRoadNameAddress(), hospital.getHospitalName(),
//                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
//                hospital.getTotalAreaSize());
    }

}