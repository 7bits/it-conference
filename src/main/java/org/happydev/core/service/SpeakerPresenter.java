package org.happydev.core.service;

import org.happydev.core.model.content.Speaker;

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
     * Finds all Speakers for the concrete Event branch
     * @param eventBranchId an ID of the Event branch
     * @return a list of Speaker objects
     */
    public List<Speaker> findSpeakersByEventBranchId(final Long eventBranchId) {
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
     * Finds all Speakers without talks for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of Speaker objects
     */
    public List<Speaker> findSpeakersByHallEventId(final Long hallEventId) {
        return new ArrayList<Speaker>();
    }
}
