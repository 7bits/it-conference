package org.happydev.lite.model.event;

import org.happydev.lite.model.schedule.Room;
import org.happydev.lite.model.social.Location;

import java.util.List;

/**
 * A place for events
 */
public class Hall {

    private Long id;
    private String name;
    private String description;
    private Location location;
    private List<Room> rooms;
    private List<HallEventType> possibleTypes;
}
