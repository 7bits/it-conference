package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.social.Location;

import java.util.List;

/**
 * A place for events
 */
public class Hall extends AbstractEntity {

    private String name;
    private String description;
    private Location location;
    private String url;
    /** Reverse link */
    private List<Room> rooms;
}
