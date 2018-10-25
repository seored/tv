package ru.moskalyan.videoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired
    private PlaylistSingleton singleton;

    int i = 0;

    @RequestMapping("/video")
    public ResponseDTO nextVideo() {
        Playlist playlist = singleton.getCurrent();
        ResponseDTO dto = new ResponseDTO();
        dto.setSortId(i);
        dto.setSrc(playlist.getVal());
        dto.setType("video/mp4");
        i++;
        return dto;
    }
}
