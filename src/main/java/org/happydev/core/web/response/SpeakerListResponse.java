package org.happydev.core.web.response;

import org.happydev.core.model.content.Speaker;

import java.util.List;

/**
 * JSON API response for Speaker list
 */
public class SpeakerListResponse extends CommonResponse {
    private List<Speaker> speakerList;

    public SpeakerListResponse(final Boolean success, final String errorMessage, final List<Speaker> speakerList) {
        super(success, errorMessage);
        this.speakerList = speakerList;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(final List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }
}
