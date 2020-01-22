package com.silasgreen.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;
    @GetMapping("/hello")
    public String sayHello(Model m) {
    return "hello";
    }

    @GetMapping("/albumsPotato")
    public String album(Model m) {
//        Album [] albums = new Album [] {new Album ("Saphire", "Justina Guus", 12, 600, "www.guus.com"),
//                                        new Album("Jasper", "Angelina Dondan",20, 1200, "www.beubeu.com"),
//                                        new Album ("Onyx", "Beulah Stradforshire", 47, 1930, "www.merrying.com")};
        List<Album> albums = albumRepository.findAll();
                m.addAttribute("AlbumList", albums);

        return "albums";
    }
    @PostMapping("/albums") //whatever i get from the form can be set here as a parameter.
    public RedirectView postAlbums(String albumTitle, String albumArtist, int albumSongCount, int albumLengthInSeconds, String albumImageUrl){  //data is expected to come back in the body for posts
        Album newAlbum = new Album(albumTitle, albumArtist, albumSongCount, albumLengthInSeconds, albumImageUrl);
        albumRepository.save(newAlbum);
//        return "albums"; instead of sending me to the albums page, I am redirecting myself to the /albums url.
        return new RedirectView("/albumsPotato");
    }


    @GetMapping("/capitalize/{anything}")
    public String makeUpperCase(@PathVariable String anything, Model m){
        m.addAttribute("text", anything);
        return "capitalize";
    }

}
