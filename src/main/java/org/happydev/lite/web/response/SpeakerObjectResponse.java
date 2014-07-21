package org.happydev.lite.web.response;

import org.happydev.lite.model.content.Speaker;

/**
 * JSON API response for Speaker object
 */
public class SpeakerObjectResponse extends CommonResponse {
    private Speaker speaker;

    public SpeakerObjectResponse(final Boolean success, final String errorMessage, final Speaker speaker) {
        super(success, errorMessage);
        this.speaker = speaker;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(final Speaker speaker) {
        this.speaker = speaker;
    }
}
