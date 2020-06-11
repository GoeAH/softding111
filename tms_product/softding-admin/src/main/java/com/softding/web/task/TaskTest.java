package com.softding.web.task;

import com.softding.common.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangCun
 * @Date: 2020-02-01 10:55
 * @describe：
 */
@Component("testTask")
public class TaskTest {
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("1执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params) {
        System.out.println("2执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("3执行无参方法");
    }
}
