package org.happydev.core.web.response;

import org.happydev.core.model.content.EventBranch;

import java.util.List;

/**
 * JSON API response for Event branch list
 */
public class EventBranchListResponse extends CommonResponse {
    private List<EventBranch> eventBranchList;

    public EventBranchListResponse(
            final Boolean success, final String errorMessage, final List<EventBranch> eventBranchList
    ) {
        super(success, errorMessage);
        this.eventBranchList = eventBranchList;
    }

    public List<EventBranch> getEventBranchList() {
        return eventBranchList;
    }

    public void setEventBranchList(final List<EventBranch> eventBranchList) {
        this.eventBranchList = eventBranchList;
    }
}
