package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 药品采购明细
 */
@Entity
@Table(name = "storage_detail")
public class StorageDetail extends BaseEntity {

    /**
     * 入库单据号
     */
    @Column(name = "documentNo")
    private String documentNo;

    /**
     * 药品编号
     */
    @Column(name = "drugNumber")
    private String drugNumber;

    /**
     * 入库数量
     */
    @Column(name = "storageAmount")
    private String storageAmount;

    /**
     * 入库单价
     */
    @Column(name = "storageUnitPrice")
    private String storageUnitPrice;

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
     * 库存数量
     */
    @Column(name = "storageAmounting")
    private String storageAmounting;

    /**
     * 入库状态
     */
    @Column(name = "storageStatus")
    private String storageStatus;

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(String drugNumber) {
        this.drugNumber = drugNumber;
    }

    public String getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(String storageAmount) {
        this.storageAmount = storageAmount;
    }

    public String getStorageUnitPrice() {
        return storageUnitPrice;
    }

    public void setStorageUnitPrice(String storageUnitPrice) {
        this.storageUnitPrice = storageUnitPrice;
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

    public String getStorageAmounting() {
        return storageAmounting;
    }

    public void setStorageAmounting(String storageAmounting) {
        this.storageAmounting = storageAmounting;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    @Override
    public String toString() {
        return "StorageDetail{" +
                "documentNo='" + documentNo + '\'' +
                ", drugNumber='" + drugNumber + '\'' +
                ", storageAmount='" + storageAmount + '\'' +
                ", storageUnitPrice='" + storageUnitPrice + '\'' +
                ", storageAllPrice='" + storageAllPrice + '\'' +
                ", storageDate='" + storageDate + '\'' +
                ", storageAmounting='" + storageAmounting + '\'' +
                ", storageStatus='" + storageStatus + '\'' +
                '}';
    }
}
