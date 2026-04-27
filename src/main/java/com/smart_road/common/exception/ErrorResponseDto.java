package com.smart_road.common.exception;

public record ErrorResponseDto(
        int status,

        String error,

        String message,

        String timestamp
) {
}
