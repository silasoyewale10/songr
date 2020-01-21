package com.silasgreen.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(@RequestParam(defaultValue = "rufus", required=false)String potato, Model m){
        System.out.println(potato);
        m.addAttribute("username" , potato);
        return "home";
    }
    @GetMapping("/emotions")
    public String getEmotions(Model m){
        Emotion [] emotions = new Emotion [] {new Emotion("great",10, "done"), new Emotion("stressed", 3,"deep")};
        m.addAttribute("emotionLis", emotions);
        return "emotions";
    }

}
