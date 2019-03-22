package ru.sbt.mipt.oop.SmartHomeIterators;

import ru.sbt.mipt.oop.SmartHome.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RoomsIterator implements myIterator {
    private Iterator<Room> roomIterator;

    public RoomsIterator(SmartHome smartHome) {
        if(smartHome == null){
            System.out.println("Null" + this.getClass());
        }
        assert smartHome != null;
        Collection<Room> rooms = smartHome.getRooms();
        roomIterator = rooms.iterator();

        Collection<Room> roomCollection = new ArrayList<>();
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
