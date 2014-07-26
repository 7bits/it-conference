package org.happydev.core.web.response;

import org.happydev.core.model.content.RoomEvent;

import java.util.List;

/**
 * JSON API response for Room event list
 */
public class RoomEventListResponse extends CommonResponse {
    private List<RoomEvent> roomEventList;

    public RoomEventListResponse(final Boolean success, final String errorMessage, final List<RoomEvent> roomEventList) {
        super(success, errorMessage);
        this.roomEventList = roomEventList;
    }

    public List<RoomEvent> getRoomEventList() {
        return roomEventList;
    }

    public void setRoomEventList(final List<RoomEvent> roomEventList) {
        this.roomEventList = roomEventList;
    }
}
