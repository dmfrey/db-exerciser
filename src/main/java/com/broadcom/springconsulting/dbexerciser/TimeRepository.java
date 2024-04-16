package com.broadcom.springconsulting.dbexerciser;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

interface TimeRepository extends JpaRepository<TimeLog, UUID> { }