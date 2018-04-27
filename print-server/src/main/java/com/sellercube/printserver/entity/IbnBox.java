package com.sellercube.printserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author :JokeyZheng
 * Date: 2018/4/27
 * Email:JokeyFeng@foxmail.com
 * Version:1.0.0
 * Description:
 */
@Data
@NoArgsConstructor
public class IbnBox {

    /**
     * 包含条码的实体
     */
    @NonNull
    private IbnObject ibnObject;
    /**
     * 包含sku poa的实体
     */
    @NonNull
    private ProductDetail productDetail;

    @Data
    @NoArgsConstructor
    private class IbnObject {
        /**
         * IBN开头的号码  IBN000502153564
         */
        @NonNull
        private String ibnNumber;
        /**
         * 处理中心代码  GZWH
         */
        @NonNull
        private String centerCode;
        /**
         * POA或SKU  POA433243
         */
        @NonNull
        private String skuOrPoa;
        /**
         * 颜色 红色
         */
        @NonNull
        private String color;
    }

    @Data
    @NoArgsConstructor
    private class ProductDetail {
        /**
         * sku或者poa SKU00001
         */
        @NonNull
        private String skuOrPoa;
        /**
         * 颜色 黑色
         */
        @NonNull
        private String color;
        /**
         * 日期-操作者ID 0413-00001
         */
        @NonNull
        private String userId;

        /**
         * 货架号 A-A-01-01
         */
        @NonNull
        private String shelfNumber;
    }
}
