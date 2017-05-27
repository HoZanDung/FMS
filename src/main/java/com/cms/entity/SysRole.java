package com.cms.entity;

import javax.persistence.*;

/**
 * Created by HOZANDUNG on 17/5/10.
 */
@Entity
public class SysRole extends BaseModel {

    private static final long serialVersionUID = 614060023971248607L;

    private String name;

    private String description;

    public SysRole() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
