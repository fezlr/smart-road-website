package com.smart_road.transport.repository;

import com.smart_road.transport.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<TransportEntity, Long> {
}
