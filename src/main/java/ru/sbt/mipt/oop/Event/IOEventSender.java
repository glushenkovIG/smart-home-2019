package ru.sbt.mipt.oop.Event;

public class IOEventSender implements EventSender {
    @Override
    public Object sendCommand(Object command) {
        System.out.println("Pretent we're sending command " + command);
        return null;
    }
}
