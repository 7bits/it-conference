package org.happydev.lite.service;

import org.happydev.lite.model.content.Speciality;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Specialities
 */
public class SpecialityPresenter {

    /**
     * Finds concrete Speciality
     * @param id an ID of the Speciality
     * @return an Speciality object or null when ID is wrong
     */
    public Speciality findSpecialityById(final Long id) {
        return new Speciality();
    }

    /**
     * Finds all Specialities for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of the Speciality objects
     */
    public List<Speciality> findSpecialitiesByHallEventId(final Long hallEventId) {
        return new ArrayList<Speciality>();
    }
}
