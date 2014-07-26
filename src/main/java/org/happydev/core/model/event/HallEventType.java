package org.happydev.core.model.event;

import org.happydev.core.model.NamedType;
import org.happydev.core.model.WrongTypeNameException;

/**
 * A type of the Hall event
 */
public class HallEventType extends NamedType {

    /**
     * A type for conferences
     */
    public static final String CONFERENCE_TYPE_NAME = "Conference";
    /**
     * A type for hackathons
     */
    public static final String HACKATHON_TYPE_NAME = "Hackathon";

    /**
     * Default constructor by name
     * @param name a type name
     */
    public HallEventType(final String name) {
        super(name);
    }

    @Override
    public HallEventType getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case CONFERENCE_TYPE_NAME:
            case HACKATHON_TYPE_NAME:
                return new HallEventType(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
