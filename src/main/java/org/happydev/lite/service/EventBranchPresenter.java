package org.happydev.lite.service;

import org.happydev.lite.model.content.EventBranch;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Event branches
 */
public class EventBranchPresenter {

    /**
     * Finds concrete Event branch
     * @param id an ID of the Branch
     * @return an EventBranch object or null when ID is wrong
     */
    public EventBranch findEventBranchById(final Long id) {
        return new EventBranch();
    }

    /**
     * Finds all Event branches for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of the EventBranch objects
     */
    public List<EventBranch> findEventBranchesByHallEventId(final Long hallEventId) {
        return new ArrayList<EventBranch>();
    }
}
