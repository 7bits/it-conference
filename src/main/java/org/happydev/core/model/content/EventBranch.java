package org.happydev.core.model.content;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.event.HallEvent;

import java.util.List;

/**
 * A thematic Branch of the Hall event
 */
public class EventBranch extends AbstractEntity {

    private HallEvent hallEvent;
    private String name;
    private String description;
    private Picture picture;
    /** Many to many relationship */
    private List<BranchLeader> leaders;
    /** Many to many relationship */
    private List<Speciality> specialities;
}
