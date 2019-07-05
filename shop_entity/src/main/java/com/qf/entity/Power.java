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
@TableName("t_power")
public class Power implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("parentid")
    private Integer parentId;

    @TableField("powername")
    private String powerName;

    @TableField("powerpath")
    private String powerPath;

    @TableField("createtime")
    private Date createTime;

    private Integer status;

    @TableField(exist = false)
    private String pname;

    @TableField(exist = false)
    private boolean checked;
}
