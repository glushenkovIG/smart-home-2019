package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Room;

import java.util.Collection;
import java.util.Iterator;

public class RoomsIterator implements myIterator {
    private Collection<Room> roomCollection;

    private Iterator<Room> roomIterator;

    RoomsIterator(SmartHome smartHome) {
        roomCollection = smartHome.getRooms();
        while(roomIterator.hasNext()) {
            roomCollection.add(roomIterator.next());
        }
        roomIterator = roomCollection.iterator();
    }

    @Override
    public Room next() {
        return roomIterator.next();
    }

    @Override
    public boolean hasNext() {
        return roomIterator.hasNext();
    }
}
