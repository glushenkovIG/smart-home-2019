package ru.sbt.mipt.oop.SmartHomeIterators;

import ru.sbt.mipt.oop.SmartHome.Light;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LightIterator implements myIterator<Light> {
    public Collection<Light> lightCollection = new ArrayList<>();
    public Iterator<Light> lightIterator;

    public LightIterator(SmartHome smartHome) {
        RoomsIterator roomIterator = new RoomsIterator(smartHome);
        while(roomIterator.hasNext()) {
            lightCollection.addAll(roomIterator.next().getLights());
        }
        lightIterator = lightCollection.iterator();
    }

    @Override
    public Light next() {
        return lightIterator.next();
    }

    @Override
    public boolean hasNext() {
        return lightIterator.hasNext();
    }
}
