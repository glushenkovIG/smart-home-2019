package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Door;

import java.util.Collection;
import java.util.Iterator;

public class DoorsIterator implements myIterator<Door> {
    public Collection<Door> doorCollection;
    public Iterator<Door> doorIterator;

    public DoorsIterator(SmartHome smartHome) {
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

