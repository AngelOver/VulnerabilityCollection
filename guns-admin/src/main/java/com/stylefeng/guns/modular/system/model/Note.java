package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 便签表
 * </p>
 *
 * @author stylefeng
 * @since 2018-07-04
 */
@TableName("Note")
public class Note extends Model<Note> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年纪
     */
    private Integer age;
    /**
     * 备注
     */
    private String remark;
    /**
     * 时间
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Note{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", remark=" + remark +
        ", time=" + time +
        "}";
    }
}
