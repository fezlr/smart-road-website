package com.smart_road.transport.dto.request;

import com.smart_road.transport.enums.TransportType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransportRequest(
        Long id,

        @NotBlank
        String number,

        @NotNull
        TransportType transportType,

        @NotBlank
        String route,

        @NotNull
        Integer capacity
) {
}
