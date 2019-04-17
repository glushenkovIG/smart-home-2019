package ru.sbt.mipt.oop.events;

public interface RemoteControl {
    void onButtonPressed(String buttonCode, String rcId);
    // код нажатой кнопки: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”, rcId - id пульта
}
