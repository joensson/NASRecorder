package org.joensson.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    @Scheduled(fixedDelay = 120000)
    public void record() {
        logger.info("Recording...");
    }
}
