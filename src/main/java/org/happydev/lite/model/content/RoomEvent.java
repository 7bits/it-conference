package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.event.Room;

import java.util.List;

/**
 * A room event at the certain room and certain time
 */
public class RoomEvent extends AbstractEntity {

    private String title;
    private String description;
    private RoomEventType roomEventType;
    private Room room;
    private Long startTimeSlot;
    private Long timeSlotQuantity;
    private EventBranch eventBranch;
    private TalkRequest talkRequest;
    /** Many to many relationship */
    private List<Speaker> speakers;
    /** Many to many relationship */
    private List<Speciality> specialities;
    /** Reverse link */
    private List<CreativeMaterial> creativeMaterials;
}
