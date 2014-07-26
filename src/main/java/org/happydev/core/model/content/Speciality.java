package org.happydev.core.model.content;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.event.HallEvent;

import java.util.List;

/**
 * A professional speciality of the Event branch or a talk
 */
public class Speciality extends AbstractEntity {
    private String name;
    private String description;
    private HallEvent hallEvent;
    private Picture picture;
    /** Many to many relationship */
    private List<RoomEvent> roomEvents;
    /** Many to many relationship */
    private List<EventBranch> eventBranches;
}
