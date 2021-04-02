package com.zz.project.provide.projectdeclare.service.impl;

import com.zz.project.provide.projectdeclare.entity.ProjectDeclare;
import com.zz.project.provide.projectdeclare.mapper.ProjectDeclareMapper;
import com.zz.project.provide.projectdeclare.service.IProjectDeclareService;
import com.zz.project.provide.projectdeclare.param.ProjectDeclarePageParam;
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
 * 申报发布表 服务实现类
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
        ProjectDeclare obj = projectDeclareMapper.getProjectDeclareById(sid);
                ProjectDeclare info = iterator.next();
                    disposeObj(obj);
         return obj ;
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
            obj.setDeclareTypeDicCodesString(xtzdService.getXtzdValueByCodes(obj.getDeclareTypeDicCodes()));

            obj.setDeclareLevelDicCodesString(xtzdService.getXtzdValueByCodes(obj.getDeclareLevelDicCodes()));

            obj.setProjectTypelDicCodesString(xtzdService.getXtzdValueByCodes(obj.getProjectTypelDicCodes()));

 }

}
