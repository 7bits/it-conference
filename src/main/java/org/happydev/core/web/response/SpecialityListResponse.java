package org.happydev.core.web.response;

import org.happydev.core.model.content.Speciality;

import java.util.List;

/**
 * JSON API response for Speciality list
 */
public class SpecialityListResponse extends CommonResponse {
    private List<Speciality> specialityList;

    public SpecialityListResponse(
            final Boolean success, final String errorMessage, final List<Speciality> specialityList
    ) {
        super(success, errorMessage);
        this.specialityList = specialityList;
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(final List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }
}
