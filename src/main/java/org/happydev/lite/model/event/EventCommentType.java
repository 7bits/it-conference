package org.happydev.lite.model.event;

/**
 * A type of the Event comment
 */
public class EventCommentType {

    /**
     * A type for comments before Event
     */
    public static final String BEFORE_COMMENT_TYPE_NAME = "BeforeComment";
    /**
     * A type for comments after Event
     */
    public static final String AFTER_COMMENT_TYPE_NAME = "AfterComment";

    private Long id;
    private String name;
}
