package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Door;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DoorsIterator implements myIterator<Door> {
    public Collection<Door> doorCollection = new ArrayList<>();
    public Iterator<Door> doorIterator;

    public DoorsIterator(SmartHome smartHome) {
        if(smartHome == null){
            System.out.println("Null" + this.getClass());
        }
        RoomsIterator roomIterator = new RoomsIterator(smartHome);
        while(roomIterator.hasNext()) {
            doorCollection.addAll(roomIterator.next().getDoors());
        }
        doorIterator = doorCollection.iterator();
    }

    @Override
    public Door next() {
        return doorIterator.next();
    }

    @Override
    public boolean hasNext() {
        return doorIterator.hasNext();
    }
}

