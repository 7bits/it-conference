package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;

/**
 * A subscription to the certain Hall event news
 */
public class EventSubscription extends AbstractEntity {

    private HallEvent hallEvent;
    private String email;
}
