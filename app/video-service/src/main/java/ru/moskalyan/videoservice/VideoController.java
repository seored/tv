package ru.moskalyan.videoservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    int i = 0;
    String[] list = {"http://localhost:8080/Users/pavel/movie.mp4",
            "http://localhost:8080/Users/pavel/movie1.mp4",
            "http://localhost:8080/Users/pavel/movie2.mp4"};

    @RequestMapping("/video")
    public String nextVideo() {
        String result = list[i];
        i++;
        return result;
    }
}
