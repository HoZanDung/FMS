package com.cms.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
@MappedSuperclass
public class BaseEntity extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "create_by", referencedColumnName = "username")
    private SysUser create_by;

    @ManyToOne
    @JoinColumn(name = "update_by", referencedColumnName = "username")
    private SysUser update_by;

    public SysUser getCreate_by() {
        return create_by;
    }

    public void setCreate_by(SysUser create_by) {
        this.create_by = create_by;
    }

    public SysUser getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(SysUser update_by) {
        this.update_by = update_by;
    }
}
