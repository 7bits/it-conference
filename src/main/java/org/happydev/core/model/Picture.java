package org.happydev.core.model;

/**
 * Picture file names - the generated unique system name and a name for download
 */
public class Picture extends AbstractEntity {
    private String systemPhotoFileName;
    private String publicPhotoFileName;
    private Boolean isDefault;
}
