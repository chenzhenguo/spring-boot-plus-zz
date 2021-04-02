package com.zz.project.provide.projectmanager.param;


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
 * <pre>
 * 申报发布表 分页参数对象
 * </pre>
 *
 * @author czg
 * @date 2021-04-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "申报发布表分页参数")
public class ProjectDeclarePageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;


            @ApiModelProperty("申报类型查询 字典:declare_type")
            private String declareTypeDicCodes;
    @ApiModelProperty("申报类型查询 字典:declare_type-已查询字典")
    private String declareTypeDicCodesString;


            @ApiModelProperty("申报级别 字典declare_level")
            private String declareLevelDicCodes;
    @ApiModelProperty("申报级别 字典declare_level-已查询字典")
    private String declareLevelDicCodesString;


            @ApiModelProperty("项目类型字典project_type")
            private String projectTypelDicCodes;
    @ApiModelProperty("项目类型字典project_type-已查询字典")
    private String projectTypelDicCodesString;


            @ApiModelProperty("是否在线申报1是0否，师科技 默认在线在线申报，国家级 兵团级不支持在线申报")
            private Integer declareOnline;


            @ApiModelProperty("申报标题_like")
            private String declareTitle;


            @ApiModelProperty("申报内容_like")
            private String declareContent;


            @ApiModelProperty("多个附件id")
            private String declareContentAttachment;


            @ApiModelProperty("申报开始时间")
            private Date declareStime;


            @ApiModelProperty("申报结束时间")
            private Date declareEtime;


    @ApiModelProperty("开始时间")
    private Date beginDate;

    @ApiModelProperty("结束时间")
    private Date endDate;

    @ApiModelProperty("查询时间段字段")
    private String  timeColume="djsj";
}
