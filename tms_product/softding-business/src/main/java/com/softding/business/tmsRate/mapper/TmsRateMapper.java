package com.softding.business.tmsRate.mapper;

import com.softding.business.tmsRate.domain.TmsRate;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 费率配置Mapper接口
 * 
 * @author softding
 * @date 2020-05-22
 */
public interface TmsRateMapper  extends BaseMapper<TmsRate>
{
    /**
     * 查询费率配置
     * 
     * @param id 费率配置ID
     * @return 费率配置
     */
    public TmsRate selectTmsRateById(Long id);

    /**
     * 查询费率配置列表
     * 
     * @param tmsRate 费率配置
     * @return 费率配置集合
     */
    public List<TmsRate> selectTmsRateList(TmsRate tmsRate);

    /**
     * 新增费率配置
     * 
     * @param tmsRate 费率配置
     * @return 结果
     */
    public int insertTmsRate(TmsRate tmsRate);

    /**
     * 修改费率配置
     * 
     * @param tmsRate 费率配置
     * @return 结果
     */
    public int updateTmsRate(TmsRate tmsRate);

    /**
     * 删除费率配置
     * 
     * @param id 费率配置ID
     * @return 结果
     */
    public int deleteTmsRateById(Long id);

    /**
     * 批量删除费率配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTmsRateByIds(String[] ids);
}
