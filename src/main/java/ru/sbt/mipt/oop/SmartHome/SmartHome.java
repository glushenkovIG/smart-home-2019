package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.Actionable;
import ru.sbt.mipt.oop.SmartHomeIterators.DoorsIterator;
import ru.sbt.mipt.oop.SmartHomeIterators.LightIterator;

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
        DoorsIterator doorIterator = new DoorsIterator(this);
        Door door;
        while (doorIterator.hasNext()){
            door = doorIterator.next();
            if (door.getId().equals(id)) {
                return door;
            }
        }
        System.out.println("Trying to call door with ID=" + id + ", but it doesn't exist.");
        return null;
    }

    public Light getLightByID(String id){
        LightIterator lightIterator = new LightIterator(this);
        Light light;
        while (lightIterator.hasNext()){
            light = lightIterator.next();
            if (light.getId().equals(id)) {
                return light;
            }
        }
        System.out.println("Trying to call light with ID=" + id + ", but it doesn't exist.");
        return null;
    }

    @Override
    public void execute(Action action){
        rooms.forEach(room -> room.execute(action));
    }
    void normalize(){
        rooms.forEach(Room::normalize);
    }
}
