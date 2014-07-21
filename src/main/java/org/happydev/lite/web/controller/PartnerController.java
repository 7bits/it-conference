package org.happydev.lite.web.controller;

import org.happydev.lite.model.WrongTypeNameException;
import org.happydev.lite.model.event.Partner;
import org.happydev.lite.model.event.PartnerRole;
import org.happydev.lite.service.PartnerPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.PartnerListResponse;
import org.happydev.lite.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Partners
 */
@Controller
public class PartnerController {

    @Autowired
    private PartnerPresenter partnerPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Partner list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a PartnerListResponse object, never null
     */
    @RequestMapping(value = "/all-partner-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public PartnerListResponse allPartnerList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Partner> partnerList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            partnerList = partnerPresenter.findAllPartnersByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new PartnerListResponse(success, errorMessage, partnerList);
    }

    /**
     * Returns a response object with Partner list of the Sponsor role if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a PartnerListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-sponsor-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public PartnerListResponse hallEventSponsorList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        return typedPartnerList(hallEventIdStr, PartnerRole.SPONSOR_ROLE_NAME);
    }

    /**
     * Returns a response object with Partner list of the Creator role if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a PartnerListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-creator-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public PartnerListResponse hallEventCreatorList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        return typedPartnerList(hallEventIdStr, PartnerRole.CREATOR_ROLE_NAME);
    }

    /**
     * Returns a response object with Partner list of the Partner role if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a PartnerListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-partner-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public PartnerListResponse hallEventPartnerList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        return typedPartnerList(hallEventIdStr, PartnerRole.PARTNER_ROLE_NAME);
    }

    private PartnerListResponse typedPartnerList(
            final String hallEventIdStr, final String partnerRoleName
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Partner> partnerList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        if (success) {
            try {
                partnerList = partnerPresenter.findPartnersByHallEventIdAndRoleName(
                        hallEventId, partnerRoleName
                );
            } catch (WrongTypeNameException e) {
                success = false;
                errorMessage = partnerRoleName + " role name is wrong";
            }
        }

        return new PartnerListResponse(success, errorMessage, partnerList);
    }
}
