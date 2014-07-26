package org.happydev.core.model.event;

import org.happydev.core.model.NamedType;
import org.happydev.core.model.WrongTypeNameException;

/**
 * A role of the company at the Event
 */
public class PartnerRole extends NamedType {

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

    /**
     * Default constructor by name
     * @param name a type name
     */
    public PartnerRole(final String name) {
        super(name);
    }

    @Override
    public PartnerRole getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case CREATOR_ROLE_NAME:
            case SPONSOR_ROLE_NAME:
            case PARTNER_ROLE_NAME:
                return new PartnerRole(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
