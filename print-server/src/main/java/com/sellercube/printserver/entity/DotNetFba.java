package com.sellercube.printserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Chenjing on 2017/11/1.
 *
 * @author Chenjing
 */
@Data
@Accessors(chain = true)
public class DotNetFba {

    @JsonProperty(value = "Id")
    private String id;

    @JsonProperty(value = "FBACode")
    private String fbaCode;

    @JsonProperty(value = "Transport")
    private String transport;

    @JsonProperty(value = "Length")
    private String length;

    @JsonProperty(value = "Width")
    private String width;

    @JsonProperty(value = "Height")
    private String height;

    @JsonProperty(value = "Weight")
    private String weight;

    @JsonProperty(value = "WeighingUserName")
    private String weighingUserName;

    @JsonProperty(value = "ProcessCenterID")
    private String processCenterID;

    @JsonProperty(value = "AddWeighingTime")
    private String addWeighingTime;

    @JsonProperty(value = "PDFUrl")
    private String pdfUrl;

    @JsonProperty(value = "TrackUserName")
    private String trackUserName;

    @JsonProperty(value = "AddTrackTime")
    private String addTrackTime;

    @JsonProperty(value = "AreaID")
    private String areaId;

    @JsonProperty(value = "ShipType")
    private String shipType;

    @JsonProperty(value = "TrackID")
    private String trackId;

    @JsonProperty(value = "SFTCode")
    private String sftCode;

    @JsonProperty(value = "ChannelNum")
    private String channelNum;

    @JsonProperty(value = "FbaStatus")
    private String fbaStatus;
}
