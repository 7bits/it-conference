package org.happydev.lite.model.content;

import org.happydev.lite.model.AbstractEntity;
import org.happydev.lite.model.social.User;

/**
 * A talk request
 */
public class TalkRequest extends AbstractEntity {

    private String event;
    private String branch;
    private User requester;
    private String title;
    private String description;
    private String speakers;
    private RoomEventType roomEventType;
    private Long minimalTimeInMinutes;
    private Long maximalTimeInMinutes;
    private String presentationUrl;
    private String videoUrl;
    private String otherConferences;
    private String keyTechnologies;
    private String reporterWishes;
}
