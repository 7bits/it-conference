package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;

import java.util.List;

/**
 * A thematic Branch of the Hall event
 */
public class EventBranch extends AbstractEntity {

    private String name;
    private String description;
    private String systemPictureFileName;
    private String publicPictureFileName;
    /** Many to many relationship */
    private List<BranchLeader> leaders;
}
