package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.Actionable;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;



    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;

        //provide info to lights and doors
        normalize();

    }

    public void normalize(){
        lights.forEach(light -> light.setRoom(this));
        doors.forEach(light -> light.setRoom(this));
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action){
        lights.forEach(light -> light.execute(action));
        doors.forEach(door -> door.execute(action));
    }
}
