package com.mustache.bbs.domain.repository;

import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;
    @Test
    @DisplayName("typename : 보건소, 보건지소, 보건진료소 데이터 잘 나오는지?")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);


        for(var hospital: hospitals){
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    @DisplayName("containing, like test") // 포함 *(가운데)
    void findByContating() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");

        for(var hospital: hospitals){
            System.out.println(hospital.getHospitalName() + " " + hospital.getRoadNameAddress());
        }
    }
    @Test
    void findByStartsWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("연세");

        for(var hospital: hospitals){
            System.out.println(hospital.getHospitalName());
        }
    }
    @Test
    void findByEndsWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("치과");

        for(var hospital: hospitals){
            System.out.println(hospital.getHospitalName());
        }
    }
    @Test
    void findByPatientRoomCountBetween(){
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(8, 20);
        print(hospitals);
    }

    void print(List<Hospital> hospitals){
        for(var hospital : hospitals){
            System.out.println(hospital.getHospitalName() + " " + hospital.getPatientRoomCount());
        }
    }

}