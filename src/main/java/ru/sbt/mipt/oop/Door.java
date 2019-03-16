package ru.sbt.mipt.oop;

public class Door implements Actionable{
    private final String id;
    private boolean isOpen;
    private Room room = null;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
    public void execute(Action action){

        if (id.equals(action.getObjectId())) {
            switch (action.getType()){
                case OPEN_THE_DOOR:
                    setOpen(true);
                    System.out.println("Door " + getId() + " in room " + room.getName() + " was opened.");
                    break;

                case CLOSE_THE_DOOR:
                    setOpen(false);
                    System.out.println("Door " + getId() + " in room " + room.getName() + " was closed.");
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
