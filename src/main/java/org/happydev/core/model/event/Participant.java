package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.social.User;

/**
 * A participant of the concrete Event
 */
public class Participant extends AbstractEntity {

    private User user;
    private HallEvent hallEvent;
    private String selfDescription;
    private Picture photo;
}
