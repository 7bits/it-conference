package org.happydev.core.model;

/**
 * Common named type
 */
public abstract class NamedType {

    private String name;

    /**
     * Default constructor by name
     * @param name a type name
     */
    public NamedType(final String name) {
        this.name = name;
    }

    /**
     * Creates type object by type name
     * @param name a type name
     * @return a NamedType object created
     * @throws WrongTypeNameException when type name is wrong or empty
     */
    public abstract NamedType getTypeByName(final String name) throws WrongTypeNameException;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
