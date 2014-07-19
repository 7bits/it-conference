package org.happydev.lite.model.content;

import org.happydev.lite.model.schedule.RoomEventType;
import org.happydev.lite.model.social.User;

/**
 * A talk request
 */
public class TalkRequest {

    private Long id;
    private String event;
    private String branch;
    private User requester;
    private String title;
    private String description;
    private String speakers;
    private RoomEventType roomEventType;
    private Long minimalTimeInMinutes;
    private Long maximalTimeInMinutes;
    private String presentation;
    private String video;
    private String otherConferences;
    private String keyTechnologies;
    private String reporterWishes;
}
