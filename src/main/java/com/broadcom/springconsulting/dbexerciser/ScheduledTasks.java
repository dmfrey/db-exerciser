package com.broadcom.springconsulting.dbexerciser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableScheduling
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger( ScheduledTasks.class );

    private final TimeRepository timeRepository;

    public ScheduledTasks( final TimeRepository timeRepository ) {

        this.timeRepository = timeRepository;

    }

    @Scheduled( fixedRate = 5000 )
    public void recordCurrentTime() {
        log.debug( "recordCurrentTime : enter" );

        var now =  Instant.now();

        var timeLog = new TimeLog( null, now );
        this.timeRepository.save( timeLog );
        log.info( "recordCurrentTime : recording current time-log [{}]", timeLog );

        log.debug( "recordCurrentTime : exit" );
    }

}