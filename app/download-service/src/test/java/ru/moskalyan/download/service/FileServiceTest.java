package ru.moskalyan.download.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.moskalyan.download.service.services.FileService;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    public void downloadVideoTest() {
        fileService.downloadVideo(Collections.singletonList("video/videoplayback.mp4"));
    }
}
