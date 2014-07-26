package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.social.Company;

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
    private Picture defaultPersonPhoto;
    private Picture defaultCompanyLogo;
    private Picture defaultSpecialityPicture;
    private Picture defaultBranchLeaderPhoto;
    private Picture defaultSpeakerPhoto;
    private Picture defaultEventBranchPicture;
    /** Reverse link */
    private List<Company> partners;
}
