package com.softding.business.banner.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.softding.common.annotation.Excel;
import com.softding.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网站banner对象 ws_banner
 * 
 * @author softding
 * @date 2020-01-19
 */

@TableName("ws_banner")
public class Banner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String imagePath;

    /** 是否有效：0-否；1-是； */
    @Excel(name = "是否有效：0-否；1-是；")
    private Boolean state;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String addUser;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editTime;

    /** 修改人 */
    @Excel(name = "修改人")
    private String editUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }
    public void setState(Boolean state) 
    {
        this.state = state;
    }

    public Boolean getState() 
    {
        return state;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setAddUser(String addUser) 
    {
        this.addUser = addUser;
    }

    public String getAddUser() 
    {
        return addUser;
    }
    public void setEditTime(Date editTime) 
    {
        this.editTime = editTime;
    }

    public Date getEditTime() 
    {
        return editTime;
    }
    public void setEditUser(String editUser) 
    {
        this.editUser = editUser;
    }

    public String getEditUser() 
    {
        return editUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imagePath", getImagePath())
            .append("state", getState())
            .append("sort", getSort())
            .append("addTime", getAddTime())
            .append("addUser", getAddUser())
            .append("editTime", getEditTime())
            .append("editUser", getEditUser())
            .toString();
    }
}
