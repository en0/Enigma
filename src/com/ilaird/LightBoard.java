package com.ilaird;

public class LightBoard implements ILightBoard {
    @Override
    public char Illuminate(int i) {
        return (char)(i + 'A');
    }
}
