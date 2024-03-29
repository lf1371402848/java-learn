package com.test.bean;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class DsmsFinances implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.ITEM_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.ITEM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String itemType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.ITEM_FEE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long itemFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.FEE_DATE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Date feeDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.FLAG
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_FINANCES.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String comments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DSMS_FINANCES
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.ID
     *
     * @return the value of DSMS_FINANCES.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.ID
     *
     * @param id the value for DSMS_FINANCES.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.ITEM_ID
     *
     * @return the value of DSMS_FINANCES.ITEM_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.ITEM_ID
     *
     * @param itemId the value for DSMS_FINANCES.ITEM_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.ITEM_TYPE
     *
     * @return the value of DSMS_FINANCES.ITEM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.ITEM_TYPE
     *
     * @param itemType the value for DSMS_FINANCES.ITEM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.ITEM_FEE
     *
     * @return the value of DSMS_FINANCES.ITEM_FEE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getItemFee() {
        return itemFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.ITEM_FEE
     *
     * @param itemFee the value for DSMS_FINANCES.ITEM_FEE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setItemFee(Long itemFee) {
        this.itemFee = itemFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.FEE_DATE
     *
     * @return the value of DSMS_FINANCES.FEE_DATE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Date getFeeDate() {
        return feeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.FEE_DATE
     *
     * @param feeDate the value for DSMS_FINANCES.FEE_DATE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.FLAG
     *
     * @return the value of DSMS_FINANCES.FLAG
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.FLAG
     *
     * @param flag the value for DSMS_FINANCES.FLAG
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_FINANCES.COMMENTS
     *
     * @return the value of DSMS_FINANCES.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_FINANCES.COMMENTS
     *
     * @param comments the value for DSMS_FINANCES.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_FINANCES
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", itemType=").append(itemType);
        sb.append(", itemFee=").append(itemFee);
        sb.append(", feeDate=").append(feeDate);
        sb.append(", flag=").append(flag);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}