package com.test.mapper;

import com.test.bean.DsmsTrainers;
import com.test.bean.DsmsTrainersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DsmsTrainersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    long countByExample(DsmsTrainersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByExample(DsmsTrainersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insert(DsmsTrainers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insertSelective(DsmsTrainers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    List<DsmsTrainers> selectByExample(DsmsTrainersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    DsmsTrainers selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") DsmsTrainers record, @Param("example") DsmsTrainersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExample(@Param("record") DsmsTrainers record, @Param("example") DsmsTrainersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKeySelective(DsmsTrainers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_TRAINERS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKey(DsmsTrainers record);
}