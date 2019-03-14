package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Door getDoorByID(String id){

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id)){
                    return door;
                }
            }
        }

        return null;
    }

    public Light getLightByID(String id){
        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id)) {
                    return light;
                }
            }
        }

        return null;
    }

    @Override
    public void execute(Action action){
        DoorsIterator doorsIterator = new DoorsIterator(this);
        while (doorsIterator.hasNext()){
            doorsIterator.next().execute(action);
        }

        RoomsIterator roomsIterator = new RoomsIterator(this);
        while (roomsIterator.hasNext()){
            roomsIterator.next().execute(action);
        }

        LightIterator lightIterator = new LightIterator(this);
        while (lightIterator.hasNext()){
            lightIterator.next().execute(action);
        }
    }
}
