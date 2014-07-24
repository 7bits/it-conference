package org.happydev.lite.model.social;

import org.happydev.lite.model.AbstractEntity;

/**
 * A user profile
 */
public class UserProfile extends AbstractEntity {

    private User user;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String selfDescription;
    private Company company;
    private String jobPosition;
    private Location location;
}