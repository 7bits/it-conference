package org.happydev.lite.model.event;

import org.happydev.lite.model.social.Company;

import java.util.List;

/**
 * A certain event at a certain hall and certain time
 */
public class HallEvent {

    private Long id;
    private HallEventType type;
    private Long ordinalNumber;
    private Long startTime;
    private Long endTime;
    private Long timeSlotInMinutes;
    private Long registrationStartTime;
    private List<Company> partners;
    private Hall place;
}
