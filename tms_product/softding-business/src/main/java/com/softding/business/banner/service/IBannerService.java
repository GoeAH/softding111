package com.softding.business.banner.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softding.business.banner.domain.Banner;
import java.util.List;

/**
 * 网站bannerService接口
 * 
 * @author softding
 * @date 2020-01-19
 */
public interface IBannerService extends IService<Banner>
{
    /**
     * 查询网站banner
     * 
     * @param id 网站bannerID
     * @return 网站banner
     */
    public Banner selectBannerById(Long id);

    /**
     * 查询网站banner列表
     * 
     * @param banner 网站banner
     * @return 网站banner集合
     */
    public List<Banner> selectBannerList(Banner banner);

    /**
     * 新增网站banner
     * 
     * @param banner 网站banner
     * @return 结果
     */
    public int insertBanner(Banner banner);

    /**
     * 修改网站banner
     * 
     * @param banner 网站banner
     * @return 结果
     */
    public int updateBanner(Banner banner);

    /**
     * 批量删除网站banner
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBannerByIds(String ids);

    /**
     * 删除网站banner信息
     * 
     * @param id 网站bannerID
     * @return 结果
     */
    public int deleteBannerById(Long id);
}
