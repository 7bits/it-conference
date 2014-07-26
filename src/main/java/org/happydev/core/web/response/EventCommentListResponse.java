package org.happydev.core.web.response;

import org.happydev.core.model.event.EventComment;

import java.util.List;

/**
 * JSON API response for Event comment list
 */
public class EventCommentListResponse extends CommonResponse {
    private List<EventComment> eventCommentList;

    public EventCommentListResponse(
            final Boolean success, final String errorMessage, final List<EventComment> eventCommentList
    ) {
        super(success, errorMessage);
        this.eventCommentList = eventCommentList;
    }

    public List<EventComment> getEventCommentList() {
        return eventCommentList;
    }

    public void setEventCommentList(final List<EventComment> eventCommentList) {
        this.eventCommentList = eventCommentList;
    }
}
