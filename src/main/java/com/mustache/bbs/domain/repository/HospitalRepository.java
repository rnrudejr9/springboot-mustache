package com.mustache.bbs.domain.repository;

import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);
    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(Integer a, Integer b);
}
