package com.zz.project.provide.yy.controller;

import com.zz.project.provide.yy.entity.SysPost;
import com.zz.project.provide.yy.service.ISysPostService;
import lombok.extern.slf4j.Slf4j;
import com.zz.project.provide.yy.param.SysPostPageParam;

import com.zz.project.provide.yy.vo.SysPostQueryVo;

import com.zz.common.aop.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.common.model.PageRequest;

/**
 * 岗位信息表; InnoDB free: 18432 kB 控制器
 *
 * @author czg
 * @since 2021-03-29
 */
@Slf4j
@RestController
@RequestMapping("/sysPost")
@Api(value = "岗位信息表; InnoDB free: 18432 kBAPI", tags = {"岗位信息表; InnoDB free: 18432 kB"})
public class SysPostController {


    @Autowired
    private ISysPostService sysPostService;

    /**
     * 添加岗位信息表; InnoDB free: 18432 kB
     */
    @PostMapping("/add")
    @Log(modelName = "岗位信息表; InnoDB free: 18432 kB", action = Log.ADD,description="添加岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "添加岗位信息表; InnoDB free: 18432 kB")
    public Boolean addSysPost(SysPost sysPost)   {
        return  sysPostService.saveOrUpdate(sysPost);
    }

    /**
     * 修改岗位信息表; InnoDB free: 18432 kB
     */
    @PostMapping("/update")
   @Log(modelName = "修改岗位信息表; InnoDB free: 18432 kB", action = Log.UPDATE,description="修改岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "修改岗位信息表; InnoDB free: 18432 kB")
    public Boolean updateSysPost( SysPost sysPost)   {
        return sysPostService.updateSysPost(sysPost);
    }

    /**
     * 删除岗位信息表; InnoDB free: 18432 kB
     */
    @PostMapping("delete")
   @Log(modelName = "删除岗位信息表; InnoDB free: 18432 kB", action =Log.DELETE,description="删除岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "删除岗位信息表; InnoDB free: 18432 kB")
    public boolean  deleteSysPost(String  sid) {
        return sysPostService.deleteSysPost(sid);
    }


    /**
     * 批量删除岗位信息表; InnoDB free: 18432 kB
     */
    @PostMapping("delBatch")
    @Log(modelName = "批量删除岗位信息表; InnoDB free: 18432 kB", action =Log.DELETE,description="批量删除除岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "批量删除岗位信息表; InnoDB free: 18432 kB")
     public Boolean delBatchSysPost(@RequestParam(value="sids") List<String> sids ){

        return  sysPostService.delBatchSysPost(sids);
     }


    /**
     * 根据id 获取岗位信息表; InnoDB free: 18432 kB详情
     */
    @PostMapping("getById")
   @Log(modelName = "岗位信息表; InnoDB free: 18432 kB详情", action = Log.SELECT,description="根据id查询岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "岗位信息表; InnoDB free: 18432 kB详情", response = SysPostQueryVo.class)
    public SysPostQueryVo getByIdSysPost( String id)   {
        return      sysPostService.getSysPostById(id);
    }

    /**
     * 岗位信息表; InnoDB free: 18432 kB分页列表
     */
    @PostMapping("/getPageList")
   @Log(modelName = "岗位信息表; InnoDB free: 18432 kB分页列表", action = Log.SELECT,description="分页查询查询岗位信息表; InnoDB free: 18432 kB")
    @ApiOperation(value = "岗位信息表; InnoDB free: 18432 kB分页列表", response = SysPostQueryVo.class)
    public Paging<SysPostQueryVo> getSysPostPageList( SysPostPageParam sysPostPageParam)   {
        return sysPostService.getSysPostPageList(sysPostPageParam);
    }

}

