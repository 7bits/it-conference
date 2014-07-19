package org.happydev.lite.model.content;

import org.happydev.lite.model.schedule.RoomEvent;
import org.happydev.lite.model.social.User;

import java.util.List;

/**
 * A Speaker of the concrete Hall event with Talks he does, may correspond to several Event branches.
 * All Event branches should belong to the same Hall event.
 */
public class Speaker {

    private Long id;
    private User user;
    private String photoFileName;
    private List<EventBranch> eventBranches;
    private List<RoomEvent> roomEvents;
}
