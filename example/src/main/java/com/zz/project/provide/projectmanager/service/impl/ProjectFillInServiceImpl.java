package com.zz.project.provide.projectmanager.service.impl;

import com.zz.project.provide.projectmanager.entity.ProjectFillIn;
import com.zz.project.provide.projectmanager.mapper.ProjectFillInMapper;
import com.zz.project.provide.projectmanager.service.IProjectFillInService;
import com.zz.project.provide.projectmanager.param.ProjectFillInPageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 申报填报信息表 服务实现类
 *
 * @author czg
 * @since 2021-04-02
 */
@Service
public class ProjectFillInServiceImpl extends BaseService<ProjectFillInMapper, ProjectFillIn> implements IProjectFillInService {

    @Autowired
    private ProjectFillInMapper projectFillInMapper;




    @Override
    public boolean saveProjectFillIn(ProjectFillIn projectFillIn)   {
        return this.save(projectFillIn);
    }

    @Override
    public boolean updateProjectFillIn(ProjectFillIn projectFillIn)   {
        return this.updateById(projectFillIn);
    }

    @Override
    public boolean deleteProjectFillIn(String sid)   {
             ProjectFillIn  obj =this.getById(sid);
             if(null != obj){
                 obj.setScbj(1);
            }
        return this.saveOrUpdate(obj);
    }

    @Override
    public boolean delBatchProjectFillIn(List<String> sids)   {
        List<ProjectFillIn> list = new ArrayList<>(16);
        for(String sid:sids){
         ProjectFillIn obj = this.getById(sid);
            if(obj !=null){
                obj.setScbj(1);
                list.add(obj);
            }
        }
        return this.saveOrUpdateBatch(list);

    }

    @Override
    public ProjectFillIn getProjectFillInById(String sid)   {
         return projectFillInMapper.getProjectFillInById(sid);
    }

@Override
public Paging<ProjectFillIn> getProjectFillInPageList(ProjectFillInPageParam projectFillInPageParam)   {
        Page<ProjectFillIn> page = new PageInfo<>(projectFillInPageParam, OrderItem.desc(getLambdaColumn(ProjectFillIn::getGxsj)));
            IPage<ProjectFillIn> iPage = projectFillInMapper.getProjectFillInPageList(page, projectFillInPageParam);




        return new Paging<ProjectFillIn>(iPage);
        }
private void disposeObj(ProjectFillIn obj) {
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_name, type=numeric(10,0), propertyName=projectName, columnType=BIG_DECIMAL, comment=项目名称, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_territory, type=numeric(10,0), propertyName=projectTerritory, columnType=BIG_DECIMAL, comment=所属领域, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_type, type=numeric(10,0), propertyName=projectType, columnType=BIG_DECIMAL, comment=项目类型, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=recommend_department, type=character varying(10), propertyName=recommendDepartment, columnType=STRING, comment=推荐单位, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=apply_for_department, type=character varying(255), propertyName=applyForDepartment, columnType=STRING, comment=承担单位（申请单位）, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=social_unified_credit_code, type=character varying(10), propertyName=socialUnifiedCreditCode, columnType=STRING, comment=社会统一信用代码, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_content_attachment, type=character varying(255), propertyName=declareContentAttachment, columnType=STRING, comment=法定代表人, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_leader, type=character varying(10), propertyName=projectLeader, columnType=STRING, comment=项目负责人, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_leader_phone, type=character varying(15), propertyName=projectLeaderPhone, columnType=STRING, comment=负责人联系电话, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_id, type=numeric(20,0), propertyName=declareId, columnType=BIG_DECIMAL, comment=申报ID, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_attachment, type=character varying(255), propertyName=projectAttachment, columnType=STRING, comment=项目附件, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=release_status, type=smallint, propertyName=releaseStatus, columnType=INTEGER, comment=发布状态, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_time, type=timestamp(6) without time zone, propertyName=declareTime, columnType=DATE, comment=申报时间, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_status, type=smallint, propertyName=declareStatus, columnType=INTEGER, comment=发布状态0 待审批1初审通过待复审2返回修改3 待上会 4上会中5上会结束6初审未通过7复审未通过8审核通过, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=release_time, type=timestamp(6) without time zone, propertyName=releaseTime, columnType=DATE, comment=发布时间, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=to_meeting, type=numeric(20,0), propertyName=toMeeting, columnType=BIG_DECIMAL, comment=是否需要上会0否1是, fill=null, customMap=null)

 }

}
