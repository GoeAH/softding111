package com.softding.common.core.page;

import com.softding.common.constant.Constants;
import com.softding.common.utils.ServletUtils;

/**
 * 表格数据处理
 *
 * @author softding
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();

        if ("easyuiDataGrid".equals(ServletUtils.getRequest().getHeader("ajaxType"))) {
            pageDomain.setPageNum(ServletUtils.getParameterToInt("page"));
            pageDomain.setPageSize(ServletUtils.getParameterToInt("rows"));
            pageDomain.setOrderByColumn(ServletUtils.getParameter("sort"));
            pageDomain.setIsAsc(ServletUtils.getParameter("order"));
            return pageDomain;
        } else {
            pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
            pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
            pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
            pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        }
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }
}
