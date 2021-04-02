package com.zz.project.provide.projectmanager.mapper;

import com.zz.common.base.BaseMapper;
import com.zz.project.provide.projectmanager.entity.ProjectDeclare;
import com.zz.project.provide.projectmanager.param.ProjectDeclarePageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;
import java.util.Date

/**
 * 申报发布表 Mapper 接口
 *
 * @author czg
 * @since 2021-04-02
 */
@Repository
public interface ProjectDeclareMapper extends BaseMapper<ProjectDeclare> {

    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    ProjectDeclare getProjectDeclareById(String sid);

    /**
     * 获取分页对象
     *
     * @param page
     * @param
     * @return
     */
    IPage<ProjectDeclare> getProjectDeclarePageList(@Param("page") Page page, @Param("param") ProjectDeclarePageParam projectDeclarePageParam);

}
