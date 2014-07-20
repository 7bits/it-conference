package org.happydev.lite.service;

import org.happydev.lite.model.event.EventComment;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Event comments
 */
public class CommentPresenter {

    /**
     * Finds concrete Event comment
     * @param id an ID of the Event comment
     * @return a EventComment object or null when the ID is wrong
     */
    public EventComment findEventCommentById(final Long id) {
        return new EventComment();
    }

    /**
     * Finds all Event comments for the concrete Hall Event
     * @param eventId an ID of the Hall Event
     * @return a list of EventComment objects
     */
    public List<EventComment> findAllEventCommentsByEventId(final Long eventId) {
        return new ArrayList<EventComment>();
    }

    /**
     * Finds all Before event comments for the concrete Hall Event
     * @param eventId an ID of the Hall Event
     * @return a list of EventComment objects
     */
    public List<EventComment> findBeforeEventCommentsByEventId(final Long eventId) {
        return new ArrayList<EventComment>();
    }

    /**
     * Finds all After event comments for the concrete Hall Event
     * @param eventId an ID of the Hall Event
     * @return a list of EventComment objects
     */
    public List<EventComment> findAfterEventCommentsByEventId(final Long eventId) {
        return new ArrayList<EventComment>();
    }
}
