package org.happydev.lite.web.controller;

import org.happydev.lite.model.content.EventBranch;
import org.happydev.lite.service.EventBranchPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.EventBranchListResponse;
import org.happydev.lite.web.util.ControllerUtils;
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
public class EventBranchController {

    private EventBranchPresenter eventBranchPresenter;

    private ControllerUtils controllerUtils;

    /**
     * Shows a page for concrete Event branch or 404 Not found when ID is absent
     * @param idStr a String value for ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/event-branch/{id}", method = RequestMethod.GET)
    public ModelAndView eventBranchPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "id") final String idStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("event-branch-layout");
        if (idStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(idStr);
        }

        return modelAndView;
    }

    /**
     * Returns a response object with Event branch list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param eventIdStr a String value for Hall event ID
     * @return an EventBranchListResponse object, never null
     */
    @RequestMapping(value = "/event-branch-list/{eventId}", method = RequestMethod.GET)
    @ResponseBody
    public EventBranchListResponse eventBranchesList(
            @PathVariable(value = "eventId") final String eventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<EventBranch> eventBranchList = null;

        Long eventId = null;
        try {
            eventId = controllerUtils.convertStringToLong(eventIdStr, true);
            eventBranchList = eventBranchPresenter.findEventBranchesByEventId(eventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new EventBranchListResponse(success, errorMessage, eventBranchList);
    }

    public EventBranchPresenter getEventBranchPresenter() {
        return eventBranchPresenter;
    }

    public void setEventBranchPresenter(EventBranchPresenter eventBranchPresenter) {
        this.eventBranchPresenter = eventBranchPresenter;
    }

    public ControllerUtils getControllerUtils() {
        return controllerUtils;
    }

    public void setControllerUtils(ControllerUtils controllerUtils) {
        this.controllerUtils = controllerUtils;
    }
}