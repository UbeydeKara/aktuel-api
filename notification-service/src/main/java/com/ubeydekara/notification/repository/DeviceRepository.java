package com.ubeydekara.notification.repository;

import com.ubeydekara.notification.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
