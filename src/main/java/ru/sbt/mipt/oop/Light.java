package ru.sbt.mipt.oop;


public class Light implements Actionable{

    private boolean isOn;
    private final String id;
    private Room room = null;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void execute(Action action){
        if (id.equals(action.getObjectId())) {
            switch (action.getType()){
                case TURN_ON_LIGHT:
                    setOn(true);
                    System.out.println("Light " + getId() + " in room " + room.getName() + " was turned on.");
                    break;

                case TURN_OFF_LIGHT:
                    setOn(false);
                    System.out.println("Light " + getId() + " in room " + room.getName() + " was turned off.");
                    break;
            }
        }
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
