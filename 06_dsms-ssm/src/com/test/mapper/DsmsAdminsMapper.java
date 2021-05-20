package com.test.mapper;

import com.test.bean.DsmsAdmins;
import com.test.bean.DsmsAdminsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsmsAdminsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    long countByExample(DsmsAdminsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByExample(DsmsAdminsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insert(DsmsAdmins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int insertSelective(DsmsAdmins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    List<DsmsAdmins> selectByExample(DsmsAdminsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    DsmsAdmins selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") DsmsAdmins record, @Param("example") DsmsAdminsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByExample(@Param("record") DsmsAdmins record, @Param("example") DsmsAdminsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKeySelective(DsmsAdmins record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DSMS_ADMINS
     *
     * @mbg.generated Fri May 17 00:30:56 CST 2019
     */
    int updateByPrimaryKey(DsmsAdmins record);
}