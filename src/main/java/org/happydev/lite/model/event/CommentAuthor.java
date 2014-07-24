package org.happydev.lite.model.event;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.User;

/**
 * An author of the comment for the concrete Event
 */
public class CommentAuthor extends AbstractEntity {

    private User user;
    private HallEvent hallEvent;
    private String systemPhotoFileName;
    private String publicPhotoFileName;
}
