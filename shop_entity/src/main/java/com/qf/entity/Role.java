package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role")
public class Role implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("rolename")
    private String roleName;

    private String alias;

    @TableField("createtime")
    private Date createTime = new Date();

    private Integer status;

    @TableField(exist = false)
    private boolean checked;
}
