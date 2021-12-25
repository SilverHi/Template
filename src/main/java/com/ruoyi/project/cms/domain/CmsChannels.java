package com.ruoyi.project.cms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 频道对象 cms_channels
 * 
 * @author ruoyi
 * @date 2021-12-25
 */
public class CmsChannels extends BaseEntity
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

    /** 频道名称 */
    @Excel(name = "频道名称")
    private String channelname;

    /** 所属站点 */
    @Excel(name = "所属站点")
    private Long siteid;

    /** 内容插件ID */
    @Excel(name = "内容插件ID")
    private String contentmodelpluginid;

    /** 关联表名 */
    @Excel(name = "关联表名")
    private String tablename;

    /** 父级ID */
    @Excel(name = "父级ID")
    private Long parentid;

    /** 父级路径 */
    @Excel(name = "父级路径")
    private String parentspath;

    /** 父级数量 */
    @Excel(name = "父级数量")
    private Long parentscount;

    /** 子级数量 */
    @Excel(name = "子级数量")
    private Long childrencount;

    /** 排序名称 */
    @Excel(name = "排序名称")
    private String indexname;

    /** 分组 */
    @Excel(name = "分组")
    private String groupnames;

    /** 图片 */
    @Excel(name = "图片")
    private String imageurl;

    /** 内容描述 */
    @Excel(name = "内容描述")
    private String content;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filepath;

    /** 频道路径路径规则 */
    @Excel(name = "频道路径路径规则")
    private String channelfilepathrule;

    /** 内容文件路径规则 */
    @Excel(name = "内容文件路径规则")
    private String contentfilepathrule;

    /** 外链 */
    @Excel(name = "外链")
    private String linkurl;

    /** 外链类型 */
    @Excel(name = "外链类型")
    private String linktype;

    /** 频道模版 */
    @Excel(name = "频道模版")
    private Long channeltemplteid;

    /** 内容模版 */
    @Excel(name = "内容模版")
    private Long contenttemplateid;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 排序 */
    @Excel(name = "排序")
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
    public void setChannelname(String channelname) 
    {
        this.channelname = channelname;
    }

    public String getChannelname() 
    {
        return channelname;
    }
    public void setSiteid(Long siteid) 
    {
        this.siteid = siteid;
    }

    public Long getSiteid() 
    {
        return siteid;
    }
    public void setContentmodelpluginid(String contentmodelpluginid) 
    {
        this.contentmodelpluginid = contentmodelpluginid;
    }

    public String getContentmodelpluginid() 
    {
        return contentmodelpluginid;
    }
    public void setTablename(String tablename) 
    {
        this.tablename = tablename;
    }

    public String getTablename() 
    {
        return tablename;
    }
    public void setParentid(Long parentid) 
    {
        this.parentid = parentid;
    }

    public Long getParentid() 
    {
        return parentid;
    }
    public void setParentspath(String parentspath) 
    {
        this.parentspath = parentspath;
    }

    public String getParentspath() 
    {
        return parentspath;
    }
    public void setParentscount(Long parentscount) 
    {
        this.parentscount = parentscount;
    }

    public Long getParentscount() 
    {
        return parentscount;
    }
    public void setChildrencount(Long childrencount) 
    {
        this.childrencount = childrencount;
    }

    public Long getChildrencount() 
    {
        return childrencount;
    }
    public void setIndexname(String indexname) 
    {
        this.indexname = indexname;
    }

    public String getIndexname() 
    {
        return indexname;
    }
    public void setGroupnames(String groupnames) 
    {
        this.groupnames = groupnames;
    }

    public String getGroupnames() 
    {
        return groupnames;
    }
    public void setImageurl(String imageurl) 
    {
        this.imageurl = imageurl;
    }

    public String getImageurl() 
    {
        return imageurl;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setFilepath(String filepath) 
    {
        this.filepath = filepath;
    }

    public String getFilepath() 
    {
        return filepath;
    }
    public void setChannelfilepathrule(String channelfilepathrule) 
    {
        this.channelfilepathrule = channelfilepathrule;
    }

    public String getChannelfilepathrule() 
    {
        return channelfilepathrule;
    }
    public void setContentfilepathrule(String contentfilepathrule) 
    {
        this.contentfilepathrule = contentfilepathrule;
    }

    public String getContentfilepathrule() 
    {
        return contentfilepathrule;
    }
    public void setLinkurl(String linkurl) 
    {
        this.linkurl = linkurl;
    }

    public String getLinkurl() 
    {
        return linkurl;
    }
    public void setLinktype(String linktype) 
    {
        this.linktype = linktype;
    }

    public String getLinktype() 
    {
        return linktype;
    }
    public void setChanneltemplteid(Long channeltemplteid) 
    {
        this.channeltemplteid = channeltemplteid;
    }

    public Long getChanneltemplteid() 
    {
        return channeltemplteid;
    }
    public void setContenttemplateid(Long contenttemplateid) 
    {
        this.contenttemplateid = contenttemplateid;
    }

    public Long getContenttemplateid() 
    {
        return contenttemplateid;
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
            .append("channelname", getChannelname())
            .append("siteid", getSiteid())
            .append("contentmodelpluginid", getContentmodelpluginid())
            .append("tablename", getTablename())
            .append("parentid", getParentid())
            .append("parentspath", getParentspath())
            .append("parentscount", getParentscount())
            .append("childrencount", getChildrencount())
            .append("indexname", getIndexname())
            .append("groupnames", getGroupnames())
            .append("imageurl", getImageurl())
            .append("content", getContent())
            .append("filepath", getFilepath())
            .append("channelfilepathrule", getChannelfilepathrule())
            .append("contentfilepathrule", getContentfilepathrule())
            .append("linkurl", getLinkurl())
            .append("linktype", getLinktype())
            .append("channeltemplteid", getChanneltemplteid())
            .append("contenttemplateid", getContenttemplateid())
            .append("keywords", getKeywords())
            .append("description", getDescription())
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
