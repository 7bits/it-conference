package org.happydev.lite.web.controller;

import org.happydev.lite.model.content.Speaker;
import org.happydev.lite.service.SpeakerPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.SpeakerListResponse;
import org.happydev.lite.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SpeakerController {

    @Autowired
    private SpeakerPresenter speakerPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Shows a page for speakers of the concrete Hall Event or 404 Not found when Hall event ID is absent
     * @param eventIdStr a String value for Hall event ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/speakers/{eventId}", method = RequestMethod.GET)
    public ModelAndView speakersPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "eventId") final String eventIdStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("speakers-layout");
        if (eventIdStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(eventIdStr);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/event-speaker-list/{eventId}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerListResponse eventSpeakersList(
            @PathVariable(value = "eventId") final String eventIdStr
    ) throws IOException {
        Boolean success = true;
        String errorMessage = null;
        List<Speaker> speakerList = null;

        Long eventId = null;
        try {
            eventId = controllerUtils.convertStringToLong(eventIdStr, true);
            speakerList = speakerPresenter.findSpeakersByEventId(eventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new SpeakerListResponse(success, errorMessage, speakerList);
    }

    @RequestMapping(value = "/branch-speaker-list/{branchId}", method = RequestMethod.GET)
    @ResponseBody
    public SpeakerListResponse branchSpeakersList(
            @PathVariable(value = "branchId") final String branchIdStr
    ) throws IOException {
        Boolean success = true;
        String errorMessage = null;
        List<Speaker> speakerList = null;

        Long branchId = null;
        try {
            branchId = controllerUtils.convertStringToLong(branchIdStr, true);
            speakerList = speakerPresenter.findSpeakersByBranchId(branchId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Event branch ID is wrong or empty";
        }

        return new SpeakerListResponse(success, errorMessage, speakerList);
    }
}
