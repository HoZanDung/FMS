package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {

    /**
     * 供应商名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 拼音码
     */
    @Column(name = "pinyinCode")
    private String pinyinCode;

    /**
     * 供应商地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 所属地区
     */
    @Column(name = "area")
    private String area;

    /**
     * 邮政编码
     */
    @Column(name = "zipCode")
    private String zipCode;

    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 联系人
     */
    @Column(name = "contactPerson")
    private String contactPerson;

    /**
     * 开户银行
     */
    @Column(name = "bank")
    private String bank;

    /**
     * 银行账户
     */
    @Column(name = "bankAccount")
    private String bankAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", pinyinCode='" + pinyinCode + '\'' +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", bank='" + bank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
