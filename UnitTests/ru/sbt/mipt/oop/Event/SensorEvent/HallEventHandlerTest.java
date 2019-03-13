package ru.sbt.mipt.oop.Event.SensorEvent;

import junit.framework.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.IOCommandSender;
import ru.sbt.mipt.oop.Event.SensorEvent.HallEventHandler;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.SmartHomeGsonReader;
import ru.sbt.mipt.oop.SmartHome.SmartHomeReader;

import static org.junit.Assert.*;

public class HallEventHandlerTest {
    SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
    SmartHome smartHome = reader.Read();

    CommandSender sender = new IOCommandSender();
    EventHandler handler = new HallEventHandler(smartHome, sender);

    @Test
    public void unit1() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void unit2() {
        Assert.assertEquals(1, 1);
    }
}