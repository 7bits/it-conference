package org.happydev.lite.service;

import org.happydev.lite.model.schedule.RoomEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Room events (talks, discussions, lunches etc)
 */
public class RoomEventPresenter {

    /**
     * Finds concrete Room events
     * @param id an ID of the Room event
     * @return a RoomEvent object or null when the ID is wrong
     */
    public RoomEvent findRoomEventById(final Long id) {
        return new RoomEvent();
    }

    /**
     * Finds all Room events for the concrete Event branch
     * @param branchId an ID of the EventBranch
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByBranchId(final Long branchId) {
        return new ArrayList<RoomEvent>();
    }

    /**
     * Finds all Room events for the concrete Speaker at the concrete Hall event
     * @param speakerId an ID of the Speaker
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsBySpeakerId(final Long speakerId) {
        return new ArrayList<RoomEvent>();
    }

    /**
     * Finds all Room events for the concrete Hall event
     * @param eventId an ID of the Hall event
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByEventId(final Long eventId) {
        return new ArrayList<RoomEvent>();
    }

    /**
     * Finds all Room events for the concrete Hall event
     * @param eventId an ID of the Hall event
     * @param start a timestamp of the start
     * @param end a timestamp of the end
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByEventIdForTimeInterval(
        final Long eventId, final Long start, final Long end
    ) {
        return new ArrayList<RoomEvent>();
    }
}
