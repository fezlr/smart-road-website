package com.smart_road.transport.service;

import com.smart_road.transport.dto.request.TransportDeleteRequest;
import com.smart_road.transport.dto.request.TransportRequest;
import com.smart_road.transport.dto.response.TransportResponse;
import com.smart_road.transport.entity.TransportEntity;
import com.smart_road.transport.mapper.TransportMapper;
import com.smart_road.transport.repository.TransportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransportService {
    private final TransportMapper transportMapper;
    private final TransportRepository transportRepository;

    @Transactional
    public TransportResponse create(TransportRequest request) {
        log.info("Called create method with BODY = {}", request);
        var entity = TransportEntity.builder()
                .number(request.number())
                .transportType(request.transportType())
                .route(request.route())
                .capacity(request.capacity())
                .build();
        return transportMapper.toResponse(transportRepository.save(entity));
    }

    @Transactional
    public void delete(TransportDeleteRequest request) {
        var entity = transportRepository
                .findById(request.id())
                .orElseThrow(
                        () -> new EntityNotFoundException("Transport not found"));

        transportRepository.deleteById(request.id());
    }

    @Transactional
    public TransportResponse update(TransportRequest request) {
        var entity = transportRepository.findById(request.id()).orElseThrow(() -> new IllegalStateException("Transport is not found"));

        entity.setNumber(request.number());
        entity.setTransportType(request.transportType());
        entity.setRoute(request.route());
        entity.setCapacity(request.capacity());

        return transportMapper.toResponse(transportRepository.save(entity));
    }
}
