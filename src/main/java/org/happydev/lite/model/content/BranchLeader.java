package org.happydev.lite.model.content;

import org.happydev.lite.model.social.User;

import java.util.List;

/**
 * The special entity for Branch Leader as a Participant with Branches he leads
 */
public class BranchLeader {

    private Long id;
    private User user;
    private String photoFileName;
    private List<EventBranch> eventBranches;
}
