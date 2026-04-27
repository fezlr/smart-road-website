package com.smart_road.transport.controller.api;

import com.smart_road.transport.dto.request.TransportDeleteRequest;
import com.smart_road.transport.dto.request.TransportRequest;
import com.smart_road.transport.dto.response.TransportResponse;
import com.smart_road.transport.service.TransportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/transport")
@RestController
public class TransportController {
    private final TransportService transportService;

    @PostMapping("/create")
    public ResponseEntity<TransportResponse> create(@Valid @RequestBody TransportRequest request) {
        return ResponseEntity.ok(transportService.create(request));
    }

    @PatchMapping("/update")
    public ResponseEntity<TransportResponse> update(@Valid @RequestBody TransportRequest request) {
        return ResponseEntity.ok(transportService.update(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@Valid @RequestBody TransportDeleteRequest request) {
        transportService.delete(request);
        return ResponseEntity.ok().build();
    }
}