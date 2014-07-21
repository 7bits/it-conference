package org.happydev.lite.service;

import org.happydev.lite.model.WrongTypeNameException;
import org.happydev.lite.model.event.Partner;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the Partners
 */
public class PartnerPresenter {

    /**
     * Finds concrete Partner
     * @param id an ID of the Partner
     * @return a Partner object or null when ID is wrong
     */
    public Partner findPartnerById(final Long id) {
        return new Partner();
    }

    /**
     * Finds all Partners for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @return a list of the Partner objects
     */
    public List<Partner> findAllPartnersByHallEventId(final Long hallEventId) {
        return new ArrayList<Partner>();
    }

    /**
     * Finds Partners of the concrete type for the concrete Hall event
     * @param hallEventId an ID of the Hall event
     * @param partnerRoleName a name of the Partner role
     * @return a list of the Partner objects
     */
    public List<Partner> findPartnersByHallEventIdAndRoleName(
            final Long hallEventId, final String partnerRoleName
    ) throws WrongTypeNameException {
        return new ArrayList<Partner>();
    }
}
