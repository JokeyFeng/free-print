package com.sellercube.printserver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 开箱入库实体类
 * <p>
 * 加了@NonNull 需要自己构建一个空的构造方法
 * 否则会报{@link com.fasterxml.jackson.databind.JsonMappingException}
 * Created by Chenjing on 2018/1/2.
 *
 * @author Chenjing
 */
@Data
@NoArgsConstructor
public class OpenBox {
    /**
     * 包含条码的实体
     */
    @NonNull
    private ProductNumber productNumber;
    /**
     * 包含sku poa的实体
     */
    @NonNull
    private ProductDetail productDetail;

    @Data
    @NoArgsConstructor
    private class ProductNumber {
        /**
         * sft开头的号码  SFT-001-005-1
         */
        @NonNull
        private String sftNumber;
        /**
         * 条码  123456789
         */
        @NonNull
        private String barCode;
        /**
         * rn开头的号码  RN00001
         */
        @NonNull
        private String rnNumber;
        /**
         * 右下方的数字  9
         */
        @NonNull
        private int num;
    }

    @Data
    @NoArgsConstructor
    private class ProductDetail {
        /**
         * sku或者poa SKU00001
         */
        @NonNull
        private String poaOrSku;
        /**
         * 字段为 黑色XL
         */
        @NonNull
        private String size;
        /**
         * 箱号 A-1-1-1
         */
        @NonNull
        private String boxNo;
    }
}

