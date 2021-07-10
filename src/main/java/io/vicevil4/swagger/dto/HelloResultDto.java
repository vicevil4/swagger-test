package io.vicevil4.swagger.dto;

import io.swagger.annotations.ApiModelProperty;

public class HelloResultDto {

    @ApiModelProperty(value = "서버시간", required = true)
    private String serverTime;

    @ApiModelProperty(value = "반환메시지", required = true)
    private String returnMessage;

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
