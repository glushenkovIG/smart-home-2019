package ru.sbt.mipt.oop.Event;

import ru.sbt.mipt.oop.Alarm.Alarm;

public class SecurityHandlerDecorator extends HandlerDecorator {
    Alarm alarm;
    public SecurityHandlerDecorator(EventHandler handler) {
        super(handler);
    }

    public SecurityHandlerDecorator(EventHandler handler, Alarm alarm){
        super(handler);
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(Object o) {
        if(!alarm.isActivated()) {
            handler.handleEvent(o);
        }
    }
}
