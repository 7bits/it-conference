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
     * @param hallEventIdStr a String value for Hall event ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/speakers/{hallEventId}", method = RequestMethod.GET)
    public ModelAndView speakersPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("speakers-layout");
        if (hallEventIdStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(hallEventIdStr);
        }

        return modelAndView;
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
    public SpeakerListResponse eventSpeakersList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) throws IOException {
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
    public SpeakerListResponse eventBranchSpeakersList(
            @PathVariable(value = "eventBranchId") final String eventBranchIdStr
    ) throws IOException {
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
}
