package com.ruoyi.project.cms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 站点对象 cms_sites
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
public class CmsSites extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** GUID */
    @Excel(name = "GUID")
    private String guid;

    /** 扩展内容 */
    @Excel(name = "扩展内容")
    private String extendvalues;

    /** 站点目录 */
    @Excel(name = "站点目录")
    private String sitedir;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String sitename;

    /** 站点类型 */
    @Excel(name = "站点类型")
    private String sitetype;

    /** 站点图片 */
    @Excel(name = "站点图片")
    private String imageurl;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 站点描述 */
    @Excel(name = "站点描述")
    private String description;

    /** 关联表名 */
    @Excel(name = "关联表名")
    private String tablename;

    /** 是否根目录 */
    @Excel(name = "是否根目录")
    private String root;

    /** 上级站点 */
    @Excel(name = "上级站点")
    private Long parentid;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long ordernum;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationtime;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long creatoruserid;

    /** 最后修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastmodificationtime;

    /** 最后修改人 */
    @Excel(name = "最后修改人")
    private Long lastmodifieruserid;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isdeleted;

    /** 删除人 */
    @Excel(name = "删除人")
    private Long deleteruserid;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deletiontime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGuid(String guid) 
    {
        this.guid = guid;
    }

    public String getGuid() 
    {
        return guid;
    }
    public void setExtendvalues(String extendvalues) 
    {
        this.extendvalues = extendvalues;
    }

    public String getExtendvalues() 
    {
        return extendvalues;
    }
    public void setSitedir(String sitedir) 
    {
        this.sitedir = sitedir;
    }

    public String getSitedir() 
    {
        return sitedir;
    }
    public void setSitename(String sitename) 
    {
        this.sitename = sitename;
    }

    public String getSitename() 
    {
        return sitename;
    }
    public void setSitetype(String sitetype) 
    {
        this.sitetype = sitetype;
    }

    public String getSitetype() 
    {
        return sitetype;
    }
    public void setImageurl(String imageurl) 
    {
        this.imageurl = imageurl;
    }

    public String getImageurl() 
    {
        return imageurl;
    }
    public void setKeywords(String keywords) 
    {
        this.keywords = keywords;
    }

    public String getKeywords() 
    {
        return keywords;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setTablename(String tablename) 
    {
        this.tablename = tablename;
    }

    public String getTablename() 
    {
        return tablename;
    }
    public void setRoot(String root) 
    {
        this.root = root;
    }

    public String getRoot() 
    {
        return root;
    }
    public void setParentid(Long parentid) 
    {
        this.parentid = parentid;
    }

    public Long getParentid() 
    {
        return parentid;
    }
    public void setOrdernum(Long ordernum) 
    {
        this.ordernum = ordernum;
    }

    public Long getOrdernum() 
    {
        return ordernum;
    }
    public void setCreationtime(Date creationtime) 
    {
        this.creationtime = creationtime;
    }

    public Date getCreationtime() 
    {
        return creationtime;
    }
    public void setCreatoruserid(Long creatoruserid) 
    {
        this.creatoruserid = creatoruserid;
    }

    public Long getCreatoruserid() 
    {
        return creatoruserid;
    }
    public void setLastmodificationtime(Date lastmodificationtime) 
    {
        this.lastmodificationtime = lastmodificationtime;
    }

    public Date getLastmodificationtime() 
    {
        return lastmodificationtime;
    }
    public void setLastmodifieruserid(Long lastmodifieruserid) 
    {
        this.lastmodifieruserid = lastmodifieruserid;
    }

    public Long getLastmodifieruserid() 
    {
        return lastmodifieruserid;
    }
    public void setIsdeleted(Integer isdeleted) 
    {
        this.isdeleted = isdeleted;
    }

    public Integer getIsdeleted() 
    {
        return isdeleted;
    }
    public void setDeleteruserid(Long deleteruserid) 
    {
        this.deleteruserid = deleteruserid;
    }

    public Long getDeleteruserid() 
    {
        return deleteruserid;
    }
    public void setDeletiontime(Date deletiontime) 
    {
        this.deletiontime = deletiontime;
    }

    public Date getDeletiontime() 
    {
        return deletiontime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("guid", getGuid())
            .append("extendvalues", getExtendvalues())
            .append("sitedir", getSitedir())
            .append("sitename", getSitename())
            .append("sitetype", getSitetype())
            .append("imageurl", getImageurl())
            .append("keywords", getKeywords())
            .append("description", getDescription())
            .append("tablename", getTablename())
            .append("root", getRoot())
            .append("parentid", getParentid())
            .append("ordernum", getOrdernum())
            .append("creationtime", getCreationtime())
            .append("creatoruserid", getCreatoruserid())
            .append("lastmodificationtime", getLastmodificationtime())
            .append("lastmodifieruserid", getLastmodifieruserid())
            .append("isdeleted", getIsdeleted())
            .append("deleteruserid", getDeleteruserid())
            .append("deletiontime", getDeletiontime())
            .toString();
    }
}
