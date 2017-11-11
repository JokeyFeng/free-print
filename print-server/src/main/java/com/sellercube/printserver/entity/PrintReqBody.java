package com.sellercube.printserver.entity;

import lombok.Data;

/**
 * Created by Chenjing on 2017/11/10.
 *
 * @author Chenjing
 */
@Data
public class PrintReqBody {


    /**
     * 用户Id
     */

    private Integer userId;


    /**
     * 打印类型
     */
    private String printType;


    /**
     * 文件流字符串，Base64加密
     */

    private String fileStream;


    /**
     * 图片宽度
     */

    private Integer width;


    /**
     * 图片高度
     */

    private Integer height;


    /**
     * 图片类型
     */

    private String imgType;
}
