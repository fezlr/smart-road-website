package com.smart_road.transport.dto.request;

import jakarta.validation.constraints.NotNull;

public record TransportDeleteRequest(
        @NotNull
        Long id
) {}
