package com.zz.project.provide.projectmanager.controller;

import com.zz.project.provide.projectmanager.entity.ProjectFillIn;
import com.zz.project.provide.projectmanager.service.IProjectFillInService;
import lombok.extern.slf4j.Slf4j;
import com.zz.project.provide.projectmanager.param.ProjectFillInPageParam;


import com.zz.common.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.common.model.PageRequest;

/**
 * 申报填报申请信息表 控制器
 *
 * @author czg
 * @since 2021-04-02
 */
@Slf4j
@RestController
@RequestMapping("/projectFillIn")
@Api(value = "申报填报申请信息表API", tags = {"申报填报申请信息表"})
public class ProjectFillInController {


    @Autowired
    private IProjectFillInService projectFillInService;

    /**
     * 添加申报填报申请信息表
     */
    @PostMapping("/add")
    @Log(modelName = "申报填报申请信息表", action = Log.ADD,description="添加申报填报申请信息表")
    @ApiOperation(value = "添加申报填报申请信息表")
    public Boolean addProjectFillIn(ProjectFillIn projectFillIn)   {
        return  projectFillInService.saveOrUpdate(projectFillIn);
    }

    /**
     * 修改申报填报申请信息表
     */
    @PostMapping("/update")
   @Log(modelName = "修改申报填报申请信息表", action = Log.UPDATE,description="修改申报填报申请信息表")
    @ApiOperation(value = "修改申报填报申请信息表")
    public Boolean updateProjectFillIn( ProjectFillIn projectFillIn)   {
        return projectFillInService.updateProjectFillIn(projectFillIn);
    }

    /**
     * 删除申报填报申请信息表
     */
    @PostMapping("delete")
   @Log(modelName = "删除申报填报申请信息表", action =Log.DELETE,description="删除申报填报申请信息表")
    @ApiOperation(value = "删除申报填报申请信息表")
    public boolean  deleteProjectFillIn(String  sid) {
        return projectFillInService.deleteProjectFillIn(sid);
    }


    /**
     * 批量删除申报填报申请信息表
     */
    @PostMapping("delBatch")
    @Log(modelName = "批量删除申报填报申请信息表", action =Log.DELETE,description="批量删除除申报填报申请信息表")
    @ApiOperation(value = "批量删除申报填报申请信息表")
     public Boolean delBatchProjectFillIn(@RequestParam(value="sids") List<String> sids ){

        return  projectFillInService.delBatchProjectFillIn(sids);
     }


    /**
     * 根据id 获取申报填报申请信息表详情
     */
    @PostMapping("getById")
   @Log(modelName = "申报填报申请信息表详情", action = Log.SELECT,description="根据id查询申报填报申请信息表")
    @ApiOperation(value = "申报填报申请信息表详情", response = ProjectFillIn.class)
    public ProjectFillIn getByIdProjectFillIn( String id)   {
        return      projectFillInService.getProjectFillInById(id);
    }

    /**
     * 申报填报申请信息表分页列表
     */
    @PostMapping("/getPageList")
       @Log(modelName = "申报填报申请信息表分页列表", action = Log.SELECT,description="分页查询查询申报填报申请信息表")
    @ApiOperation(value = "申报填报申请信息表分页列表", response = ProjectFillIn.class)
    public Paging<ProjectFillIn> getProjectFillInPageList( ProjectFillInPageParam projectFillInPageParam)   {
        return projectFillInService.getProjectFillInPageList(projectFillInPageParam);
    }

}

