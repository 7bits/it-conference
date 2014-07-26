package org.happydev.core.model.content;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.social.Company;
import org.happydev.core.model.social.User;

import java.util.List;

/**
 * A Speaker of the concrete Hall event with Room events (talks) he does, may correspond to several Event branches.
 * All Event branches should belong to the same Hall event.
 */
public class Speaker extends AbstractEntity {

    private User user;
    private Company company;
    private String selfDescription;
    private Picture picture;
    /** Many to many relationship */
    private List<RoomEvent> roomEvents;
}
