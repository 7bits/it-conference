package org.happydev.core.model.social;

import org.happydev.core.model.AbstractEntity;

/**
 * Russian social network VKontakte profile
 */
public class VKontakteProfile extends AbstractEntity implements SocialProfile {

    private User user;
    private SocialProfileType socialProfileType;
    private Long socialId;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public SocialProfileType getSocialProfileType() {
        return socialProfileType;
    }

    @Override
    public void setSocialProfileType(final SocialProfileType socialProfileType) {
        this.socialProfileType = socialProfileType;
    }

    @Override
    public Long getSocialId() {
        return socialId;
    }

    @Override
    public void setSocialId(final Long socialId) {
        this.socialId = socialId;
    }
}
