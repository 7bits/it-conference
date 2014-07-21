package org.happydev.lite.service;

import org.happydev.lite.model.event.EventComment;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Event comments
 */
public class EventCommentPresenter {

    /**
     * Finds concrete Event comment
     * @param id an ID of the Event comment
     * @return a EventComment object or null when the ID is wrong
     */
    public EventComment findEventCommentById(final Long id) {
        return new EventComment();
    }

    /**
     * Finds all Event comments for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of EventComment objects
     */
    public List<EventComment> findAllEventCommentsByHallEventId(final Long hallEventId) {
        return new ArrayList<EventComment>();
    }

    /**
     * Finds all Before event comments for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of EventComment objects
     */
    public List<EventComment> findBeforeEventCommentsByHallEventId(final Long hallEventId) {
        return new ArrayList<EventComment>();
    }

    /**
     * Finds all After event comments for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of EventComment objects
     */
    public List<EventComment> findAfterEventCommentsByHallEventId(final Long hallEventId) {
        return new ArrayList<EventComment>();
    }
}
