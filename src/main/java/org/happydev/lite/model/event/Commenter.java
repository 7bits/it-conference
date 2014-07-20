package org.happydev.lite.model.event;

import org.happydev.lite.model.social.User;

/**
 * An author of the comment for the concrete Event
 */
public class Commenter {

    private Long id;
    private User user;
    private String photoFileName;
    private HallEvent hallEvent;
}
