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

/**
 * Layout controller for Speakers
 */
@Controller
public class SpeakerLayoutController {

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Shows a page for the concrete speaker or 404 Not found when ID is absent
     * @param idStr a String value for Speaker ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/speaker/{id}", method = RequestMethod.GET)
    public ModelAndView speakerPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "id") final String idStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("speaker-layout");
        if (idStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(idStr);
        }

        return modelAndView;
    }

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
}
