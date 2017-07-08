package com.sellercube.common.entity;

/**
 * Created by Chenjing on 2017/5/3.
 * jsonview
 */
public class View {
    public interface BaseView extends ResultJsonView.BaseView {}
    public interface Summary extends BaseView{}
    public interface Public extends Summary {}
}
