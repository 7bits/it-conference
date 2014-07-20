package org.happydev.lite.model.content;

import org.happydev.lite.model.schedule.RoomEventType;

import java.util.List;

/**
 * An accepted content of the certain Event.
 */
public class RoomEventDetails {

    private Long id;
    private String title;
    private String description;
    private List<Speciality> specialities;
    private RoomEventType roomEventType;
    private EventBranch eventBranch;
    private List<Speaker> speakers;
    private TalkRequest talkRequest;
    private List<CreativeMaterial> materials;
}
