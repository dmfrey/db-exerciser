package com.broadcom.springconsulting.dbexerciser;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Table( name = "TIME_LOG" )
class TimeLog {

    @Id
    String id;
    Timestamp time;

    TimeLog(final String id, final Instant time ) {
        this.id = id;
        this.time = Timestamp.from( time );
    }

    String getId() {

        return id;
    }

    Instant getTime() {

        return this.time.toInstant();
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;

        TimeLog timeLog = (TimeLog) o;
        return Objects.equals(id, timeLog.id) && Objects.equals( time, timeLog.time );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

    @Override
    public String toString() {

        return "TimeLog{" +
                "id='" + id + '\'' +
                ", time=" + time +
                '}';
    }

}
