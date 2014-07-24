package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;

import java.util.List;

/**
 * A thematic Branch of the Hall event
 */
public class EventBranch extends AbstractEntity {

    private String name;
    private String description;
    private List<BranchLeader> leaders;
    private String systemPictureFileName;
    private String publicPictureFileName;
}
