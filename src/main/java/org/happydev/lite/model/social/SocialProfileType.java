package org.happydev.lite.model.social;

import org.happydev.lite.model.NamedType;
import org.happydev.lite.model.WrongTypeNameException;

/**
 * A type of the Social network profile
 */
public class SocialProfileType extends NamedType {

    /**
     * A type for Russian social network VKontakte
     */
    public static final String VKONTAKTE_TYPE_NAME = "VKontakte";
    /**
     * A type for Twitter
     */
    public static final String TWITTER_TYPE_NAME = "Twitter";

    /**
     * Default constructor by name
     * @param name a type name
     */
    public SocialProfileType(final String name) {
        super(name);
    }

    @Override
    public SocialProfileType getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case VKONTAKTE_TYPE_NAME:
            case TWITTER_TYPE_NAME:
                return new SocialProfileType(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
