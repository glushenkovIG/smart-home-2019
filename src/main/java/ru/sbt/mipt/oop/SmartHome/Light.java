package ru.sbt.mipt.oop.SmartHome;


import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.Actionable;

public class Light implements Actionable {

    private boolean isOn;
    private final String id;
    private Room room = null;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void execute(Action action){
       action.execute(this);
    }

    public void setRoom(Room room){
        this.room = room;
    }
    public String getRoomName(){
        return room.getName();
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
