package org.happydev.lite.model.event;

import org.happydev.lite.model.social.Company;

/**
 * A event partner company of different roles
 */
public class Partner {

    private Long id;
    private HallEvent hallEvent;
    private Company company;
    private PartnerRole partnerRole;
    private String customRoleName;
    private String logoFileName;
}
