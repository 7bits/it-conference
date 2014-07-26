package org.happydev.core.service;

import org.happydev.core.model.WrongTypeNameException;
import org.happydev.core.model.content.CreativeMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation for the talk Creative materials
 */
public class CreativeMaterialPresenter {

    /**
     * Finds concrete CreativeMaterial
     * @param id an ID of the CreativeMaterial
     * @return a CreativeMaterial object or null when ID is wrong
     */
    public CreativeMaterial findCreativeMaterialById(final Long id) {
        return new CreativeMaterial();
    }

    /**
     * Finds all Creative materials for the concrete Room event
     * @param roomEventId an ID of the Room event
     * @return a list of the CreativeMaterial objects
     */
    public List<CreativeMaterial> findAllCreativeMaterialsByRoomEventId(final Long roomEventId) {
        return new ArrayList<CreativeMaterial>();
    }

    /**
     * Finds all Creative materials for the concrete Room event and type name
     * @param roomEventId an ID of the Room event
     * @param creativeMaterialTypeName a type name of Creative material
     * @return a list of the CreativeMaterial objects
     * @throws WrongTypeNameException when type name is wrong or empty
     */
    public List<CreativeMaterial> findCreativeMaterialsByRoomEventIdAndTypeName(
            final Long roomEventId, final String creativeMaterialTypeName
    ) throws WrongTypeNameException {
        return new ArrayList<CreativeMaterial>();
    }
}
