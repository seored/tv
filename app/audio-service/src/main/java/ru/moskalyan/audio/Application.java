package ru.moskalyan.audio;

public class Application {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        AudioPlaylist song1 = new AudioPlaylist("/Users/pavel/IdeaProjects/tv/app/audio-service/song.mp3");
        AudioPlaylist song2 = new AudioPlaylist("/Users/pavel/IdeaProjects/tv/app/audio-service/2.mp3");
        song1.setNext(song2);
        song1.setPrev(song2);
        song2.setNext(song1);
        song2.setPrev(song1);

        AudioPlaylist current = song1;
        while(current.hasNext()) {
            player.play(current.getSong());
            current = current.getNext();
        }
    }
}
