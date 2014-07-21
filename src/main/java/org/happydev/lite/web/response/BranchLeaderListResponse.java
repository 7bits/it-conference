package org.happydev.lite.web.response;

import org.happydev.lite.model.content.BranchLeader;

import java.util.List;

/**
 * JSON API response for Branch leader list
 */
public class BranchLeaderListResponse extends CommonResponse {
    private List<BranchLeader> branchLeaderList;

    public BranchLeaderListResponse(
            final Boolean success, final String errorMessage, final List<BranchLeader> branchLeaderList
    ) {
        super(success, errorMessage);
        this.branchLeaderList = branchLeaderList;
    }

    public List<BranchLeader> getBranchLeaderList() {
        return branchLeaderList;
    }

    public void setBranchLeaderList(final List<BranchLeader> branchLeaderList) {
        this.branchLeaderList = branchLeaderList;
    }
}
