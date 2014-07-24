package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.event.HallEvent;

import java.util.List;

/**
 * A professional speciality of the Event branch or a talk
 */
public class Speciality extends AbstractEntity {
    private String name;
    private String description;
    private HallEvent hallEvent;
    private String systemPhotoFileName;
    private String publicPhotoFileName;
    /** Many to many relationship */
    private List<RoomEvent> roomEvents;
}
