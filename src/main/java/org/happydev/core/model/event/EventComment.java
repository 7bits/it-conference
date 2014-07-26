package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;

/**
 * A comment for the certain Event
 */
public class EventComment extends AbstractEntity {

    private CommentAuthor commentAuthor;
    private EventCommentType eventCommentType;
    private String commentText;
}
