package ru.sbt.mipt.oop.Event.SensorEvent;

import junit.framework.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.IOCommandSender;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.SmartHomeGsonReader;
import ru.sbt.mipt.oop.SmartHome.SmartHomeReader;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_OFF;

public class LightSensorEventHandlerTest {
    SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
    SmartHome smartHome = reader.Read();

    CommandSender sender = new IOCommandSender();
    EventHandler handler = new DoorSensorEventHandler(smartHome, sender);

    @Test
    public void unit1() {
        String objectId = "" + ((int) (1 + 3 * Math.random()));
        handler.handleEvent(new SensorEvent(LIGHT_ON, objectId));

        Assert.assertEquals(true, smartHome.getLightByID(objectId).isOn());
        //Assert.assertEquals(1, 1);
    }

    @Test
    public void unit2() {
        String objectId = "" + ((int) (1 + 3 * Math.random()));
        handler.handleEvent(new SensorEvent(LIGHT_OFF, objectId));

        Assert.assertEquals(false, smartHome.getLightByID(objectId).isOn());
        //Assert.assertEquals(1, 1);
    }
}