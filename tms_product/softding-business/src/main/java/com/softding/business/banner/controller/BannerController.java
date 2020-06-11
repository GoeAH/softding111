package com.softding.business.banner.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softding.common.annotation.Log;
import com.softding.common.enums.BusinessType;
import com.softding.business.banner.domain.Banner;
import com.softding.business.banner.service.IBannerService;
import com.softding.common.core.controller.BaseController;
import com.softding.common.core.domain.AjaxResult;
import com.softding.common.utils.poi.ExcelUtil;
import com.softding.common.core.page.TableDataInfo;

/**
 * 网站bannerController
 * 
 * @author softding
 * @date 2020-01-19
 */
@Controller
@RequestMapping("/business/banner")
public class BannerController extends BaseController
{
    private String prefix = "business/banner";

    @Autowired
    private IBannerService bannerService;

    @RequiresPermissions("business:banner:view")
    @GetMapping()
    public String banner()
    {
        return prefix + "/banner";
    }

    /**
     * 查询网站banner列表
     */
    @RequiresPermissions("business:banner:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Banner banner)
    {
        startPage();
        List<Banner> list = bannerService.selectBannerList(banner);
        return getDataTable(list);
    }

    /**
     * 导出网站banner列表
     */
    @RequiresPermissions("business:banner:export")
    @Log(title = "网站banner", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Banner banner)
    {
        List<Banner> list = bannerService.selectBannerList(banner);
        ExcelUtil<Banner> util = new ExcelUtil<Banner>(Banner.class);
        return util.exportExcel(list, "banner");
    }

    /**
     * 新增网站banner
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网站banner
     */
    @RequiresPermissions("business:banner:add")
    @Log(title = "网站banner", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Banner banner)
    {
        return toAjax(bannerService.insertBanner(banner));
    }

    /**
     * 修改网站banner
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Banner banner = bannerService.selectBannerById(id);
        mmap.put("banner", banner);
        return prefix + "/edit";
    }

    /**
     * 修改保存网站banner
     */
    @RequiresPermissions("business:banner:edit")
    @Log(title = "网站banner", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Banner banner)
    {
        return toAjax(bannerService.updateBanner(banner));
    }

    /**
     * 删除网站banner
     */
    @RequiresPermissions("business:banner:remove")
    @Log(title = "网站banner", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bannerService.deleteBannerByIds(ids));
    }
}
