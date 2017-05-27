package com.cms.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/10.
 */
@Entity
public class SysUser extends BaseModel implements UserDetails {

    private static final long serialVersionUID = -2186323615196449343L;

    private static final String DEFAULT_AVATAR = "http://gdpujf-1252890037.cosgz.myqcloud.com/WechatIMG16670.jpeg";

    @NotBlank(message = "用户名不能为空")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "真实姓名不能为空")
    @Column(nullable = false)
    private String realname;

    @NotBlank(message = "邮箱不能为空")
    @Email(message="邮箱格式错误")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message = "必须输入手机号码")
    @Column(nullable = false, unique = true)
    private String phone;

    @NotBlank(message = "地址不能为空")
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String avatar = DEFAULT_AVATAR;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> roles;

    public SysUser(){
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = this.getRoles();
        for (SysRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
