package com.cms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/10.
 */
@Entity
public class SysRole implements Serializable {

//    private static final long serialVersionUID = 614060023971248607L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//    private List<SysUser> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<SysUser> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<SysUser> users) {
//        this.users = users;
//    }


}
