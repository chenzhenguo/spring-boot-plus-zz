package com.zz.project.provide.yy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 岗位信息表; InnoDB free: 18432 kB 查询结果对象
 * </pre>
 *
 * @author czg
 * @date 2021-03-29
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SysPostQueryVo对象")
public class SysPostQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("岗位ID")
    private Long postId;

    @ApiModelProperty("岗位编码")
    private String postCode;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("显示顺序")
    private Integer postSort;

    @ApiModelProperty("状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("备注")
    private String remark;
}