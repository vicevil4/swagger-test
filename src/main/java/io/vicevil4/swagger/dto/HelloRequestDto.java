package io.vicevil4.swagger.dto;

import io.swagger.annotations.ApiModelProperty;

public class HelloRequestDto {

    @ApiModelProperty(value = "메시지", required = true)
    private String message;

    public String getMessage() {
        return message;
    }
}
