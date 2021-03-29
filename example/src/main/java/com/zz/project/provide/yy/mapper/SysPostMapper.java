package com.zz.project.provide.yy.mapper;

import com.zz.common.base.BaseMapper;
import com.zz.project.provide.yy.entity.SysPost;
import com.zz.project.provide.yy.param.SysPostPageParam;
import com.zz.project.provide.yy.vo.SysPostQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 岗位信息表; InnoDB free: 18432 kB Mapper 接口
 *
 * @author czg
 * @since 2021-03-29
 */
@Repository
public interface SysPostMapper extends BaseMapper<SysPost> {

    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    SysPostQueryVo getSysPostById(String sid);

    /**
     * 获取分页对象
     *
     * @param page
     * @param sysPostQueryParam
     * @return
     */
    IPage<SysPostQueryVo> getSysPostPageList(@Param("page") Page page, @Param("param") SysPostPageParam sysPostPageParam);

}
