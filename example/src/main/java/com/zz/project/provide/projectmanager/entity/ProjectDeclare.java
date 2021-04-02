package com.zz.project.provide.projectmanager.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zz.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 申报管理表
 *
 * @author czg
 * @since 2021-04-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("zz_project_declare")
@ApiModel(value = "ProjectDeclare实体对象")
public class ProjectDeclare extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("申报类型")
    private Integer declareTypeDicCodes;

    @ApiModelProperty("申报类型-已查询字典")
    @TableField(exist=false)
    private BigDecimal declareTypeDicCodesString;

    @ApiModelProperty("申报级别")
    private Integer declareLevel;

    @ApiModelProperty("项目类型")
    private String projectTypel;

    @ApiModelProperty("是否在线申报")
    private Integer declareOnline;

    @ApiModelProperty("申报标题")
    private String declareTitle;

    @ApiModelProperty("申报内容_like")
    private String declareContent;

    @ApiModelProperty("多个附件id")
    private String declareContentAttachment;

    @ApiModelProperty("申报开始时间")
    private Date declareStime;

    @ApiModelProperty("申报结束时间")
    private Date declareEtime;

}
