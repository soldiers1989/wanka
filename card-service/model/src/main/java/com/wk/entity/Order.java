package com.wk.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单表
 */
public class Order extends BaseEntity implements Serializable {
    private String customerId ;//下单客户ID
    private Integer type    ;//订单类型
    private BigDecimal total   ;//订单总金额
    private BigDecimal rate    ;//手续 费率
    private BigDecimal fee     ;//手续费
    private BigDecimal discount;//优惠金额
    private BigDecimal realFee;//实收
    private Integer status  ;//订单状态
    private String remark  ;//备注
    private String seg     ;//排序值

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getRealFee() {
        return realFee;
    }

    public void setRealFee(BigDecimal realFee) {
        this.realFee = realFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSeg() {
        return seg;
    }

    public void setSeg(String seg) {
        this.seg = seg;
    }
}
