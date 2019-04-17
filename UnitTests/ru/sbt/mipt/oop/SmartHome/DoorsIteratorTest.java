package ru.sbt.mipt.oop.SmartHome;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHomeIterators.DoorsIterator;

public class DoorsIteratorTest {
    SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
    SmartHome smartHome = reader.Read();
    DoorsIterator doorsIterator = new DoorsIterator(smartHome);

    @Test
    public void unit1() {
        System.out.println("===============================\n========DoorsIteratorTest=========");
        Door door;
        int i = 0;
        while(doorsIterator.hasNext()){
            i++;
            door = doorsIterator.next();
            System.out.println("door with id: \t" + door.getId() + " in: \t" + door.getRoomName());
        }
        Assert.assertEquals(i, 4);
    }
}