package com.smart_road.transport.mapper;

import com.smart_road.transport.dto.response.TransportResponse;
import com.smart_road.transport.entity.TransportEntity;
import org.springframework.stereotype.Component;

@Component
public class TransportMapper {
    public TransportResponse toResponse(TransportEntity entity) {
        return new TransportResponse(
                entity.getNumber(),
                entity.getTransportType(),
                entity.getRoute(),
                entity.getCapacity()
        );
    }
}
