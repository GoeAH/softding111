/**
 * 通用Easyui js方法封装处理
 * Copyright (c) 2020 zc
 */
(function ($) {
    $.extend({

        // 表格封装处理
        table: {
            _option: {},
            // 初始化表格参数
            init: function (options) {
                var defaults = {
                    id: "List",
                    fit: true,
                    headers:{
                        ajaxType:"easyuiDataGrid"
                    },
                    method: "post",
                    pagination: true,
                    pageNumber: 1,
                    pageSize: 15,
                    pageList: [15, 30, 45, 60, 100],
                    sortName: "",
                    sortOrder: "asc",
                    remoteSort: true,
                    rownumbers: true,
                    ctrlSelect: true,
                    checkOnSelect: true,
                    selectOnCheck: true,
                    toolbar: "#toolbar",
                    fitColumns: true,
                    striped: true,
                    showFooter: false,
                    queryParams: $.table.queryParams,
                    frozenColumns: [],
                    onLoadSuccess: function (res) {
                        if (res.code != 0) {
                            $.modal.alertWarning(res.msg);
                        }
                    }
                };

                var options = $.extend(defaults, options);
                if(options.frozenColumns.length>0){
                    options.frozenColumns=[options.frozenColumns]
                }
                if(options.columns.length>0){
                    console.log(JSON.stringify(options.columns))
                    options.columns=[options.columns];
                    console.log(JSON.stringify(options.columns))
                }
                $.table._option = options;
                $.table.initEvent();
                $('#' + options.id).datagrid(options);
            },
            // 初始化事件
            initEvent: function (data) {

            },
            // 刷新表格
            refresh: function (id) {
                var currentId = $.common.isEmpty(id) ? $.table._option.id : id;
                $("#" + currentId).datagrid('reload');
            },
        },
        // 表单封装处理
        form: {
            // 表单重置
            reset: function (formId) {
                var currentId = $.common.isEmpty(formId) ? "formId" : formId;
                $("#" + currentId).form('reset');
            },
            // 获取选中复选框项
            selectCheckeds: function (name) {
                var checkeds = "";
                $('input:checkbox[name="' + name + '"]:checked').each(function (i) {
                    if (0 == i) {
                        checkeds = $(this).val();
                    } else {
                        checkeds += ("," + $(this).val());
                    }
                });
                return checkeds;
            },
            // 获取选中下拉框项
            selectSelects: function (name) {
                var selects = "";
                $('#' + name + ' option:selected').each(function (i) {
                    if (0 == i) {
                        selects = $(this).val();
                    } else {
                        selects += ("," + $(this).val());
                    }
                });
                return selects;
            }
        },
        // 弹出层封装处理
        modal: {
            // 显示图标
            icon: function (type) {
                var icon = "";
                if (type == modal_status.WARNING) {
                    icon = 0;
                } else if (type == modal_status.SUCCESS) {
                    icon = 1;
                } else if (type == modal_status.FAIL) {
                    icon = 2;
                } else {
                    icon = 3;
                }
                return icon;
            },
            // 消息提示
            msg: function (content, type) {
                if (type != undefined) {
                    layer.msg(content, {icon: $.modal.icon(type), time: 1000, shift: 5});
                } else {
                    layer.msg(content);
                }
            },
            // 错误消息
            msgError: function (content) {
                $.modal.msg(content, modal_status.FAIL);
            },
            // 成功消息
            msgSuccess: function (content) {
                $.modal.msg(content, modal_status.SUCCESS);
            },
            // 警告消息
            msgWarning: function (content) {
                $.modal.msg(content, modal_status.WARNING);
            },
            // 弹出提示
            alert: function (content, callBack) {
                if ($.common.isEmpty(callBack)) {
                    $.messager.alert("操作提示", content, modal_status.INFO);
                } else {
                    $.messager.alert("操作提示", content, modal_status.INFO, function () {
                        callBack();
                    });
                }
            },
            // 错误提示
            alertError: function (content, callBack1) {
                if ($.common.isEmpty(callBack1)) {
                    layer.alert(content, {
                        icon: $.modal.icon(modal_status.FAIL),
                        title: "系统提示",
                        btn: ['确认'],
                        btnclass: ['btn btn-primary'],
                    });
                    /* $.messager.alert("操作提示", content, modal_status.FAIL);*/
                } else {
                    layer.alert(content, {
                        icon: $.modal.icon(modal_status.FAIL),
                        title: "系统提示",
                        btn: ['确认'],
                        btnclass: ['btn btn-primary'],
                    }, function (index) {
                        layer.close(index);
                        callBack1();
                    });
                    /* $.messager.alert("操作提示", content, modal_status.FAIL, function () {
                         callBack();
                     });*/
                }
            },
            // 警告提示
            alertWarning: function (content, callBack) {
                if ($.common.isEmpty(callBack)) {
                    $.messager.alert("操作提示", content, modal_status.WARNING);
                } else {
                    $.messager.alert("操作提示", content, modal_status.WARNING, function () {
                        callBack();
                    });
                }
            },
            confirm: function (content, callBack) {
                $.messager.confirm('询问', content, function (data) {
                    if (data) {
                        callBack(true);
                    } else {
                        callBack(false);
                    }
                });
            },
            dialog: function (title, url, width, height, closeTip, id, callback) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = "窗口";
                }
                if ($.common.isEmpty(url)) {
                    $.modal.msgError("Url路径不存在");
                    return;
                }
                if ($.common.isEmpty(width)) {
                    width = 800;
                }
                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50);
                }
                if ($.common.isEmpty(closeTip)) {
                    closeTip = true;
                }
                if ($.common.isEmpty(id)) {
                    id = "dig_NE";
                }
                if ($.common.isEmpty(callback)) {
                    callback = function () {
                        submitHandler();
                    }
                }
                $('<div></div>').dialog({
                    id: id,
                    width: width,
                    maximized: false,
                    height: height,
                    modal: true,
                    draggable: true,
                    resizable: true,
                    openAnimation: 'slide',
                    href: url,
                    title: title,
                    onClose: function () {
                        $("#" + id).dialog('destroy');
                    },
                    onBeforeClose: function () {
                        if (closeTip) {
                            $.messager.confirm("操作提示", "信息未保存是否关闭？", function (data) {
                                if (data)
                                    $("#" + id).dialog('destroy');
                                else
                                    return false;
                            })
                            return false;
                        }
                    },
                    buttons: [{
                        text: '保存',
                        handler: callback
                    }, {
                        text: '关闭',
                        handler: function () {
                            $("#" + id).dialog('close');
                        }
                    }]
                });
            },
            dialogFull: function (title, url, closeTip, id, callback) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = "窗口";
                }
                if ($.common.isEmpty(url)) {
                    $.modal.msgError("Url路径不存在");
                    return;
                }

                if ($.common.isEmpty(closeTip)) {
                    closeTip = true;
                }
                if ($.common.isEmpty(id)) {
                    id = "dig_NE";
                }
                if ($.common.isEmpty(callback)) {
                    callback = function () {
                        submitHandler();
                    }
                }
                $('<div></div>').dialog({
                    id: id,
                    maximized: true,
                    modal: true,
                    draggable: true,
                    resizable: true,
                    openAnimation: 'slide',
                    href: url,
                    title: title,
                    onClose: function () {
                        $("#" + id).dialog('destroy');
                    },
                    onBeforeClose: function () {
                        if (closeTip) {
                            $.messager.confirm("操作提示", "信息未保存是否关闭？", function (data) {
                                if (data)
                                    $("#" + id).dialog('destroy');
                                else
                                    return false;
                            })
                            return false;
                        }
                    },
                    buttons: [{
                        text: '保存',
                        handler: callback
                    }, {
                        text: '关闭',
                        handler: function () {
                            $("#" + id).dialog('close');
                        }
                    }]
                });
            },
            dialogNoBtn: function (title, url, width, height, id) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = "窗口";
                }
                if ($.common.isEmpty(url)) {
                    $.modal.msgError("Url路径不存在");
                    return;
                }
                if ($.common.isEmpty(id)) {
                    id = "dig_NE";
                }

                $('<div></div>').dialog({
                    id: id,
                    width: width,
                    maximized: false,
                    height: height,
                    modal: true,
                    draggable: true,
                    resizable: true,
                    openAnimation: 'slide',
                    href: url,
                    title: title,
                    onClose: function () {
                        $("#" + id).dialog('destroy');
                    }
                });
            },
            dialogFullNoBtn: function (title, url, id) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = "窗口";
                }
                if ($.common.isEmpty(url)) {
                    $.modal.msgError("Url路径不存在");
                    return;
                }
                if ($.common.isEmpty(id)) {
                    id = "dig_NE";
                }

                $('<div></div>').dialog({
                    id: id,
                    maximized: true,
                    modal: true,
                    draggable: true,
                    resizable: true,
                    openAnimation: 'slide',
                    href: url,
                    title: title,
                    onClose: function () {
                        $("#" + id).dialog('destroy');
                    }
                });
            },
            // 选卡页方式打开
            openTab: function (title, url) {
                createMenuItem(url, title);
            },
            // 选卡页同一页签打开
            parentTab: function (title, url) {
                var dataId = window.frameElement.getAttribute('data-id');
                createMenuItem(url, title);
                closeItem(dataId);
            },
            // 关闭选项卡
            closeTab: function (dataId) {
                closeItem(dataId);
            },
            // 打开遮罩层
            loading: function (message) {
                $.blockUI({
                    message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + '</div>',
                    baseZ: 999999
                });
            },
            // 关闭遮罩层
            closeLoading: function () {
                setTimeout(function () {
                    $.unblockUI();
                }, 50);
            },
            // 重新加载
            reload: function () {
                parent.location.reload();
            },
            //关闭弹出框
            dialogClose: function (id) {
                var currentId = $.common.isEmpty(id) ? "dig_NE" : id;
                $("#" + currentId).dialog("destroy");
            },
            // 关闭窗体
            close: function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            },
            // 禁用按钮
            disable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).addClass("layer-disabled");
            },
            // 启用按钮
            enable: function () {
                var doc = window.top == window.parent ? window.document : window.parent.document;
                $("a[class*=layui-layer-btn]", doc).removeClass("layer-disabled");
            }
        },
        // 操作封装处理
        operate: {
            submit: function (options) {
                var defaults = {
                    url: "",
                    param: []
                };
                var options = $.extend(defaults, options);
                $.modal.loading("正在处理中，请稍后...");	// 显示进度条
                $.ajax({
                    url: options.url,
                    data: options.param,
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        $.modal.closeLoading();
                        if (result.code == web_status.SUCCESS) {
                            options.success(result);
                        } else if (result.code == web_status.WARNING) {
                            $.modal.alertWarning(result.msg)
                        } else {
                            $.modal.alertError(result.msg);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $.modal.closeLoading();
                        $.modal.alertError(errorThrown);
                    },
                    complete: function () {
                        //$.messager.progress('close');
                    }
                });
            },
            submitForm: function (options) {

                var defaults = {
                    url: "",
                    param: []
                };
                var options = $.extend(defaults, options);
                try {
                    $.modal.loading("正在处理中，请稍后...");
                    $("#" + options.id).form('submit', {
                        url: options.url,
                        queryParams: options.param,
                        onSubmit: function () {
                            var isValid = $(this).form('validate');
                            if (!isValid) {
                                $.modal.closeLoading();
                            }
                            return isValid;	// 返回false终止表单提交
                        },
                        dataType: "json",
                        success: function (result) {
                            $.modal.closeLoading();
                            result = JSON.parse(result);
                            if (result.code == web_status.SUCCESS) {
                                options.success(result);
                            } else if (result.code == web_status.WARNING) {
                                $.modal.alertWarning(result.msg)
                            } else {
                                $.modal.alertError(result.msg);
                            }
                        },
                        onLoadError: function () {
                            $.modal.closeLoading();
                        }
                    });
                } catch (e) {
                    $.modal.closeLoading();
                    $.modal.alertError(e);
                }
            },
            // 删除信息
            remove: function (options) {
                var defaults = {
                    content: "注：您确定要删除该项数据吗？",
                    url: "",
                    param: []
                };
                var options = $.extend(defaults, options);

                $.messager.confirm('提示', options.content, function (r) {
                    if (r) {
                        $.modal.loading("正在处理中，请稍后...");
                        $.ajax({
                            url: options.url,
                            data: options.param,
                            dataType: "json",
                            type: "post",
                            success: function (result) {
                                $.modal.closeLoading();
                                if (result.code == web_status.SUCCESS) {
                                    options.success(result);
                                } else if (result.code == web_status.WARNING) {
                                    $.modal.alertWarning(result.msg)
                                } else {
                                    $.modal.alertError(result.msg);
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                $.modal.closeLoading();
                                $.modal.alertError(errorThrown);
                            },
                            complete: function () {
                                // $.modal.closeLoading();
                            }
                        });
                    }
                });

            },
            // 保存选项卡信息
            saveTab: function (url, data, callback) {
                var config = {
                    url: url,
                    type: "post",
                    dataType: "json",
                    data: data,
                    beforeSend: function () {
                        $.modal.loading("正在处理中，请稍后...");
                    },
                    success: function (result) {
                        if (typeof callback == "function") {
                            callback(result);
                        }
                        $.operate.successTabCallback(result);
                    }
                };
                $.ajax(config)
            },
            // 选项卡成功回调执行事件（父窗体静默更新）
            successTabCallback: function (result) {
                if (result.code == web_status.SUCCESS) {
                    var topWindow = $(window.parent.document);
                    var currentId = $('.page-tabs-content', topWindow).find('.active').attr('data-panel');
                    var $contentWindow = $('.RuoYi_iframe[data-id="' + currentId + '"]', topWindow)[0].contentWindow;
                    $.modal.close();
                    $contentWindow.$.modal.msgSuccess(result.msg);
                    $contentWindow.$(".layui-layer-padding").removeAttr("style");
                    if ($contentWindow.$.table._option.type == table_type.datagrid) {
                        $contentWindow.$.table.refresh();
                    }
                    $.modal.closeTab();
                } else if (result.code == web_status.WARNING) {
                    $.modal.alertWarning(result.msg)
                } else {
                    $.modal.alertError(result.msg);
                }
                $.modal.closeLoading();
            }
        },
        // 通用方法封装处理
        common: {
            // 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },
            // 判断一个字符串是否为非空串
            isNotEmpty: function (value) {
                return !$.common.isEmpty(value);
            },
            // 空对象转字符串
            nullToStr: function (value) {
                if ($.common.isEmpty(value)) {
                    return "-";
                }
                return value;
            },
            // 是否显示数据 为空默认为显示
            visible: function (value) {
                if ($.common.isEmpty(value) || value == true) {
                    return true;
                }
                return false;
            },
            // 空格截取
            trim: function (value) {
                if (value == null) {
                    return "";
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            },
            // 比较两个字符串（大小写敏感）
            equals: function (str, that) {
                return str == that;
            },
            // 比较两个字符串（大小写不敏感）
            equalsIgnoreCase: function (str, that) {
                return String(str).toUpperCase() === String(that).toUpperCase();
            },
            // 将字符串按指定字符分割
            split: function (str, sep, maxLen) {
                if ($.common.isEmpty(str)) {
                    return null;
                }
                var value = String(str).split(sep);
                return maxLen ? value.slice(0, maxLen - 1) : value;
            },
            // 字符串格式化(%s )
            sprintf: function (str) {
                var args = arguments, flag = true, i = 1;
                str = str.replace(/%s/g, function () {
                    var arg = args[i++];
                    if (typeof arg === 'undefined') {
                        flag = false;
                        return '';
                    }
                    return arg;
                });
                return flag ? str : '';
            },
            // 指定随机数返回
            random: function (min, max) {
                return Math.floor((Math.random() * max) + min);
            },
            // 判断字符串是否是以start开头
            startWith: function (value, start) {
                var reg = new RegExp("^" + start);
                return reg.test(value)
            },
            // 判断字符串是否是以end结尾
            endWith: function (value, end) {
                var reg = new RegExp(end + "$");
                return reg.test(value)
            },
            // 数组去重
            uniqueFn: function (array) {
                var result = [];
                var hashObj = {};
                for (var i = 0; i < array.length; i++) {
                    if (!hashObj[array[i]]) {
                        hashObj[array[i]] = true;
                        result.push(array[i]);
                    }
                }
                return result;
            },
            // 数组中的所有元素放入一个字符串
            join: function (array, separator) {
                if ($.common.isEmpty(array)) {
                    return null;
                }
                return array.join(separator);
            },
            // 获取form下所有的字段并转换为json对象
            formToJSON: function (formId) {
                var json = {};
                $.each($("#" + formId).serializeArray(), function (i, field) {
                    json[field.name] = field.value;
                });
                return json;
            }
        }
    })
})(jQuery);

/** 消息状态码 */
web_status = {
    SUCCESS: 0,
    FAIL: 500,
    WARNING: 301
};

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning",
    INFO: "info"
};