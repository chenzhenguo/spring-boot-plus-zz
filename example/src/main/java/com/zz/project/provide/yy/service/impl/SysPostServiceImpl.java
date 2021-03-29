package com.zz.project.provide.yy.service.impl;

import com.zz.project.provide.yy.entity.SysPost;
import com.zz.project.provide.yy.mapper.SysPostMapper;
import com.zz.project.provide.yy.service.ISysPostService;
import com.zz.project.provide.yy.param.SysPostPageParam;
import com.zz.project.provide.yy.vo.SysPostQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 岗位信息表; InnoDB free: 18432 kB 服务实现类
 *
 * @author czg
 * @since 2021-03-29
 */
@Service
public class SysPostServiceImpl extends BaseService<SysPostMapper, SysPost> implements ISysPostService {

    @Autowired
    private SysPostMapper sysPostMapper;

    @Override
    public boolean saveSysPost(SysPost sysPost)   {
        return this.save(sysPost);
    }

    @Override
    public boolean updateSysPost(SysPost sysPost)   {
        return this.updateById(sysPost);
    }

    @Override
    public boolean deleteSysPost(String sid)   {
             SysPostQueryVo  obj =this.getById(sid);
             if(null != obj){
                 obj.setScbj(1);
            }
        return this.saveOrUpdate(zy);
    }

    @Override
    public boolean delBatchSysPost(List<String> sids)   {
        List<SysPostQueryVo> list = new ArrayList<>(16);
        for(String sid:sids){
         SysPostQueryVo obj = this.getById(sid);
            if(obj !=null){
                obj.setScbj(1);
                list.add(obj);
            }
        }
        return this.saveOrUpdateBatch(list);

    }

    @Override
    public SysPostQueryVo getSysPostById(String sid)   {
         return sysPostMapper.getSysPostById(id);
    }

@Override
public Paging<SysPostQueryVo> getSysPostPageList(SysPostPageParam sysPostPageParam)   {
        Page<SysPostQueryVo> page = new PageInfo<>(sysPostPageParam, OrderItem.desc(getLambdaColumn(SysPost::getGxsj)));
            IPage<SysPostQueryVo> iPage = sysPostMapper.getSysPostPageList(page, sysPostPageParam);
        return new Paging<SysPostQueryVo>(iPage);
        }
}
