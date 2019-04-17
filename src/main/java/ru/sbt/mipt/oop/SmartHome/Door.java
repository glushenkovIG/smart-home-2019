package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.Actionable;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private Room room = null;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public Door() {
        this.id = null;
        this.isOpen = false;
    }

    @Override
    public void execute(Action action){
        action.execute(this);
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public String getRoomName(){
        if (room == null){
            return "NotExistingDoor";
        }
        return room.getName();
    }

    public String getId() {
        return id;
    }

    public boolean isOpen(){
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

}
