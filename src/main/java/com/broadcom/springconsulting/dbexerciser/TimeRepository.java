package com.broadcom.springconsulting.dbexerciser;

import org.springframework.data.repository.CrudRepository;

interface TimeRepository extends CrudRepository<TimeLog, String> { }