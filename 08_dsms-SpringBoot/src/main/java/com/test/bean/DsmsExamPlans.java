package com.test.bean;

import java.io.Serializable;
import java.util.Date;

public class DsmsExamPlans implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.PLAN_NO
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String planNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.PLACE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String place;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.ADDRESS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.EXAM_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Date examTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.EXAM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String examType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.CAR_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String carType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.PEOPLE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private Long people;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DSMS_EXAM_PLANS.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private String comments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.ID
     *
     * @return the value of DSMS_EXAM_PLANS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.ID
     *
     * @param id the value for DSMS_EXAM_PLANS.ID
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.PLAN_NO
     *
     * @return the value of DSMS_EXAM_PLANS.PLAN_NO
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getPlanNo() {
        return planNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.PLAN_NO
     *
     * @param planNo the value for DSMS_EXAM_PLANS.PLAN_NO
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.PLACE
     *
     * @return the value of DSMS_EXAM_PLANS.PLACE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.PLACE
     *
     * @param place the value for DSMS_EXAM_PLANS.PLACE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.ADDRESS
     *
     * @return the value of DSMS_EXAM_PLANS.ADDRESS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.ADDRESS
     *
     * @param address the value for DSMS_EXAM_PLANS.ADDRESS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.EXAM_TIME
     *
     * @return the value of DSMS_EXAM_PLANS.EXAM_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.EXAM_TIME
     *
     * @param examTime the value for DSMS_EXAM_PLANS.EXAM_TIME
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.EXAM_TYPE
     *
     * @return the value of DSMS_EXAM_PLANS.EXAM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getExamType() {
        return examType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.EXAM_TYPE
     *
     * @param examType the value for DSMS_EXAM_PLANS.EXAM_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.CAR_TYPE
     *
     * @return the value of DSMS_EXAM_PLANS.CAR_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getCarType() {
        return carType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.CAR_TYPE
     *
     * @param carType the value for DSMS_EXAM_PLANS.CAR_TYPE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.PEOPLE
     *
     * @return the value of DSMS_EXAM_PLANS.PEOPLE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public Long getPeople() {
        return people;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.PEOPLE
     *
     * @param people the value for DSMS_EXAM_PLANS.PEOPLE
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setPeople(Long people) {
        this.people = people;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.STATUS
     *
     * @return the value of DSMS_EXAM_PLANS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.STATUS
     *
     * @param status the value for DSMS_EXAM_PLANS.STATUS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DSMS_EXAM_PLANS.COMMENTS
     *
     * @return the value of DSMS_EXAM_PLANS.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DSMS_EXAM_PLANS.COMMENTS
     *
     * @param comments the value for DSMS_EXAM_PLANS.COMMENTS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
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
        sb.append(", planNo=").append(planNo);
        sb.append(", place=").append(place);
        sb.append(", address=").append(address);
        sb.append(", examTime=").append(examTime);
        sb.append(", examType=").append(examType);
        sb.append(", carType=").append(carType);
        sb.append(", people=").append(people);
        sb.append(", status=").append(status);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}