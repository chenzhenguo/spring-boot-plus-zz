package com.zz.project.provide.projectmanager.service;

import com.zz.project.provide.projectmanager.entity.ProjectDeclare;
import com.zz.project.provide.projectmanager.param.ProjectDeclarePageParam;


/**
 * 申报发布表 服务类
 *
 * @author czg
 * @since 2021-04-02
 */
public interface IProjectDeclareService extends IBaseService<ProjectDeclare> {

    /**
     * 保存
     *
     * @param projectDeclare
     * @return
     */
    boolean saveProjectDeclare(ProjectDeclare projectDeclare)  ;

    /**
     * 修改
     *
     * @param projectDeclare
     * @return
     */
    boolean updateProjectDeclare(ProjectDeclare projectDeclare)  ;

    /**
     * 删除
     *
     * @param sid
     * @return
     */
        boolean  deleteProjectDeclare(String sid);

    /**
     * 批量删除
     *
     * @param sids
     * @return
     */
    boolean delBatchProjectDeclare(List<String>  sids);


    /**
     * 根据ID获取查询对象
     *
     * @param sid
     * @return
     */
    ProjectDeclare getProjectDeclareById(String  sid)  ;
    /**
     * 获取分页对象
     *
     * @param  projectDeclarePageParam
     * @return
     */
      Paging<ProjectDeclare> getProjectDeclarePageList(ProjectDeclarePageParam projectDeclarePageParam)  ;

}
