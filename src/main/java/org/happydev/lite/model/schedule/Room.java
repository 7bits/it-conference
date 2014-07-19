package org.happydev.lite.model.schedule;

import org.happydev.lite.model.event.Hall;

import java.util.List;

/**
 * A concrete room at the Event hall
 */
public class Room {

    private Long id;
    private String name;
    private String description;
    private Hall hall;
    private String internalLocation;
    private Long placeCount;
    private List<RoomEventType> possibleTypes;
}
