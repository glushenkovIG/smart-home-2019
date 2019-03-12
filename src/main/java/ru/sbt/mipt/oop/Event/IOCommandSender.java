package ru.sbt.mipt.oop.Event;


public class IOCommandSender implements CommandSender {
    @Override
    public void sendCommand(Object command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
