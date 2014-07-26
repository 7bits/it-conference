package org.happydev.core.model.social;

import org.happydev.core.model.AbstractEntity;

import java.util.List;

/**
 * A user of the product
 */
public class User extends AbstractEntity {

    private String email;
    private String password;
    private String confirmationToken;
    private boolean enabled;
    /** Reverse link */
    private UserProfile userProfile;
    /** Reverse link */
    private List<SocialProfile> socialProfiles;
}
