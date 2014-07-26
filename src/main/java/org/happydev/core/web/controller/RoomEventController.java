package org.happydev.core.web.controller;

import org.happydev.core.model.content.RoomEvent;
import org.happydev.core.service.RoomEventPresenter;
import org.happydev.core.web.UrlParameterException;
import org.happydev.core.web.response.RoomEventListResponse;
import org.happydev.core.web.response.RoomEventObjectResponse;
import org.happydev.core.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Room events
 */
@Controller
public class RoomEventController {

    @Autowired
    private RoomEventPresenter roomEventPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with room-event object if possible.
     * When <code>success == true</code> object is present and error message is null.
     * When <code>success == false</code> object is null and error message is present; only when ID
     * is wrong or empty.
     * @param idStr a String value for ID
     * @return a RoomEventObjectResponse object, never null
     */
    @RequestMapping(value = "/room-event-object/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventObjectResponse roomEventObject(
            @PathVariable(value = "id") final String idStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        RoomEvent roomEvent = null;

        Long id = null;
        try {
            id = controllerUtils.convertStringToLong(idStr, true);
            roomEvent = roomEventPresenter.findRoomEventById(id);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Room event ID is wrong or empty";
        }

        return new RoomEventObjectResponse(success, errorMessage, roomEvent);
    }

    /**
     * Returns a response object with Room event list for a concrete Hall event if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a RoomEventListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-room-event-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventListResponse hallEventRoomEventList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<RoomEvent> roomEventList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            roomEventList = roomEventPresenter.findRoomEventsByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new RoomEventListResponse(success, errorMessage, roomEventList);
    }

    /**
     * Returns a response object with Room event list for a concrete Hall event and the given time interval if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a RoomEventListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-room-event-list/{hallEventId}/{start}/{end}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventListResponse hallEventRoomEventListForTimeInterval(
            @PathVariable(value = "hallEventId") final String hallEventIdStr,
            @PathVariable(value = "start") final String startStr,
            @PathVariable(value = "end") final String endStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<RoomEvent> roomEventList = null;

        Long hallEventId = null;
        Long startTime = null;
        Long endTime = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        if (success) {
            try {
                startTime = controllerUtils.convertStringToLong(startStr, true);
            } catch (UrlParameterException e) {
                success = false;
                errorMessage = "Start is wrong or empty";
            }
        }

        if (success) {
            try {
                endTime = controllerUtils.convertStringToLong(endStr, true);
            } catch (UrlParameterException e) {
                success = false;
                errorMessage = "End is wrong or empty";
            }
        }

        if (success) {
            roomEventList = roomEventPresenter.findRoomEventsByHallEventIdForTimeInterval(
                    hallEventId, startTime, endTime
           );
        }

        return new RoomEventListResponse(success, errorMessage, roomEventList);
    }

    /**
     * Returns a response object with Room event list for a concrete Event branch if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Event branch ID
     * is wrong or empty.
     * @param eventBranchIdStr a String value for Event branch ID
     * @return a RoomEventListResponse object, never null
     */
    @RequestMapping(value = "/event-branch-room-event-list/{eventBranchId}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventListResponse eventBranchRoomEventList(
            @PathVariable(value = "eventBranchId") final String eventBranchIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<RoomEvent> roomEventList = null;

        Long eventBranchId = null;
        try {
            eventBranchId = controllerUtils.convertStringToLong(eventBranchIdStr, true);
            roomEventList = roomEventPresenter.findRoomEventsByEventBranchId(eventBranchId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Event branch ID is wrong or empty";
        }

        return new RoomEventListResponse(success, errorMessage, roomEventList);
    }

    /**
     * Returns a response object with Room event list for a concrete Speaker if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Speaker ID
     * is wrong or empty.
     * @param speakerIdStr a String value for Speaker ID
     * @return a RoomEventListResponse object, never null
     */
    @RequestMapping(value = "/speaker-room-event-list/{speakerId}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventListResponse speakerRoomEventList(
            @PathVariable(value = "speakerId") final String speakerIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<RoomEvent> roomEventList = null;

        Long speakerId = null;
        try {
            speakerId = controllerUtils.convertStringToLong(speakerIdStr, true);
            roomEventList = roomEventPresenter.findRoomEventsBySpeakerId(speakerId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Speaker ID is wrong or empty";
        }

        return new RoomEventListResponse(success, errorMessage, roomEventList);
    }

    /**
     * Returns a response object with Room event list for a concrete Speciality if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Speciality ID
     * is wrong or empty.
     * @param specialityIdStr a String value for Speciality ID
     * @return a RoomEventListResponse object, never null
     */
    @RequestMapping(value = "/speciality-room-event-list/{specialityId}", method = RequestMethod.GET)
    @ResponseBody
    public RoomEventListResponse specialityRoomEventList(
            @PathVariable(value = "specialityId") final String specialityIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<RoomEvent> roomEventList = null;

        Long specialityId = null;
        try {
            specialityId = controllerUtils.convertStringToLong(specialityIdStr, true);
            roomEventList = roomEventPresenter.findRoomEventsBySpecialityId(specialityId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Speaker ID is wrong or empty";
        }

        return new RoomEventListResponse(success, errorMessage, roomEventList);
    }
}
