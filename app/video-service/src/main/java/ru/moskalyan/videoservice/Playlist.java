package ru.moskalyan.videoservice;

import lombok.Data;

@Data
public class Playlist {
    private Playlist next;
    private String val;
}
