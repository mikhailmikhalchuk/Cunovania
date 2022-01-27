package com.cuno.cunovania.common;

import java.awt.*;
import java.util.List;

public class Input {
    public static PointerInfo mouseState;
    public static PointerInfo oldMouseState;
    public static List<Integer> keysPressed;

    public static boolean mouseDown;

    public static void handleInput() {
        oldMouseState = mouseState;
        mouseState = MouseInfo.getPointerInfo();
    }

    public static boolean keyDown(int keyCode) {
        return keysPressed.contains(keyCode);
    }
}
