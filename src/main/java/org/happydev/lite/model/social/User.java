package org.happydev.lite.model.social;

import org.happydev.lite.model.AbstractEntity;

import java.util.List;

/**
 * A user of the product
 */
public class User extends AbstractEntity {

    private String email;
    private String password;
    private String confirmationToken;
    private boolean enabled;
    private UserProfile userProfile;
    private List<SocialProfile> socialProfiles;
}
