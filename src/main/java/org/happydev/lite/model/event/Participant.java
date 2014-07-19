package org.happydev.lite.model.event;

import org.happydev.lite.model.social.User;

/**
 * A participant of the concrete Event
 */
public class Participant {

    private Long id;
    private User user;
    private HallEvent hallEvent;
}
