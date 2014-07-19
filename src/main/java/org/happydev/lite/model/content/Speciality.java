package org.happydev.lite.model.content;

/**
 * A professional speciality of the Event branch or a talk
 */
public class Speciality {

    /**
     * A development speciality
     */
    public static final String DEVELOPER_SPECIALITY_NAME = "Developer";
    /**
     * A management speciality
     */
    public static final String MANAGER_SPECIALITY_NAME = "Manager";
    /**
     * A software testing speciality
     */
    public static final String TESTER_SPECIALITY_NAME = "Tester";
    /**
     * A design speciality
     */
    public static final String DESIGNER_SPECIALITY_NAME = "Designer";

    private Long id;
    private String name;
    private String pictureFileName;
}
