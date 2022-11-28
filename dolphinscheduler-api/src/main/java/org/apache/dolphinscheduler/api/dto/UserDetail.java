/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package org.apache.dolphinscheduler.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 登录用户信息
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;



    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String username;
    private String realName;
    private String headUrl;
    private Integer gender;
    private String email;
    private String mobile;
    private Integer level;
    private Integer levelCode;
    private Long deptId;
    private String password;
    private Integer status;
    private Integer superAdmin;
    private Integer superTenant;
    /**
     * 租户编码
     */
    private Long tenantCode;
    /**
     * 部门数据权限
     */
    private List<Long> deptIdList;

//    private Boolean needChangePassword;

}