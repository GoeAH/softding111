package com.softding.business.tmsRate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softding.business.tmsRate.domain.TmsRate;
import java.util.List;

/**
 * 费率配置Service接口
 * 
 * @author softding
 * @date 2020-05-22
 */
public interface ITmsRateService extends IService<TmsRate>
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
     * 批量删除费率配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTmsRateByIds(String ids);

    /**
     * 删除费率配置信息
     * 
     * @param id 费率配置ID
     * @return 结果
     */
    public int deleteTmsRateById(Long id);
}
