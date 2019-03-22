package ru.sbt.mipt.oop.NextEventGetters;

import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

import java.util.ArrayList;

public class NextEventGetter {
    static ArrayList<NextEventGetter> eventGetters;
    static int i = 0;
    NextEventGetter(){
        this.eventGetters = new ArrayList<>();
    }

    public NextEventGetter(ArrayList<NextEventGetter> a){
        this.eventGetters = a;
    }

    public static SensorEvent getNextSensorEvent(){
        SensorEvent ans = eventGetters.get(i).getNextSensorEvent();
        i += 1;
        i = i % eventGetters.size();
        return ans;
    }
}
