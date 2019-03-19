package ru.sbt.mipt.oop;

public interface Action {

     ActionType type = null;
     String objectId = null;

    static ActionType getType() {
        return type;
    }

    static String getObjectId() {
        return objectId;
    }
/*
    String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
*/
    public void execute(Object o); /*{
        if (o instanceof Door) {
            Door door = (Door) o;
            execute(door);
        }
        else if (o instanceof Light) {
            Light light = (Light) o;
            execute(light);
        }
    }



    public void execute(Light light) {
        if (light.getId().equals(this.getObjectId())) {
            switch (this.getType()){
                case TURN_ON_LIGHT:
                    light.setOn(true);
                    System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned on.");
                    break;

                case TURN_OFF_LIGHT:
                    light.setOn(false);
                    System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned off.");
                    break;
            }
        }
    }
    */
}
