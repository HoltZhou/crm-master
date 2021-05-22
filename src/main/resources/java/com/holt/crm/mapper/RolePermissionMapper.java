package com.holt.crm.mapper;


import org.apache.ibatis.annotations.Param;

import com.holt.crm.pojo.RolePermission;
import com.holt.crm.pojo.RolePermissionExample;

/**
 * RolePermissionMapper继承基类
 * @author MybatisGenerator
 */
public interface RolePermissionMapper extends MyBatisBaseDao<RolePermission, Integer, RolePermissionExample> {

	/**
	 * 分配权限，批量插入
	 * @param permissionIds
	 * @param roleId
	 * @return
	 * @author huangqingwen
	 */
	public int insertRolePermission(@Param("permissionIds") Integer[] permissionIds, @Param("roleId") Integer roleId);
}