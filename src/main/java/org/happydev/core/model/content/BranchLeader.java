package org.happydev.core.model.content;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.social.User;

import java.util.List;

/**
 * A Branch leader with Branches he leads
 */
public class BranchLeader extends AbstractEntity {

    private User user;
    private String selfDescription;
    private Picture picture;
    /** Many to many relationship */
    private List<EventBranch> eventBranches;
}
