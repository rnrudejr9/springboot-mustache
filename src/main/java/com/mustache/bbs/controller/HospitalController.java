package com.mustache.bbs.controller;

import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/hospital")
@Controller
public class HospitalController {
    private final HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public Page<Hospital> getList(Pageable pageable){
        return hospitalRepository.findAll(pageable);
    }
    @GetMapping("/list")
    public String hospitalList(Model model, @PageableDefault(page=1, size=20)
    @SortDefault.SortDefaults({@SortDefault(sort="healthcare_provider_count",
            direction = Sort.Direction.DESC),
            @SortDefault(sort = "patient_room_count",
                    direction = Sort.Direction.DESC)}) Pageable pageable){
        Page<Hospital> hospitalList = hospitalRepository.findAll(pageable);
        // pageable을 받고 Page<>의 형태로 넣기
        log.info("hello");

        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "articles/hospital";
    }

}

