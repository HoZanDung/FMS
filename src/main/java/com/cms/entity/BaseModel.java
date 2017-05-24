package com.cms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
@MappedSuperclass
public class BaseModel implements Serializable {

    public static final int DELETED = 0;
    public static final int NORMAL = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date create_time;

    @Column(nullable = false)
    private String create_ip;

    @Column(nullable = false)
    private Date update_time;

    @Column(nullable = false)
    private String update_ip;

    private int status = NORMAL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_ip() {
        return create_ip;
    }

    public void setCreate_ip(String create_ip) {
        this.create_ip = create_ip;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_ip() {
        return update_ip;
    }

    public void setUpdate_ip(String update_ip) {
        this.update_ip = update_ip;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
