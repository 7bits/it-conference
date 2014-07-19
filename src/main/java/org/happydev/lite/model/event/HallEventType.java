package org.happydev.lite.model.event;

/**
 * A type of the Event
 */
public class HallEventType {

    /**
     * A type for conferences
     */
    public static final String CONFERENCE_TYPE_NAME = "Conference";
    /**
     * A type for hackathons
     */
    public static final String HACKATHON_TYPE_NAME = "Hackathon";

    private Long id;
    private String name;
}
