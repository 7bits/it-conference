package org.happydev.lite.model.event;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.event.HallEvent;

/**
 * A subscription to the certain Hall event news
 */
public class EventSubscription extends AbstractEntity {

    private HallEvent hallEvent;
    private String email;
}
