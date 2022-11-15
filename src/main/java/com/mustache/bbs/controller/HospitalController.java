package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.domain.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value="/hospital")
@Controller
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Page<Hospital> getList(Pageable pageable){
        return hospitalRepository.findAll(pageable);
    }
    @RequestMapping("/all")
    public String hospitalShow(@PageableDefault(size=10,sort="id",direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Hospital> list =hospitalRepository.findAll(pageable);
        log.info("hello222");
        model.addAttribute("list",list);
        model.addAttribute("previous",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "articles/hospital";
    }

    @RequestMapping("/{road}")
    public String findByValue(@PageableDefault(size=10,sort="id",direction = Sort.Direction.DESC) Pageable pageable, Model model, @RequestParam String road){
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        model.addAttribute(hospitals);
        return "articles/hospitalname";
    }

}

