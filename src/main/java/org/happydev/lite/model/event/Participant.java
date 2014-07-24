package org.happydev.lite.model.event;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.User;

/**
 * A participant of the concrete Event
 */
public class Participant extends AbstractEntity {

    private User user;
    private HallEvent hallEvent;
    private String systemPhotoFileName;
    private String publicPhotoFileName;
}
