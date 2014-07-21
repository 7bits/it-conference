package org.happydev.lite.web.controller;

import org.happydev.lite.model.content.Speaker;
import org.happydev.lite.service.SpeakerPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.SpeakerListResponse;
import org.happydev.lite.web.response.SpeakerObjectResponse;
import org.happydev.lite.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Speakers
 */
@Controller
public class SpeakerController {

    @Autowired
    private SpeakerPresenter speakerPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Speaker object if possible.
     * When <code>success == true</code> object is present and error message is null.
     * When <code>success == false</code> object is null and error message is present; only when ID
     * is wrong or empty.
     * @param idStr a String value for Speaker ID
     * @return a SpeakerObjectResponse object, never null
     */
    @RequestMapping(value = "/speaker-object/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerObjectResponse speakerObject(
            @PathVariable(value = "id") final String idStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        Speaker speaker = null;

        Long id = null;
        try {
            id = controllerUtils.convertStringToLong(idStr, true);
            speaker = speakerPresenter.findSpeakerById(id);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Speaker ID is wrong or empty";
        }

        return new SpeakerObjectResponse(success, errorMessage, speaker);
    }

    /**
     * Returns a response object with Speaker list for a concrete Hall event if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a SpeakerListResponse object, never null
     */
    @RequestMapping(value = "/event-speaker-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerListResponse eventSpeakerList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Speaker> speakerList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            speakerList = speakerPresenter.findSpeakersByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new SpeakerListResponse(success, errorMessage, speakerList);
    }

    /**
     * Returns a response object with Speaker list for a concrete Event branch if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Event branch ID
     * is wrong or empty.
     * @param eventBranchIdStr a String value for Event branch ID
     * @return a SpeakerListResponse object, never null
     */
    @RequestMapping(value = "/event-branch-speaker-list/{eventBranchId}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerListResponse eventBranchSpeakerList(
            @PathVariable(value = "eventBranchId") final String eventBranchIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Speaker> speakerList = null;

        Long eventBranchId = null;
        try {
            eventBranchId = controllerUtils.convertStringToLong(eventBranchIdStr, true);
            speakerList = speakerPresenter.findSpeakersByEventBranchId(eventBranchId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Event branch ID is wrong or empty";
        }

        return new SpeakerListResponse(success, errorMessage, speakerList);
    }

    /**
     * Returns a response object with Speaker list for a concrete Speciality if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Speciality ID
     * is wrong or empty.
     * @param specialityIdStr a String value for Speciality ID
     * @return a SpeakerListResponse object, never null
     */
    @RequestMapping(value = "/speciality-speaker-list/{specialityId}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerListResponse specialitySpeakerList(
            @PathVariable(value = "specialityId") final String specialityIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Speaker> speakerList = null;

        Long specialityId = null;
        try {
            specialityId = controllerUtils.convertStringToLong(specialityIdStr, true);
            speakerList = speakerPresenter.findSpeakersBySpecialityId(specialityId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Speciality ID is wrong or empty";
        }

        return new SpeakerListResponse(success, errorMessage, speakerList);
    }
}
