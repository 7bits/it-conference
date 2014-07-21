package org.happydev.lite.web.response;

import org.happydev.lite.model.content.Speciality;

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

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }
}
