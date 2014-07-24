package org.happydev.lite.model.event;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.Company;

import java.util.List;

/**
 * A certain event at a certain Hall and certain time
 */
public class HallEvent extends AbstractEntity {

    private String name;
    private String description;
    private HallEventType type;
    private Hall place;
    private Long startTime;
    private Long endTime;
    private Long timeSlotInMinutes;
    private Long registrationStartTime;
    /** Reverse link */
    private List<Company> partners;
}
