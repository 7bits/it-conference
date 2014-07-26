package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;

/**
 * An author of the comment for the concrete Event
 */
public class CommentAuthor extends AbstractEntity {

    private HallEvent hallEvent;
    private String firstName;
    private String middleName;
    private String location;
    private String company;
    private String jobPosition;
    private Picture picture;
}
