package org.happydev.lite.model.event;

import org.happydev.lite.model.AbstractEntity;

/**
 * A comment for the certain Event
 */
public class EventComment extends AbstractEntity {

    private CommentAuthor commentAuthor;
    private EventCommentType eventCommentType;
    private String commentText;
}
