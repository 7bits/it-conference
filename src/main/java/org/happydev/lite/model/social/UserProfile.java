package org.happydev.lite.model.social;

import java.util.List;

/**
 * A user profile
 */
public class UserProfile {

    private Long id;
    private User user;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String photo;
    private String selfDescription;
    private Company company;
    private String jobPosition;
    private Location location;
    private List<SocialProfile> socialProfiles;
}
