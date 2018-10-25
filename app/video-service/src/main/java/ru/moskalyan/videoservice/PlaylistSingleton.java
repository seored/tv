package ru.moskalyan.videoservice;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PlaylistSingleton {

    private Playlist current;

    @PostConstruct
    public void init() {
        Playlist start = new Playlist();
        start.setVal("http://localhost:8080/Users/pavel/movie.mp4");
        Playlist next = new Playlist();
        next.setVal("http://localhost:8080/Users/pavel/movie1.mp4");
        start.setNext(next);
        Playlist next2 = new Playlist();
        next2.setVal("http://localhost:8080/Users/pavel/movie2.mp4");
        next.setNext(next);
        next2.setNext(start);
    }

    public Playlist getCurrent() {
        Playlist result = current;
        current = current.getNext();
        return result;
    }
}
