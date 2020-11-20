package com.miyano.enterprisecloud.dao;

import com.miyano.enterprisecloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends MyBatisBaseDao {

    /**
     *
     * @param record
     * @return
     */
    Integer updateByPrimaryKeySelective (User record);

    /**
     * 
     * @param record
     * @return
     */
    @Override
    int insertSelective (Object record);
}