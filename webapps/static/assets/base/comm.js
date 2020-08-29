(function($) {
    // copy from jquery.js
    var rbracket = /\[\]$/;

    $.extend({
        jsonParam: function( json ) {
            // 定义返回结果集
            var result = {},
                // 定义添加数据方法
                add = function( key, value ) {
                    result[key] = value;
                };

            // 判断方法参数输入为空
            if ( json != undefined && json != '' ) {
                for ( var prefix in json ) {
                    buildParamsForSpringMvc( prefix, json[ prefix ], add );
                }
            }

            // 返回处理完成的数据
            return result;
        }
    });

    /* private method*/
    /**
     * 构建适合SpringMvc的数据格式
     * @param prefix 前缀
     * @param obj 值
     * @param add 添加数据方法
     */
    function buildParamsForSpringMvc( prefix, obj, add ) {
        // 如果值是数组
        if ( jQuery.isArray( obj ) ) {
            // Serialize array item.
            jQuery.each( obj, function( i, v ) {
                if (rbracket.test( prefix ) ) {
                    // Treat each array item as a scalar.
                    add( prefix, v );

                } else {
                    buildParamsForSpringMvc( prefix + "[" + ( typeof v === "object" || jQuery.isArray(v) ? i : "" ) + "]", v, add );
                }
            });

        } else if (obj != null && typeof obj === "object" ) {
            // Serialize object item.
            for ( var name in obj ) {
                buildParamsForSpringMvc( prefix + "." + name, obj[ name ], add );
            }

        } else {
            // Serialize scalar item.
            add( prefix, obj );
        }
    };
})(jQuery);