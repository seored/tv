package ru.moskalyan.audio;

public class Application {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        AudioPlaylist audioPlayList = new AudioPlaylist("./app/audio-service/song.mp3");//C:\project\tv\app\audio-service\song.mp3
        audioPlayList.setNext(audioPlayList);
        audioPlayList.setPrev(audioPlayList);

        AudioPlaylist current = audioPlayList;
        while(current.hasNext()) {
            player.play(current.getSong());
            current = current.getNext();
        }
    }
}
