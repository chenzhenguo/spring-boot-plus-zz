package com.zz.project.provide.projectmanager.service.impl;

import com.zz.project.provide.projectmanager.entity.ProjectDeclare;
import com.zz.project.provide.projectmanager.mapper.ProjectDeclareMapper;
import com.zz.project.provide.projectmanager.service.IProjectDeclareService;
import com.zz.project.provide.projectmanager.param.ProjectDeclarePageParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.zz.project.provide.system.service.IBasicsXtzdService;
import java.util.Iterator;
/**
 * 申报管理表 服务实现类
 *
 * @author czg
 * @since 2021-04-02
 */
@Service
public class ProjectDeclareServiceImpl extends BaseService<ProjectDeclareMapper, ProjectDeclare> implements IProjectDeclareService {

    @Autowired
    private ProjectDeclareMapper projectDeclareMapper;
    @Resource
    private IBasicsXtzdService xtzdService;




    @Override
    public boolean saveProjectDeclare(ProjectDeclare projectDeclare)   {
        return this.save(projectDeclare);
    }

    @Override
    public boolean updateProjectDeclare(ProjectDeclare projectDeclare)   {
        return this.updateById(projectDeclare);
    }

    @Override
    public boolean deleteProjectDeclare(String sid)   {
             ProjectDeclare  obj =this.getById(sid);
             if(null != obj){
                 obj.setScbj(1);
            }
        return this.saveOrUpdate(obj);
    }

    @Override
    public boolean delBatchProjectDeclare(List<String> sids)   {
        List<ProjectDeclare> list = new ArrayList<>(16);
        for(String sid:sids){
         ProjectDeclare obj = this.getById(sid);
            if(obj !=null){
                obj.setScbj(1);
                list.add(obj);
            }
        }
        return this.saveOrUpdateBatch(list);

    }

    @Override
    public ProjectDeclare getProjectDeclareById(String sid)   {
         return projectDeclareMapper.getProjectDeclareById(sid);
    }

@Override
public Paging<ProjectDeclare> getProjectDeclarePageList(ProjectDeclarePageParam projectDeclarePageParam)   {
        Page<ProjectDeclare> page = new PageInfo<>(projectDeclarePageParam, OrderItem.desc(getLambdaColumn(ProjectDeclare::getGxsj)));
            IPage<ProjectDeclare> iPage = projectDeclareMapper.getProjectDeclarePageList(page, projectDeclarePageParam);


                Iterator<ProjectDeclare> iterator = iPage.getRecords().iterator();
                while (iterator.hasNext()){
                 ProjectDeclare info = iterator.next();
                disposeObj(info);
             }


        return new Paging<ProjectDeclare>(iPage);
        }
private void disposeObj(ProjectDeclare obj) {
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_type_dic_codes, type=numeric(10,0), propertyName=declareTypeDicCodes, columnType=BIG_DECIMAL, comment=申报类型, fill=null, customMap=null)
            obj.setDeclareTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getDeclareTypeDicCodes()));

        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_level, type=numeric(10,0), propertyName=declareLevel, columnType=BIG_DECIMAL, comment=申报级别, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=project_typel, type=character varying(255), propertyName=projectTypel, columnType=STRING, comment=项目类型, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_online, type=numeric(1,0), propertyName=declareOnline, columnType=BIG_DECIMAL, comment=是否在线申报, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_title, type=character varying(255), propertyName=declareTitle, columnType=STRING, comment=申报标题, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_content, type=text, propertyName=declareContent, columnType=STRING, comment=申报内容_like, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_content_attachment, type=character varying(255), propertyName=declareContentAttachment, columnType=STRING, comment=多个附件id, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_stime, type=timestamp(6) without time zone, propertyName=declareStime, columnType=DATE, comment=申报开始时间, fill=null, customMap=null)
        TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=declare_etime, type=timestamp(6) without time zone, propertyName=declareEtime, columnType=DATE, comment=申报结束时间, fill=null, customMap=null)

 }

}
