package com.zz.project.provide.yy.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 岗位信息表; InnoDB free: 18432 kB 分页参数对象
 * </pre>
 *
 * @author czg
 * @date 2021-03-29
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "岗位信息表; InnoDB free: 18432 kB分页参数")
public class SysPostPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
