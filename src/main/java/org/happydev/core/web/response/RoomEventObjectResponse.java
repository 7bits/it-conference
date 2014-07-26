package org.happydev.core.web.response;

import org.happydev.core.model.content.RoomEvent;

/**
 * JSON API response for RoomEvent object
 */
public class RoomEventObjectResponse extends CommonResponse {
    private RoomEvent roomEvent;

    public RoomEventObjectResponse(final Boolean success, final String errorMessage, final RoomEvent roomEvent) {
        super(success, errorMessage);
        this.roomEvent = roomEvent;
    }

    public RoomEvent getRoomEvent() {
        return roomEvent;
    }

    public void setRoomEvent(final RoomEvent roomEvent) {
        this.roomEvent = roomEvent;
    }
}
