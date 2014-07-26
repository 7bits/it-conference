package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;

/**
 * A concrete room at the Event hall
 */
public class Room extends AbstractEntity {

    private String name;
    private String description;
    private Hall hall;
    private String internalLocation;
    private Long placeCount;
}
