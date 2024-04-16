package com.broadcom.springconsulting.dbexerciser;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class TimeLog {

    @Id
    UUID id;
    Timestamp time;

    public TimeLog() {
        this.id = UUID.randomUUID();
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp ts) {
        this.time = ts;
    }


}
