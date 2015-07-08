package com.trunkshell.voj.web.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.trunkshell.voj.web.model.UserGroup;

/**
 * UserGroup Data Access Object.
 * @author Xie Haozhe
 */
@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface UserGroupMapper {
    /**
     * 通过用户组的唯一标识符获取用户组对象.
     * @param userGroupId - 用户组的唯一标识符
     * @return 预期的用户组对象或空引用
     */
    @Select("SELECT * FROM voj_user_groups WHERE user_group_id = #{userGroupId}")
    @Options(useCache = true)
    @Results({
         @Result(property = "userGroupId", column = "user_group_id"),
         @Result(property = "userGroupSlug", column = "user_group_slug"),
         @Result(property = "userGroupName", column = "user_group_name")
    })
    public UserGroup getUserGroupUsingId(@Param("userGroupId") int userGroupId);
    
    /**
     * 通过用户组的唯一英文缩写获取用户组对象.
     * @param userGroupSlug - 用户组的唯一英文缩写
     * @return 预期的用户组对象或空引用
     */
    @Select("SELECT * FROM voj_user_groups WHERE user_group_slug = #{userGroupSlug}")
    @Options(useCache = true)
    @Results({
         @Result(property = "userGroupId", column = "user_group_id"),
         @Result(property = "userGroupSlug", column = "user_group_slug"),
         @Result(property = "userGroupName", column = "user_group_name")
    })
    public UserGroup getUserGroupUsingSlug(@Param("userGroupSlug") String userGroupSlug);
}
