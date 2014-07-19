package org.happydev.lite.model.social;

/**
 * A user of the product
 */
public class User {

    private Long id;
    private String password;
    private String email;
    private String confirmationToken;
    private boolean enabled;
    private UserProfile userProfile;
}
