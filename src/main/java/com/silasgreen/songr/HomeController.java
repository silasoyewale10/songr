package com.silasgreen.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumReactionRepository albumReactionRepository;
    @GetMapping("/hello")
    public String sayHello(Model m) {
    return "hello";
    }

    @GetMapping("/")
    public String getHome(@RequestParam(defaultValue = "Silas", required=false) String potato, Model m){
        System.out.println(potato);
        m.addAttribute("username", potato);
        return "home";
    }

    @GetMapping("/albums")
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
        return new RedirectView("/albums");
    }

    @PostMapping("/albums/delete/{id}")
    public RedirectView deleteAnAlbum(@PathVariable long id){
        System.out.println("trying to delete our album with the id of " + id);
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }
    @PostMapping("/reaction")
    public RedirectView addSong(long id, String title, int length, int trackNumber){
        //find the right album,
        Album myAlbum = albumRepository.getOne(id);
        // make a new reaction with the deets of a form.
//        ReactionToAlbum newReaction = new ReactionToAlbum(action, intensity);
        Song newSong = new Song(title, length, trackNumber);
        newSong.album = myAlbum;
        //add the reaction to the expression
        newSong.album = myAlbum;
        //save the reaction
        albumReactionRepository.save(newSong);
        //redirect them
        return new RedirectView("/albums");
    }



    @GetMapping("/capitalize/{anything}")
    public String makeUpperCase(@PathVariable String anything, Model m){
        m.addAttribute("text", anything);
        return "capitalize";
    }
    @GetMapping("/pacMan")
    public String getPacMan(){
        return "pacman";
    }
    @GetMapping("/portal")
    public RedirectView goSomewhereElseThroughAPortal(){
        System.out.println("u went through a portal");
        return new RedirectView("/pacMan");
    }
    @GetMapping("/narnia")
    public RedirectView goThroughNarnia(){
        System.out.println("Through narnia portal");
        return new RedirectView("/portal");
    }


}
