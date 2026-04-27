package com.smart_road.transport.dto.response;

import com.smart_road.transport.enums.TransportType;

public record TransportResponse(
        String number,

        TransportType transportType,

        String route,

        Integer capacity
) {
}