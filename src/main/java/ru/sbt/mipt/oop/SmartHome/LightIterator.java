package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Light;

import java.util.Collection;
import java.util.Iterator;

public class LightIterator implements myIterator<Light> {
    public Collection<Light> lightCollection;
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
