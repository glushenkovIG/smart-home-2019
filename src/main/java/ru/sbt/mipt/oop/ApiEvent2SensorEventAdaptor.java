package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType;
import ru.sbt.mipt.oop.events.CCSensorEvent;

public class ApiEvent2SensorEventAdaptor {

     public static SensorEvent adapt(Object o) throws ClassCastException {
     CCSensorEvent ccsevent = (CCSensorEvent) o;
         switch (ccsevent.getEventType()){
             case "LightIsOn":
                 return new SensorEvent(SensorEventType.LIGHT_ON, ccsevent.getObjectId());

             case "LightIsOff":
                 return new SensorEvent(SensorEventType.LIGHT_OFF, ccsevent.getObjectId());

             case "DoorIsOpen":
                 return new SensorEvent(SensorEventType.DOOR_OPEN, ccsevent.getObjectId());

             case "DoorIsClosed":
                 return new SensorEvent(SensorEventType.DOOR_CLOSED, ccsevent.getObjectId());

             default:
                 throw new ClassCastException();
         }
     }
}
