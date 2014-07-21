package org.happydev.lite.web.controller;

import org.happydev.lite.model.content.EventBranch;
import org.happydev.lite.service.EventBranchPresenter;
import org.happydev.lite.web.UrlParameterException;
import org.happydev.lite.web.response.EventBranchListResponse;
import org.happydev.lite.web.response.EventBranchObjectResponse;
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
public class EventBranchController {

    @Autowired
    private EventBranchPresenter eventBranchPresenter;

    @Autowired
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
     * Returns a response object with Event branch object if possible.
     * When <code>success == true</code> object is present and error message is null.
     * When <code>success == false</code> object is null and error message is present; only when ID
     * is wrong or empty.
     * @param idStr a String value for Event branch ID
     * @return a EventBranchObjectResponse object, never null
     */
    @RequestMapping(value = "/event-branch-object/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EventBranchObjectResponse eventBranchObject(
            @PathVariable(value = "id") final String idStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        EventBranch eventBranch = null;

        Long id = null;
        try {
            id = controllerUtils.convertStringToLong(idStr, true);
            eventBranch = eventBranchPresenter.findEventBranchById(id);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Event branch ID is wrong or empty";
        }

        return new EventBranchObjectResponse(success, errorMessage, eventBranch);
    }

    /**
     * Returns a response object with Event branch list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return an EventBranchListResponse object, never null
     */
    @RequestMapping(value = "/event-branch-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public EventBranchListResponse eventBranchesList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<EventBranch> eventBranchList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            eventBranchList = eventBranchPresenter.findEventBranchesByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new EventBranchListResponse(success, errorMessage, eventBranchList);
    }
}
