package org.happydev.core.web.controller;

import org.happydev.core.model.content.Speciality;
import org.happydev.core.service.SpecialityPresenter;
import org.happydev.core.web.UrlParameterException;
import org.happydev.core.web.response.SpecialityListResponse;
import org.happydev.core.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for Specialities
 */
@Controller
public class SpecialityController {

    @Autowired
    private SpecialityPresenter specialityPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Speciality list if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Hall event ID
     * is wrong or empty.
     * @param hallEventIdStr a String value for Hall event ID
     * @return a SpecialityListResponse object, never null
     */
    @RequestMapping(value = "/speciality-list/{hallEventId}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityListResponse specialityList(
            @PathVariable(value = "hallEventId") final String hallEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<Speciality> specialityList = null;

        Long hallEventId = null;
        try {
            hallEventId = controllerUtils.convertStringToLong(hallEventIdStr, true);
            specialityList = specialityPresenter.findSpecialitiesByHallEventId(hallEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Hall event ID is wrong or empty";
        }

        return new SpecialityListResponse(success, errorMessage, specialityList);
    }
}
