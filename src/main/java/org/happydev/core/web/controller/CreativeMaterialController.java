package org.happydev.core.web.controller;

import org.happydev.core.model.WrongTypeNameException;
import org.happydev.core.model.content.CreativeMaterial;
import org.happydev.core.model.content.CreativeMaterialType;
import org.happydev.core.service.CreativeMaterialPresenter;
import org.happydev.core.web.UrlParameterException;
import org.happydev.core.web.response.CreativeMaterialListResponse;
import org.happydev.core.web.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * JSON API controller for talk Creative materials
 */
@Controller
public class CreativeMaterialController {

    @Autowired
    private CreativeMaterialPresenter creativeMaterialPresenter;

    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Returns a response object with Creative material list for concrete Room event if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Room event ID
     * is wrong or empty.
     * @param roomEventIdStr a String value for Room event ID
     * @return a CreativeMaterialListResponse object, never null
     */
    @RequestMapping(value = "/room-event-creative-material-list/{roomEventId}", method = RequestMethod.GET)
    @ResponseBody
    public CreativeMaterialListResponse allRoomEventCreativeMaterialList(
            @PathVariable(value = "roomEventId") final String roomEventIdStr
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<CreativeMaterial> creativeMaterialList = null;

        Long roomEventId = null;
        try {
            roomEventId = controllerUtils.convertStringToLong(roomEventIdStr, true);
            creativeMaterialList = creativeMaterialPresenter.findAllCreativeMaterialsByRoomEventId(roomEventId);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Room event ID is wrong or empty";
        }

        return new CreativeMaterialListResponse(success, errorMessage, creativeMaterialList);
    }

    /**
     * Returns a response object with Creative material list of the Slides type if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Room event ID
     * is wrong or empty.
     * @param roomEventIdStr a String value for Room event ID
     * @return a CreativeMaterialListResponse object, never null
     */
    @RequestMapping(value = "/room-event-slides-list/{roomEventId}", method = RequestMethod.GET)
    @ResponseBody
    public CreativeMaterialListResponse roomEventSlidesList(
            @PathVariable(value = "roomEventId") final String roomEventIdStr
    ) {
        return typedCreativeMaterialList(roomEventIdStr, CreativeMaterialType.SLIDES_TYPE_NAME);
    }

    /**
     * Returns a response object with Creative material list of the Video type if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Room event ID
     * is wrong or empty.
     * @param roomEventIdStr a String value for Room event ID
     * @return a CreativeMaterialListResponse object, never null
     */
    @RequestMapping(value = "/room-event-video-list/{roomEventId}", method = RequestMethod.GET)
    @ResponseBody
    public CreativeMaterialListResponse roomEventVideoList(
            @PathVariable(value = "roomEventId") final String roomEventIdStr
    ) {
        return typedCreativeMaterialList(roomEventIdStr, CreativeMaterialType.VIDEO_TYPE_NAME);
    }

    /**
     * Returns a response object with Creative material list of the Picture type if possible.
     * When <code>success == true</code> list is present and error message is null.
     * When <code>success == false</code> list is null and error message is present; only when Room event ID
     * is wrong or empty.
     * @param roomEventIdStr a String value for Room event ID
     * @return a CreativeMaterialListResponse object, never null
     */
    @RequestMapping(value = "/room-event-picture-list/{roomEventId}", method = RequestMethod.GET)
    @ResponseBody
    public CreativeMaterialListResponse roomEventPictureList(
            @PathVariable(value = "roomEventId") final String roomEventIdStr
    ) {
        return typedCreativeMaterialList(roomEventIdStr, CreativeMaterialType.PICTURE_TYPE_NAME);
    }

    private CreativeMaterialListResponse typedCreativeMaterialList(
            final String roomEventIdStr, final String creativeMaterialTypeName
    ) {
        Boolean success = true;
        String errorMessage = null;
        List<CreativeMaterial> creativeMaterialList = null;

        Long roomEventId = null;
        try {
            roomEventId = controllerUtils.convertStringToLong(roomEventIdStr, true);
        } catch (UrlParameterException e) {
            success = false;
            errorMessage = "Room event ID is wrong or empty";
        }

        if (success) {
            try {
                creativeMaterialList = creativeMaterialPresenter.findCreativeMaterialsByRoomEventIdAndTypeName(
                        roomEventId, creativeMaterialTypeName
                );
            } catch (WrongTypeNameException e) {
                success = false;
                errorMessage = creativeMaterialTypeName + " type name is wrong";
            }
        }

        return new CreativeMaterialListResponse(success, errorMessage, creativeMaterialList);
    }
}
