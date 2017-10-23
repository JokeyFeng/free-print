package com.sellercube.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 打印参数
 * Created by Chenjing on 2017/10/13.
 *
 * @author Chenjing
 */
@Data
@Accessors(chain = true)
public class PrintParam {
    private String userId;
    private String printType;
    /**
     * 来自于棒谷接口还是飞特接口
     */
    private String from;
    /**
     * 渠道类型
     */
    private String shipType;
    /**
     * 内容
     */
    private String content;
    /**
     * 格式
     */
    private String format;
    private String fbaCode;
}
