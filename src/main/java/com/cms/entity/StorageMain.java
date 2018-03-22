package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "storage_main")
public class StorageMain extends BaseEntity {

    /**
     * 品种数量
     */
    @Column(name = "speciesAmount")
    private String speciesAmount;

    /**
     * 入库数量
     */
    @Column(name = "storageAmount")
    private String storageAmount;

    /**
     * 入库金额
     */
    @Column(name = "storageAllPrice")
    private String storageAllPrice;

    /**
     * 入库日期
     */
    @Column(name = "storageDate")
    private String storageDate;

    /**
     * 入库状态
     */
    @Column(name = "storageStatus")
    private String storageStatus;

    /**
     * 经手人
     */
    @Column(name = "transactor")
    private String transactor;

    /**
     * 供应商编号
     */
    @Column(name = "supplierNo")
    private String supplierNo;

    public String getSpeciesAmount() {
        return speciesAmount;
    }

    public void setSpeciesAmount(String speciesAmount) {
        this.speciesAmount = speciesAmount;
    }

    public String getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(String storageAmount) {
        this.storageAmount = storageAmount;
    }

    public String getStorageAllPrice() {
        return storageAllPrice;
    }

    public void setStorageAllPrice(String storageAllPrice) {
        this.storageAllPrice = storageAllPrice;
    }

    public String getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(String storageDate) {
        this.storageDate = storageDate;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getTransactor() {
        return transactor;
    }

    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    @Override
    public String toString() {
        return "StorageMain{" +
                "speciesAmount='" + speciesAmount + '\'' +
                ", storageAmount='" + storageAmount + '\'' +
                ", storageAllPrice='" + storageAllPrice + '\'' +
                ", storageDate='" + storageDate + '\'' +
                ", storageStatus='" + storageStatus + '\'' +
                ", transactor='" + transactor + '\'' +
                ", supplierNo='" + supplierNo + '\'' +
                '}';
    }
}
