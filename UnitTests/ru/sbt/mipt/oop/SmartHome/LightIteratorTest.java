package ru.sbt.mipt.oop.SmartHome;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHomeIterators.DoorsIterator;
import ru.sbt.mipt.oop.SmartHomeIterators.LightIterator;

public class LightIteratorTest {
    SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
    SmartHome smartHome = reader.Read();
    LightIterator lightIterator = new LightIterator(smartHome);

    @Test
    public void unit1() {
        System.out.println("===============================\n========LightsIteratorTest=========");
        Light light;
        int i = 0;
        while(lightIterator.hasNext()){
            i++;
            light = lightIterator.next();
            System.out.println("light with id: \t" + light.getId() + " in: \t" + light.getRoomName());
        }
        Assert.assertEquals(i, 9);
    }
}