package com.ilaird;

public class Keyboard implements IKeyboard {
    @Override
    public int Press(char c) {
        if (!Character.isAlphabetic(c))
            return -1;
        return Character.toLowerCase(c) - 'a';
    }
}
