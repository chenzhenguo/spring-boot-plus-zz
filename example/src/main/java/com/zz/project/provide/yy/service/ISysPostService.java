package com.zz.project.provide.yy.service;

import com.zz.project.provide.yy.entity.SysPost;
import com.zz.project.provide.yy.param.SysPostPageParam;
import com.zz.project.provide.yy.vo.SysPostQueryVo;


/**
 * 岗位信息表; InnoDB free: 18432 kB 服务类
 *
 * @author czg
 * @since 2021-03-29
 */
public interface ISysPostService extends IBaseService<SysPost> {

    /**
     * 保存
     *
     * @param sysPost
     * @return
     */
    boolean saveSysPost(SysPost sysPost)  ;

    /**
     * 修改
     *
     * @param sysPost
     * @return
     */
    boolean updateSysPost(SysPost sysPost)  ;

    /**
     * 删除
     *
     * @param sid
     * @return
     */
        boolean  deleteSysPost(String sid);

    /**
     * 批量删除
     *
     * @param sids
     * @return
     */
    boolean delBatchSysPost(List<String>  sids);


    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    SysPostQueryVo getSysPostById(String  sid)  ;
    /**
     * 获取分页对象
     *
     * @param  sysPostPageParam
     * @return
     */
      Paging<SysPostQueryVo> getSysPostPageList(SysPostPageParam sysPostPageParam)  ;

}
