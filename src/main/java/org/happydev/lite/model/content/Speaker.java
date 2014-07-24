package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.Company;
import org.happydev.lite.model.social.User;

import java.util.List;

/**
 * A Speaker of the concrete Hall event with Room events (talks) he does, may correspond to several Event branches.
 * All Event branches should belong to the same Hall event.
 */
public class Speaker extends AbstractEntity {

    private User user;
    private Company company;
    private String systemPhotoFileName;
    private String publicPhotoFileName;
    /** Many to many relationship */
    private List<RoomEvent> roomEvents;
}
