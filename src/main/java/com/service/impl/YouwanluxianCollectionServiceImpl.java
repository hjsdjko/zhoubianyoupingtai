package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.YouwanluxianCollectionDao;
import com.entity.YouwanluxianCollectionEntity;
import com.service.YouwanluxianCollectionService;
import com.entity.view.YouwanluxianCollectionView;

/**
 * 游玩路线收藏 服务实现类
 */
@Service("youwanluxianCollectionService")
@Transactional
public class YouwanluxianCollectionServiceImpl extends ServiceImpl<YouwanluxianCollectionDao, YouwanluxianCollectionEntity> implements YouwanluxianCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YouwanluxianCollectionView> page =new Query<YouwanluxianCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
