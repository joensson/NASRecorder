package org.joensson.nasdvr.web;

import org.joensson.nasdvr.model.Actor;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static junit.framework.Assert.*;

/**
 * User: frj
 * Date: 3/21/12
 * Time: 1:41 AM
 *
 * @Author frj
 */
public class ControllerTest {

    private static final String BASE_URL = "http://localhost:8080/nasdvr/rest";

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void canGetJsonResponseFromController() {
        Actor actor = restTemplate.getForObject(BASE_URL + "/schedule/showSchedule", Actor.class);

        assertNotNull("Actor not found", actor);
    }
}
