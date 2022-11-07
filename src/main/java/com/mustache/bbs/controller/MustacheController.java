package com.mustache.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
    public class MustacheController {

        @GetMapping(value = "/hi")
        public String mustacheCon(Model model) {
            model.addAttribute("username", "rok");
            return "greetings";
        }

        @GetMapping(value = "/hi/{id}")
        public String mustacheCon2(@PathVariable String id, Model model) {
            model.addAttribute("username", id);
            return "greetings";
        }
    }

