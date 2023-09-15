package com.design.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRemoteControlTest {

  @Test
  @DisplayName("커맨드 패턴 리모콘 테스트")
  void test20230914224635() {
    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light();
    LightOnCommand lightOn = new LightOnCommand(light);
    GarageDoor garageDoor = new GarageDoor();
    GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

    remote.setSlot(lightOn);
    remote.buttonWasPressed();
    remote.setSlot(garageDoorOpen);
    remote.buttonWasPressed();
  }
}