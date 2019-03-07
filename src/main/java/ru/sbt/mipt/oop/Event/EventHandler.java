package ru.sbt.mipt.oop.Event;

import ru.sbt.mipt.oop.SmartHome.SmartHome;

public interface EventHandler {
    void HandleEvent(SmartHome smartHome, Object event_, EventSender sender);
}
