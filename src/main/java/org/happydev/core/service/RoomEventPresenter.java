package org.happydev.core.service;

import org.happydev.core.model.content.RoomEvent;

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
     * @param eventBranchId an ID of the Event branch
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByEventBranchId(final Long eventBranchId) {
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
     * Finds all Room events for the concrete Speciality at the concrete Hall event
     * @param specialityId an ID of the Speciality
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsBySpecialityId(final Long specialityId) {
        return new ArrayList<RoomEvent>();
    }

    /**
     * Finds all Room events for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByHallEventId(final Long hallEventId) {
        return new ArrayList<RoomEvent>();
    }

    /**
     * Finds all Room events for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @param start a timestamp of the start
     * @param end a timestamp of the end
     * @return a list of the RoomEvent objects
     */
    public List<RoomEvent> findRoomEventsByHallEventIdForTimeInterval(
            final Long hallEventId, final Long start, final Long end
    ) {
        return new ArrayList<RoomEvent>();
    }
}
