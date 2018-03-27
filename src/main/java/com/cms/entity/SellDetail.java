package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 采购明细
 */
@Entity
@Table(name = "sell_detail")
public class SellDetail extends BaseEntity {

    /**
     * 销售流水号
     */
    @Column(name = "sellNo")
    private String sellNo;

    /**
     * 药品编号
     */
    @Column(name = "drugNumber")
    private String drugNumber;

    /**
     * 销售单据
     */
    @Column(name = "sellCredentials")
    private String sellCredentials;

    /**
     * 销售数量
     */
    @Column(name = "sellNumber")
    private String sellNumber;

    /**
     * 销售金额
     */
    @Column(name = "sellPrice")
    private String sellPrice;

    /**
     * 销售日期
     */
    @Column(name = "sellDate")
    private String sellDate;

    /**
     * 退款状态
     */
    @Column(name = "refundStatus")
    private String refundStatus;

    public String getSellNo() {
        return sellNo;
    }

    public void setSellNo(String sellNo) {
        this.sellNo = sellNo;
    }

    public String getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(String drugNumber) {
        this.drugNumber = drugNumber;
    }

    public String getSellCredentials() {
        return sellCredentials;
    }

    public void setSellCredentials(String sellCredentials) {
        this.sellCredentials = sellCredentials;
    }

    public String getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(String sellNumber) {
        this.sellNumber = sellNumber;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Override
    public String toString() {
        return "SellDetail{" +
                "sellNo='" + sellNo + '\'' +
                ", drugNumber='" + drugNumber + '\'' +
                ", sellCredentials='" + sellCredentials + '\'' +
                ", sellNumber='" + sellNumber + '\'' +
                ", sellPrice='" + sellPrice + '\'' +
                ", sellDate='" + sellDate + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                '}';
    }
}
