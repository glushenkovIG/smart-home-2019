package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmStateType;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.HandlerDecorator;

public class SecurityHandlerDecorator extends HandlerDecorator {
    Alarm alarm;
    public SecurityHandlerDecorator(EventHandler handler) {
        super(handler);
    }

    SecurityHandlerDecorator(EventHandler handler, Alarm alarm){
        super(handler);
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(Object o) {
        if(alarm.getStateType() != AlarmStateType.SHOUTING_MODE) {
            handler.handleEvent(o);
        }
    }
}
