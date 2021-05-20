package com.test.mapper;

import com.test.bean.DsmsExamPlans;
import com.test.bean.DsmsExamPlansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsmsExamPlansMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    long countByExample(DsmsExamPlansExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByExample(DsmsExamPlansExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insert(DsmsExamPlans record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insertSelective(DsmsExamPlans record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    List<DsmsExamPlans> selectByExample(DsmsExamPlansExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    DsmsExamPlans selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") DsmsExamPlans record, @Param("example") DsmsExamPlansExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExample(@Param("record") DsmsExamPlans record, @Param("example") DsmsExamPlansExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKeySelective(DsmsExamPlans record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_EXAM_PLANS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKey(DsmsExamPlans record);
}