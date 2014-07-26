package org.happydev.core.model.event;

import org.happydev.core.model.NamedType;
import org.happydev.core.model.WrongTypeNameException;

/**
 * A type of the Event comment
 */
public class EventCommentType extends NamedType {

    /**
     * A type for comments before Event
     */
    public static final String BEFORE_COMMENT_TYPE_NAME = "BeforeComment";
    /**
     * A type for comments after Event
     */
    public static final String AFTER_COMMENT_TYPE_NAME = "AfterComment";

    /**
     * Default constructor by name
     * @param name a type name
     */
    public EventCommentType(final String name) {
        super(name);
    }

    @Override
    public EventCommentType getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case BEFORE_COMMENT_TYPE_NAME:
            case AFTER_COMMENT_TYPE_NAME:
                return new EventCommentType(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
