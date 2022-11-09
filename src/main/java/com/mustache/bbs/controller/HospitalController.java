package com.mustache.bbs.controller;

import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.domain.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value="/hospital")
@Controller
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @RequestMapping("/all")
    public String hospital(Model model){
        List<Hospital> list =hospitalRepository.findAll();
        model.addAttribute("list",list);
        log.info(list.get(0).getHospitalName());
        return "/articles/hospital";
    }
}
