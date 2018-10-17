package ru.moskalyan.audio.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AudioPlayerKafkaListener {

    @KafkaListener(topics = {"moskalian-update-playlist"})
    public void updatePlayList() {

    }
}
