package org.happydev.core.model.social;

import org.happydev.core.model.AbstractEntity;

/**
 * A user profile
 */
public class UserProfile extends AbstractEntity {

    private User user;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private Company company;
    private String jobPosition;
    private Location location;
}