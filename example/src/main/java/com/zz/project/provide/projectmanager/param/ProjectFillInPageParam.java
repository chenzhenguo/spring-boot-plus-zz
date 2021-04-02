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
 * 申报填报申请信息表 分页参数对象
 * </pre>
 *
 * @author czg
 * @date 2021-04-02
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "申报填报申请信息表分页参数")
public class ProjectFillInPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;


            @ApiModelProperty("项目名称")
            private String projectName;


            @ApiModelProperty("行业领域字典表user_industry")
            private String projectTerritoryTypeDicCodes;
    @ApiModelProperty("行业领域字典表user_industry-已查询字典")
    private String projectTerritoryTypeDicCodesString;


            @ApiModelProperty("推荐单位")
            private String recommendDepartment;


            @ApiModelProperty("承担单位（申请单位）（存当前登录用户单位的ID）")
            private Integer applyForDepartment;


            @ApiModelProperty("社会统一信用代码")
            private String socialUnifiedCreditCode;


            @ApiModelProperty("法定代表人")
            private String declareContentAttachment;


            @ApiModelProperty("项目负责人")
            private String projectLeader;


            @ApiModelProperty("负责人联系电话")
            private String projectLeaderPhone;


            @ApiModelProperty("申报表ID")
            private Integer declareId;


            @ApiModelProperty("项目附件")
            private String projectAttachment;


            @ApiModelProperty("发布状态")
            private Integer releaseStatus;


            @ApiModelProperty("申报时间")
            private Date declareTime;


            @ApiModelProperty("发布状态0 待审批1初审通过待复审2返回修改3 待上会 4上会中5上会结束6初审未通过7复审未通过8审核通过")
            private Integer declareStatus;


            @ApiModelProperty("发布时间")
            private Date releaseTime;


            @ApiModelProperty("是否需要上会0否1是")
            private Integer toMeeting;


            @ApiModelProperty("项目类型字典project_type")
            private String projectTypeDicCodes;
    @ApiModelProperty("项目类型字典project_type-已查询字典")
    private String projectTypeDicCodesString;


            @ApiModelProperty("申报类型查询 字典:declare_type")
            private String declareTypeDicCodes;
    @ApiModelProperty("申报类型查询 字典:declare_type-已查询字典")
    private String declareTypeDicCodesString;


            @ApiModelProperty("执行时间")
            private Date executeTime;


    @ApiModelProperty("开始时间")
    private Date beginDate;

    @ApiModelProperty("结束时间")
    private Date endDate;

    @ApiModelProperty("查询时间段字段")
    private String  timeColume="djsj";
}
