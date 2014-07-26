package org.happydev.core.web.controller;

import org.happydev.core.web.util.ControllerUtils;
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
 * Layout controller for Room events
 */
@Controller
public class RoomEventLayoutController {

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Shows a page for the concrete Room event or 404 Not found when ID is absent
     * @param idStr a String value for ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/room-event/{id}", method = RequestMethod.GET)
    public ModelAndView speakerPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "id") final String idStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("room-event-layout");
        if (idStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(idStr);
        }

        return modelAndView;
    }

    /**
     * Shows a page for all Room events of the concrete Hall Event or 404 Not found when Hall event ID is absent
     * @param hallEventIdStr a String value for Hall event ID
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/room-events/{hallEventId}", method = RequestMethod.GET)
    public ModelAndView allRoomEventsPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("room-events-layout");
        if (hallEventIdStr == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(hallEventIdStr);
        }

        return modelAndView;
    }

    /**
     * Shows a page for Room events of the concrete Hall Event for the given time interval
     * or 404 Not found when Hall event ID is absent
     * @param hallEventIdStr a String value for Hall event ID
     * @param startStr a String value for the start timestamp of the interval
     * @param endStr a String value for the end timestamp of the interval
     * @return ModelAndView object for this page
     * @throws java.io.IOException Internal error of the servlet container
     */
    @RequestMapping(value = "/room-events/{hallEventId}/{start}/{end}", method = RequestMethod.GET)
    public ModelAndView speakersPage(
            final HttpServletRequest request,
            final HttpServletResponse response,
            @PathVariable(value = "hallEventId") final String hallEventIdStr,
            @PathVariable(value = "start") final String startStr,
            @PathVariable(value = "end") final String endStr
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("room-events-layout");
        if ((hallEventIdStr == null) || (startStr == null) ||(endStr == null)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            modelAndView = null;
        } else {
            modelAndView.addObject(hallEventIdStr);
            modelAndView.addObject(startStr);
            modelAndView.addObject(endStr);
        }

        return modelAndView;
    }
}
