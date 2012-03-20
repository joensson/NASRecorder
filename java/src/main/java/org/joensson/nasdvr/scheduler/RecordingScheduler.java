package org.joensson.nasdvr.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.lang.Long.parseLong;

/**
 * User: frj
 * Date: 3/20/12
 * Time: 12:42 AM
 *
 * @Author frj
 */

@Component
public class RecordingScheduler {
    private static final Logger logger = LoggerFactory.getLogger(RecordingScheduler.class);

    @Scheduled(cron = "${scheduler.cron}" )
    public void record() {
        logger.info("Checking if any recordings should be started...");
    }
}
