package com.softding.api.tool;

import com.softding.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * swagger 接口
 * 
 * @author softding
 */
@Controller
@RequestMapping("/api")
public class SwaggerController extends BaseController
{
    @GetMapping()
    public String index()
    {
        return redirect("/swagger-ui.html");
    }
}
