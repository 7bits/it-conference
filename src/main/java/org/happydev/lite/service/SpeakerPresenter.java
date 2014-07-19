package org.happydev.lite.service;

import org.happydev.lite.model.content.Speaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Speakers
 */
public class SpeakerPresenter {

    /**
     * Finds concrete Speaker
     * @param id an ID of the Speaker
     * @return a Speaker object or null when the ID is wrong
     */
    public Speaker findSpeakerById(final Long id) {
        return new Speaker();
    }

    /**
     * Finds all Speakers for the concrete Event Branch
     * @param branchId an ID of the Branch
     * @return a list of Speaker objects
     */
    public List<Speaker> findSpeakersByBranchId(final Long branchId) {
        return new ArrayList<Speaker>();
    }

    /**
     * Finds all Speakers for the concrete Speciality
     * @param specialityId an ID of the Speciality
     * @return a list of Speaker objects
     */
    public List<Speaker> findSpeakersBySpecialityId(final Long specialityId) {
        return new ArrayList<Speaker>();
    }

    /**
     * Finds all Speakers without talks for the concrete Hall Event
     * @param eventId an ID of the Hall Event
     * @return a list of Speaker objects
     */
    public List<Speaker> findSpeakersByEventId(final Long eventId) {
        return new ArrayList<Speaker>();
    }
}
