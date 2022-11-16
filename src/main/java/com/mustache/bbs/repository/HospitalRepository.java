package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);
    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(Integer a, Integer b);
    boolean existsById(String key);
}
