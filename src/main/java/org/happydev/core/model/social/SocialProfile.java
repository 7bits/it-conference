package org.happydev.core.model.social;

/**
 * A profile for social network
 */
interface SocialProfile {

    User getUser();
    void setUser(final User user);

    SocialProfileType getSocialProfileType();
    void setSocialProfileType(final SocialProfileType socialProfileType);

    Long getSocialId();
    void setSocialId(final Long socialId);
}
