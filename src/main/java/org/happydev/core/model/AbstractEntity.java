package org.happydev.core.model;

/**
 * A common entity with ID and timestamps
 */
public abstract class AbstractEntity {
    private Long id;
    private Long createdAt;
    private Long updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
