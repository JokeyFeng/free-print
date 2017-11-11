package com.sellercube.printserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(value = "Data")
    private DotNetFba data;
}
