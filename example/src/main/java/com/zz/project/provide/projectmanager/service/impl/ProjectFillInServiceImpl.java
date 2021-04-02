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
import com.zz.project.provide.system.service.IBasicsXtzdService;
import java.util.Iterator;
/**
 * 申报填报申请信息表 服务实现类
 *
 * @author czg
 * @since 2021-04-02
 */
@Service
public class ProjectFillInServiceImpl extends BaseService<ProjectFillInMapper, ProjectFillIn> implements IProjectFillInService {

    @Autowired
    private ProjectFillInMapper projectFillInMapper;
    @Resource
    private IBasicsXtzdService xtzdService;




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
        ProjectFillIn obj = projectFillInMapper.getProjectFillInById(sid);
                ProjectFillIn info = iterator.next();
                    disposeObj(obj);
         return obj ;
    }

@Override
public Paging<ProjectFillIn> getProjectFillInPageList(ProjectFillInPageParam projectFillInPageParam)   {
        Page<ProjectFillIn> page = new PageInfo<>(projectFillInPageParam, OrderItem.desc(getLambdaColumn(ProjectFillIn::getGxsj)));
            IPage<ProjectFillIn> iPage = projectFillInMapper.getProjectFillInPageList(page, projectFillInPageParam);


                Iterator<ProjectFillIn> iterator = iPage.getRecords().iterator();
                while (iterator.hasNext()){
                 ProjectFillIn info = iterator.next();
                disposeObj(info);
             }
        return new Paging<ProjectFillIn>(iPage);
}
private void disposeObj(ProjectFillIn obj) {
            obj.setProjectTerritoryTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getProjectTerritoryTypeDicCodes()));

            obj.setProjectTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getProjectTypeDicCodes()));

            obj.setDeclareTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getDeclareTypeDicCodes()));

 }

}
