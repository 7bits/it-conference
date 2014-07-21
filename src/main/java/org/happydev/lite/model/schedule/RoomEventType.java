package org.happydev.lite.model.schedule;

import org.happydev.lite.model.NamedType;
import org.happydev.lite.model.WrongTypeNameException;

/**
 * A type of the Talk
 */
public class RoomEventType extends NamedType {

    /**
     * A type for reports
     */
    public static final String REPORT_TYPE_NAME = "Report";
    /**
     * A type for workshop
     */
    public static final String WORKSHOP_TYPE_NAME = "Workshop";
    /**
     * A type for discussion
     */
    public static final String DISCUSSION_TYPE_NAME = "Discussion";
    /**
     * A type for barcamp
     */
    public static final String BARCAMP_TYPE_NAME = "Barcamp";
    /**
     * A type for break
     */
    public static final String BREAK_TYPE_NAME = "Break";
    /**
     * A type for coffee pause
     */
    public static final String COFFEE_PAUSE_TYPE_NAME = "Coffee";
    /**
     * A type for breakfast
     */
    public static final String BREAKFAST_TYPE_NAME = "Breakfast";
    /**
     * A type for lunch
     */
    public static final String LUNCH_TYPE_NAME = "Lunch";
    /**
     * A type for dinner
     */
    public static final String DINNER_TYPE_NAME = "Dinner";
    /**
     * A type for supper
     */
    public static final String SUPPER_TYPE_NAME = "Supper";

    /**
     * Default constructor by name
     * @param name a type name
     */
    public RoomEventType(final String name) {
        super(name);
    }

    @Override
    public RoomEventType getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case REPORT_TYPE_NAME:
            case WORKSHOP_TYPE_NAME:
            case DISCUSSION_TYPE_NAME:
            case BARCAMP_TYPE_NAME:
            case BREAK_TYPE_NAME:
            case COFFEE_PAUSE_TYPE_NAME:
            case BREAKFAST_TYPE_NAME:
            case LUNCH_TYPE_NAME:
            case DINNER_TYPE_NAME:
            case SUPPER_TYPE_NAME:
                return new RoomEventType(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
