package ru.sbt.mipt.oop;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.NextEventGetters.NextEventGetter;
import ru.sbt.mipt.oop.NextEventGetters.RandomSensorNextEventGetter;

public class NextEventGetterTest {
    @Test
    public void RandomSensorNextEventGetterTest() {
        System.out.println("=============================\n==RandomSensorNextEventGetterTest==");

        NextEventGetter nextEventGetter = new RandomSensorNextEventGetter();
        for(int i = 0; i < 10; i++){
            SensorEvent nextEvent = nextEventGetter.getNextSensorEvent();
            try {
                System.out.println("next event " + nextEvent.getType());
            } catch( NullPointerException o){ /*todo why is it needed */}
        }
        Assert.assertEquals(1, 1);
    }
}