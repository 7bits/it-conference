package org.happydev.core.web.response;

import org.happydev.core.model.event.Partner;

import java.util.List;

/**
 * JSON API response for Partner list
 */
public class PartnerListResponse extends CommonResponse {
    private List<Partner> partnerList;

    public PartnerListResponse(
            final Boolean success, final String errorMessage, final List<Partner> partnerList
    ) {
        super(success, errorMessage);
        this.partnerList = partnerList;
    }

    public List<Partner> getPartnerList() {
        return partnerList;
    }

    public void setPartnerList(final List<Partner> partnerList) {
        this.partnerList = partnerList;
    }
}
