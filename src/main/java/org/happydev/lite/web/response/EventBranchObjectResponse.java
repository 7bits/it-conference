package org.happydev.lite.web.response;

import org.happydev.lite.model.content.EventBranch;

/**
 * JSON API response for Event branch object
 */
public class EventBranchObjectResponse extends CommonResponse {
    private EventBranch eventBranch;

    public EventBranchObjectResponse(
            final Boolean success, final String errorMessage, final EventBranch eventBranch
    ) {
        super(success, errorMessage);
        this.eventBranch = eventBranch;
    }

    public EventBranch getEventBranch() {
        return eventBranch;
    }

    public void setEventBranch(EventBranch eventBranch) {
        this.eventBranch = eventBranch;
    }
}
