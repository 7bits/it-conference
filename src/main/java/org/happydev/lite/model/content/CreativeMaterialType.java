package org.happydev.lite.model.content;

import org.happydev.lite.model.NamedType;
import org.happydev.lite.model.WrongTypeNameException;

/**
 * A type of the Talk material
 */
public class CreativeMaterialType extends NamedType {

    /**
     * A type for slides
     */
    public static final String SLIDES_TYPE_NAME = "Slides";
    /**
     * A type for video
     */
    public static final String VIDEO_TYPE_NAME = "Video";
    /**
     * A type for picture
     */
    public static final String PICTURE_TYPE_NAME = "Picture";

    /**
     * Default constructor by name
     * @param name a type name
     */
    public CreativeMaterialType(final String name) {
        super(name);
    }

    @Override
    public CreativeMaterialType getTypeByName(final String name) throws WrongTypeNameException {
        if (name == null) {
            throw new WrongTypeNameException("Type name is empty");
        }
        switch (name) {
            case SLIDES_TYPE_NAME:
            case VIDEO_TYPE_NAME:
            case PICTURE_TYPE_NAME:
                return new CreativeMaterialType(name);
            default: throw new WrongTypeNameException("Type name is wrong");
        }
    }
}
