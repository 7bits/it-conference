package org.happydev.lite.web.controller;

import org.happydev.lite.model.event.EventComment;
import org.happydev.lite.service.EventCommentPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.EventCommentListResponse;
import org.happydev.lite.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Event comments
 */
@Controller
public class EventCommentController {

    @Autowired
    private EventCommentPresenter specialityPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Event comment list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a EventCommentListResponse object, never null
     */
    @RequestMapping(value = "/all-event-comment-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public EventCommentListResponse eventCommentList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<EventComment> eventCommentList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            eventCommentList = specialityPresenter.findAllEventCommentsByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new EventCommentListResponse(success, errorMessage, eventCommentList);
    }

    /**
     * Returns a response object with Before event comment list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a EventCommentListResponse object, never null
     */
    @RequestMapping(value = "/before-event-comment-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public EventCommentListResponse beforeEventCommentList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<EventComment> eventCommentList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            eventCommentList = specialityPresenter.findBeforeEventCommentsByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new EventCommentListResponse(success, errorMessage, eventCommentList);
    }

    /**
     * Returns a response object with After event comment list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a EventCommentListResponse object, never null
     */
    @RequestMapping(value = "/before-event-comment-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public EventCommentListResponse afterEventCommentList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<EventComment> eventCommentList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            eventCommentList = specialityPresenter.findAfterEventCommentsByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new EventCommentListResponse(success, errorMessage, eventCommentList);
    }
}
