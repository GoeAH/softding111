package com.softding.business.banner.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softding.business.banner.mapper.BannerMapper;
import org.springframework.stereotype.Service;
import com.softding.business.banner.domain.Banner;
import com.softding.business.banner.service.IBannerService;
import com.softding.common.core.text.Convert;


/**
 * 网站bannerService业务层处理
 * 
 * @author softding
 * @date 2020-01-19
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper,Banner> implements IBannerService
{
    /**
     * 查询网站banner
     * 
     * @param id 网站bannerID
     * @return 网站banner
     */
    @Override
    public Banner selectBannerById(Long id)
    {
        return baseMapper.selectBannerById(id);
    }

    /**
     * 查询网站banner列表
     * 
     * @param banner 网站banner
     * @return 网站banner
     */
    @Override
    public List<Banner> selectBannerList(Banner banner)
    {
        return baseMapper.selectBannerList(banner);
    }

    /**
     * 新增网站banner
     * 
     * @param banner 网站banner
     * @return 结果
     */
    @Override
    public int insertBanner(Banner banner)
    {
        return baseMapper.insertBanner(banner);
    }

    /**
     * 修改网站banner
     * 
     * @param banner 网站banner
     * @return 结果
     */
    @Override
    public int updateBanner(Banner banner)
    {
        return baseMapper.updateBanner(banner);
    }

    /**
     * 删除网站banner对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBannerByIds(String ids)
    {
        return baseMapper.deleteBannerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网站banner信息
     * 
     * @param id 网站bannerID
     * @return 结果
     */
    @Override
    public int deleteBannerById(Long id)
    {
        return baseMapper.deleteBannerById(id);
    }
}
