package ru.moskalyan.audio;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class AudioPlaylist {

    //"Settings > Build > Compiler > Annotation Processors"
    @Getter @Setter(AccessLevel.PUBLIC) private AudioPlaylist next;
    @Getter @Setter (AccessLevel.PUBLIC) private AudioPlaylist prev;
    @Getter @Setter(AccessLevel.PUBLIC) private String song;

    public AudioPlaylist(String song) {
        this.song = song;
        next = null;
        prev = null;
    }

    public boolean hasNext() {
        return next != null;
    }
}
