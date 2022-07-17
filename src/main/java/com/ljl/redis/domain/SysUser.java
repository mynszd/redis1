package com.ljl.redis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class SysUser {
    /**
     * 用户编号
     */
    @TableId(value = "usr_id", type = IdType.INPUT)
    private Integer usrId;

    /**
     * 用户名称
     */
    @TableField(value = "usr_name")
    private String usrName;

    /**
     * 用户密码
     */
    @TableField(value = "usr_password")
    private String usrPassword;

    /**
     * 角色编号
     */
    @TableField(value = "usr_role_id")
    private Integer usrRoleId;

    /**
     * 用户状态0：已删除1：正常
     */
    @TableField(value = "usr_flag")
    private Byte usrFlag;
}