package org.happydev.lite.model.event;

/**
 * A role of the company at the Event
 */
public class PartnerRole {

    /**
     * A company created the event
     */
    public static final String CREATOR_ROLE_NAME = "Creator";
    /**
     * A sponsor company
     */
    public static final String SPONSOR_ROLE_NAME = "Sponsor";
    /**
     * A partner company
     */
    public static final String PARTNER_ROLE_NAME = "Partner";

    private Long id;
    private String name;
}
