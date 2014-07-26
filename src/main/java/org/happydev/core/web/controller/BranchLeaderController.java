package org.happydev.core.web.controller;

import org.happydev.core.model.content.BranchLeader;
import org.happydev.core.service.BranchLeaderPresenter;
import org.happydev.core.web.UrlParameterException;
import org.happydev.core.web.response.BranchLeaderListResponse;
import org.happydev.core.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Branch leaders
 */
@Controller
public class BranchLeaderController {

    @Autowired
    private BranchLeaderPresenter branchLeaderPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Branch leader list for a concrete Hall event if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a BranchLeaderListResponse object, never null
     */
    @RequestMapping(value = "/hall-event-branch-leader-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public BranchLeaderListResponse hallEventBranchLeaderList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<BranchLeader> branchLeaderList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            branchLeaderList = branchLeaderPresenter.findBranchLeadersByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new BranchLeaderListResponse(success, errorMessage, branchLeaderList);
    }

    /**
     * Returns a response object with Branch leader list for a concrete Event branch if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Event branch ID
     * is wrong or empty.
     * @param eventBranchIdStr a String value for Event branch ID
     * @return a BranchLeaderListResponse object, never null
     */
    @RequestMapping(value = "/event-branch-leader-list/{eventBranchId}", method = RequestMethod.GET)
    @ResponseBody
    public BranchLeaderListResponse branchLeaderList(
            @PathVariable(value = "eventBranchId") final String eventBranchIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<BranchLeader> branchLeaderList = null;

        Long eventBranchId = null;
        try {
            eventBranchId = controllerUtils.convertStringToLong(eventBranchIdStr, true);
            branchLeaderList = branchLeaderPresenter.findBranchLeadersByEventBranchId(eventBranchId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Event branch ID is wrong or empty";
        }

        return new BranchLeaderListResponse(success, errorMessage, branchLeaderList);
    }
}
