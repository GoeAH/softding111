package com.softding.business.tmsRate.service.impl;

import java.util.List;
import com.softding.common.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.softding.business.tmsRate.domain.TmsRate;
import com.softding.business.tmsRate.mapper.TmsRateMapper;
import com.softding.business.tmsRate.service.ITmsRateService;
import com.softding.common.core.text.Convert;


/**
 * 费率配置Service业务层处理
 * 
 * @author softding
 * @date 2020-05-22
 */
@Service
public class TmsRateServiceImpl extends ServiceImpl<TmsRateMapper,TmsRate> implements ITmsRateService
{
    /**
     * 查询费率配置
     * 
     * @param id 费率配置ID
     * @return 费率配置
     */
    @Override
    public TmsRate selectTmsRateById(Long id)
    {
        return baseMapper.selectTmsRateById(id);
    }

    /**
     * 查询费率配置列表
     * 
     * @param tmsRate 费率配置
     * @return 费率配置
     */
    @Override
    public List<TmsRate> selectTmsRateList(TmsRate tmsRate)
    {
        return baseMapper.selectTmsRateList(tmsRate);
    }

    /**
     * 新增费率配置
     * 
     * @param tmsRate 费率配置
     * @return 结果
     */
    @Override
    public int insertTmsRate(TmsRate tmsRate)
    {
        tmsRate.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insertTmsRate(tmsRate);
    }

    /**
     * 修改费率配置
     * 
     * @param tmsRate 费率配置
     * @return 结果
     */
    @Override
    public int updateTmsRate(TmsRate tmsRate)
    {
        tmsRate.setUpdateTime(DateUtils.getNowDate());
        return baseMapper.updateTmsRate(tmsRate);
    }

    /**
     * 删除费率配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTmsRateByIds(String ids)
    {
        return baseMapper.deleteTmsRateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除费率配置信息
     * 
     * @param id 费率配置ID
     * @return 结果
     */
    @Override
    public int deleteTmsRateById(Long id)
    {
        return baseMapper.deleteTmsRateById(id);
    }
}
