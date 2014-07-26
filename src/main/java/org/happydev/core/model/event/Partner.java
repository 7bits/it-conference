package org.happydev.core.model.event;

import org.happydev.core.model.AbstractEntity;
import org.happydev.core.model.Picture;
import org.happydev.core.model.social.Company;

/**
 * A event partner company of different roles
 */
public class Partner extends AbstractEntity {

    private HallEvent hallEvent;
    private Company company;
    private PartnerRole partnerRole;
    private String customRoleName;
    private Picture logo;
}
