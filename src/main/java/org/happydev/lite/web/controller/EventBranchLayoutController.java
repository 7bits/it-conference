package org.happydev.lite.web.controller;

import org.happydev.lite.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EventBranchLayoutController {

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
}
