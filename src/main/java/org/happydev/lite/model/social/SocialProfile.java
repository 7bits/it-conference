package org.happydev.lite.model.social;

/**
 * A profile for social network
 */
interface SocialProfile {

    Long getId();
    void setId(Long id);

    SocialProfileType getProfileType();
    void setProfileType(SocialProfileType profileType);

    Long getSocialId();
    void setSocialId(Long socialId);

    User getUser();
    void setUser(User user);
}
