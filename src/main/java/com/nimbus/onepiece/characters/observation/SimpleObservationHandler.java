package com.nimbus.onepiece.characters.observation;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleObservationHandler implements ObservationHandler<Observation.Context> {

    @Override
    public void onStart(Observation.Context context) {

        if ("crew".equals(context.getName())) {
            log.info("START " + "data: " + context.get(String.class));
        }
    }

    @Override
    public void onError(Observation.Context context) {
        if ("crew".equals(context.getName())) {

            log.info("ERROR " + "data: " + context.get(String.class) + ", error: " + context.getError());
        }
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        if ("crew".equals(context.getName())) {

            log.info("EVENT " + "event: " + event + " data: " + context.get(String.class));
        }
    }

    @Override
    public void onStop(Observation.Context context) {
        if ("crew".equals(context.getName())) {
            log.info("STOP  " + "data: " + context.get(String.class));
        }
    }

    @Override
    public boolean supportsContext(Observation.Context handlerContext) {
        // you can decide if your handler should be invoked for this context object or
        // not
        return true;
    }

}