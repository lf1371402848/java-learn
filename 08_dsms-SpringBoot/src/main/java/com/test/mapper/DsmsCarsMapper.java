package com.test.mapper;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsCarsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DsmsCarsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    long countByExample(DsmsCarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByExample(DsmsCarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insert(DsmsCars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insertSelective(DsmsCars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    List<DsmsCars> selectByExample(DsmsCarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    DsmsCars selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") DsmsCars record, @Param("example") DsmsCarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExample(@Param("record") DsmsCars record, @Param("example") DsmsCarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKeySelective(DsmsCars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_CARS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKey(DsmsCars record);
}