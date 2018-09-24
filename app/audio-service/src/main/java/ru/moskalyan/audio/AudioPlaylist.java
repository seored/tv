package ru.moskalyan.audio;

public class AudioPlaylist {

    private AudioPlaylist next;
    private AudioPlaylist prev;
    private String song;

    public AudioPlaylist(String song) {
        this.song = song;
        next = null;
        prev = null;
    }

    public boolean hasNext() {
        return next == null;
    }

    public AudioPlaylist getNext() {
        return next;
    }

    public void setNext(AudioPlaylist next) {
        this.next = next;
    }

    public AudioPlaylist getPrev() {
        return prev;
    }

    public void setPrev(AudioPlaylist prev) {
        this.prev = prev;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
