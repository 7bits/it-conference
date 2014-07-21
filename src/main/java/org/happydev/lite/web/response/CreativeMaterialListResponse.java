package org.happydev.lite.web.response;

import org.happydev.lite.model.content.CreativeMaterial;

import java.util.List;

/**
 * JSON API response for talk Creative material list
 */
public class CreativeMaterialListResponse extends CommonResponse {
    private List<CreativeMaterial> creativeMaterialList;

    public CreativeMaterialListResponse(
            final Boolean success, final String errorMessage, final List<CreativeMaterial> creativeMaterialList
    ) {
        super(success, errorMessage);
        this.creativeMaterialList = creativeMaterialList;
    }

    public List<CreativeMaterial> getCreativeMaterialList() {
        return creativeMaterialList;
    }

    public void setCreativeMaterialList(final List<CreativeMaterial> creativeMaterialList) {
        this.creativeMaterialList = creativeMaterialList;
    }
}
