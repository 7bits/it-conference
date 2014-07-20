package org.happydev.lite.model.schedule;

import org.happydev.lite.model.content.RoomEventDetails;

/**
 * A room event at the certain room and certain time
 */
public class RoomEvent {

    private Long id;
    private Long firstTimeSlot;
    private Long timeSlotQuantity;
    private Room room;
    private RoomEventDetails roomEventDetails;
}
