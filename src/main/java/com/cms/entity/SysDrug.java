package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by HOZANDUNG on 18//15.
 * 药品基本信息
 */
@Entity
@Table(name = "sys_drug")
public class SysDrug extends BaseEntity {

    /**
     * 学名
     */
    @Column(name = "name")
    private String name;

    /**
     * 药品类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 药品介绍
     */
    @Column(name = "introduce")
    private String introduce;

    /**
     * 药品条形
     */
    @Column(name = "drugbar")
    private String drugbar;

    /**
     * 通用名字
     */
    @Column(name = "genericName")
    private String genericName;

    /**
     * 拼音码
     */
    @Column(name = "pinyinCode")
    private String pinyinCode;

    /**
     * 零售价格
     */
    @Column(name = "retailPrice")
    private String retailPrice;

    /**
     * 进货价格
     */
    @Column(name = "replenishPrice")
    private String replenishPrice;

    /**
     * 药品单位
     */
    @Column(name = "unit")
    private String unit;

    /**
     * 剂量
     */
    @Column(name = "dosage")
    private String dosage;

    /**
     * 产地
     */
    @Column(name = "origin")
    private String origin;

    /**
     * 时效性
     */
    @Column(name = "validity")
    private String validity;

    /**
     * 质量标准
     */
    @Column(name = "qualityStandard")
    private String qualityStandard;

    /**
     * 经营方式
     */
    @Column(name = "operation")
    private String operation;

    /**
     * 批号
     */
    @Column(name = "batchNumber")
    private String batchNumber;

    /**
     * 库存
     */
    @Column(name = "storageNumber")
    private String storageNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDrugbar() {
        return drugbar;
    }

    public void setDrugbar(String drugbar) {
        this.drugbar = drugbar;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getReplenishPrice() {
        return replenishPrice;
    }

    public void setReplenishPrice(String replenishPrice) {
        this.replenishPrice = replenishPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getQualityStandard() {
        return qualityStandard;
    }

    public void setQualityStandard(String qualityStandard) {
        this.qualityStandard = qualityStandard;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber;
    }

    @Override
    public String toString() {
        return "SysDrug{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", drugbar='" + drugbar + '\'' +
                ", genericName='" + genericName + '\'' +
                ", pinyinCode='" + pinyinCode + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", replenishPrice='" + replenishPrice + '\'' +
                ", unit='" + unit + '\'' +
                ", dosage='" + dosage + '\'' +
                ", origin='" + origin + '\'' +
                ", validity='" + validity + '\'' +
                ", qualityStandard='" + qualityStandard + '\'' +
                ", operation='" + operation + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", storageNumber='" + storageNumber + '\'' +
                '}';
    }
}
