package org.happydev.core.model.content;

import org.happydev.core.model.AbstractEntity;

/**
 * A talk request
 */
public class TalkRequest extends AbstractEntity {

    private String email;
    private String event;
    private String branch;
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
