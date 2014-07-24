package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.User;

import java.util.List;

/**
 * A Branch leader with Branches he leads
 */
public class BranchLeader extends AbstractEntity {

    private User user;
    private String systemPhotoFileName;
    private String publicPhotoFileName;
    /** Many to many relationship */
    private List<EventBranch> eventBranches;
}
