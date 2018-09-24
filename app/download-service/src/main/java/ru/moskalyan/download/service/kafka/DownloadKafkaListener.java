package ru.moskalyan.download.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.moskalyan.download.service.dto.DownloadRequestDto;
import ru.moskalyan.download.service.services.FileService;

import java.util.Collections;

@Component
public class DownloadKafkaListener {

    @Autowired
    private FileService fileService;

    @KafkaListener(topics = {"moskalyan-download-video-topic"})
    public Object downloadVideoListener(DownloadRequestDto requestDto) {
        fileService.downloadVideo(Collections.singletonList("video/videoplayback.mp4"));
        return null;
    }

}
