package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role_power")
public class Role_Power implements Serializable {

    @TableField("roleid")
    private Integer roleId;

    @TableField("powerid")
    private Integer powerId;
}
