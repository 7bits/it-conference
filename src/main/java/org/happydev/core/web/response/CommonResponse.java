package org.happydev.core.web.response;

/**
 * A common response for JSON API
 */
public class CommonResponse {
    private Boolean success = false;
    private String errorMessage = "Unknown error";

    public CommonResponse(final Boolean success, final String errorMessage) {
        if (success != null) {
            this.success = success;
        }
        if (errorMessage != null) {
            this.errorMessage = errorMessage;
        }
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
