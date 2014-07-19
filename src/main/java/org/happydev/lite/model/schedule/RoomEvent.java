package org.happydev.lite.model.schedule;

import org.happydev.lite.model.content.EventDetails;

import java.util.List;

/**
 * A room event at the certain room and certain time
 */
public class RoomEvent {

    private Long id;
    private Long firstTimeSlot;
    private Long timeSlotQuantity;
    private Room room;
    private EventDetails eventDetails;
}
