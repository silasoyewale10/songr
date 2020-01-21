package com.silasgreen.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String sayHello(Model m) {
    return "hello";
    }

    @GetMapping("/albums")
    public String album(Model m) {
        Album [] albums = new Album [] {new Album ("Saphire", "Justina Guus", 12, 600, "www.guus.com"),
                                        new Album("Jasper", "Angelina Dondan",20, 1200, "www.beubeu.com"),
                                        new Album ("Onyx", "Beulah Stradforshire", 47, 1930, "www.merrying.com")};
        m.addAttribute("AlbumList", albums);
        return "albums";
    }
    @GetMapping("/capitalize/{anything}")
    public String makeUpperCase(@PathVariable String anything, Model m){
        m.addAttribute("text", anything);
        return "capitalize";
    }

}
