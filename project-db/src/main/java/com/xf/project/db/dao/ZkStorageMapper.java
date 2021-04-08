package com.xf.project.db.dao;

import com.xf.project.db.domain.ZkStorage;
import com.xf.project.db.domain.ZkStorageExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ZkStorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    long countByExample(ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int deleteByExample(ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int insert(ZkStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int insertSelective(ZkStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    ZkStorage selectOneByExample(ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    ZkStorage selectOneByExampleSelective(@Param("example") ZkStorageExample example, @Param("selective") ZkStorage.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    List<ZkStorage> selectByExampleSelective(@Param("example") ZkStorageExample example, @Param("selective") ZkStorage.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    List<ZkStorage> selectByExample(ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    ZkStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") ZkStorage.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    ZkStorage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    ZkStorage selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ZkStorage record, @Param("example") ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ZkStorage record, @Param("example") ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ZkStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ZkStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") ZkStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_storage
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
