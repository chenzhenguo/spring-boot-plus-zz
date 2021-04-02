package com.zz.project.provide.projectmanager.controller;

import com.zz.project.provide.projectmanager.entity.ProjectDeclare;
import com.zz.project.provide.projectmanager.service.IProjectDeclareService;
import lombok.extern.slf4j.Slf4j;
import com.zz.project.provide.projectmanager.param.ProjectDeclarePageParam;


import com.zz.common.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.common.model.PageRequest;

/**
 * 申报发布表 控制器
 *
 * @author czg
 * @since 2021-04-02
 */
@Slf4j
@RestController
@RequestMapping("/projectDeclare")
@Api(value = "申报发布表API", tags = {"申报发布表"})
public class ProjectDeclareController {


    @Autowired
    private IProjectDeclareService projectDeclareService;

    /**
     * 添加申报发布表
     */
    @PostMapping("/add")
    @Log(modelName = "申报发布表", action = Log.ADD,description="添加申报发布表")
    @ApiOperation(value = "添加申报发布表")
    public Boolean addProjectDeclare(ProjectDeclare projectDeclare)   {
        return  projectDeclareService.saveOrUpdate(projectDeclare);
    }

    /**
     * 修改申报发布表
     */
    @PostMapping("/update")
   @Log(modelName = "修改申报发布表", action = Log.UPDATE,description="修改申报发布表")
    @ApiOperation(value = "修改申报发布表")
    public Boolean updateProjectDeclare( ProjectDeclare projectDeclare)   {
        return projectDeclareService.updateProjectDeclare(projectDeclare);
    }

    /**
     * 删除申报发布表
     */
    @PostMapping("delete")
   @Log(modelName = "删除申报发布表", action =Log.DELETE,description="删除申报发布表")
    @ApiOperation(value = "删除申报发布表")
    public boolean  deleteProjectDeclare(String  sid) {
        return projectDeclareService.deleteProjectDeclare(sid);
    }


    /**
     * 批量删除申报发布表
     */
    @PostMapping("delBatch")
    @Log(modelName = "批量删除申报发布表", action =Log.DELETE,description="批量删除除申报发布表")
    @ApiOperation(value = "批量删除申报发布表")
     public Boolean delBatchProjectDeclare(@RequestParam(value="sids") List<String> sids ){

        return  projectDeclareService.delBatchProjectDeclare(sids);
     }


    /**
     * 根据id 获取申报发布表详情
     */
    @PostMapping("getById")
   @Log(modelName = "申报发布表详情", action = Log.SELECT,description="根据id查询申报发布表")
    @ApiOperation(value = "申报发布表详情", response = ProjectDeclare.class)
    public ProjectDeclare getByIdProjectDeclare( String id)   {
        return      projectDeclareService.getProjectDeclareById(id);
    }

    /**
     * 申报发布表分页列表
     */
    @PostMapping("/getPageList")
       @Log(modelName = "申报发布表分页列表", action = Log.SELECT,description="分页查询查询申报发布表")
    @ApiOperation(value = "申报发布表分页列表", response = ProjectDeclare.class)
    public Paging<ProjectDeclare> getProjectDeclarePageList( ProjectDeclarePageParam projectDeclarePageParam)   {
        return projectDeclareService.getProjectDeclarePageList(projectDeclarePageParam);
    }

}

