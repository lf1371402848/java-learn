package com.test.bean;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class DsmsExamOrders implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_ORDERS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_ORDERS.EXAM_PLAN_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long examPlanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_ORDERS.TRAINEE_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long traineeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_ORDERS.ORDER_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Date orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_ORDERS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DSMS_EXAM_ORDERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_ORDERS.ID
     *
     * @return the value of DSMS_EXAM_ORDERS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_ORDERS.ID
     *
     * @param id the value for DSMS_EXAM_ORDERS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_ORDERS.EXAM_PLAN_ID
     *
     * @return the value of DSMS_EXAM_ORDERS.EXAM_PLAN_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getExamPlanId() {
        return examPlanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_ORDERS.EXAM_PLAN_ID
     *
     * @param examPlanId the value for DSMS_EXAM_ORDERS.EXAM_PLAN_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setExamPlanId(Long examPlanId) {
        this.examPlanId = examPlanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_ORDERS.TRAINEE_ID
     *
     * @return the value of DSMS_EXAM_ORDERS.TRAINEE_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getTraineeId() {
        return traineeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_ORDERS.TRAINEE_ID
     *
     * @param traineeId the value for DSMS_EXAM_ORDERS.TRAINEE_ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_ORDERS.ORDER_TIME
     *
     * @return the value of DSMS_EXAM_ORDERS.ORDER_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_ORDERS.ORDER_TIME
     *
     * @param orderTime the value for DSMS_EXAM_ORDERS.ORDER_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_ORDERS.STATUS
     *
     * @return the value of DSMS_EXAM_ORDERS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_ORDERS.STATUS
     *
     * @param status the value for DSMS_EXAM_ORDERS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_ORDERS
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
        sb.append(", examPlanId=").append(examPlanId);
        sb.append(", traineeId=").append(traineeId);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}