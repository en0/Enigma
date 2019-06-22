package com.ilaird;

public class ReflectorB extends Reflector implements IRotor {

    @Override
    public void SetOffset(int o) { }

    @Override
    public int GetOffset() { return 0; }

    @Override
    public void AttachTo(IRotor r) { }

    public ReflectorB() {
        this.Program(new int[]{
                24, //a
                17, //b
                20, //c
                7, //d
                16, //e
                18, //f
                11, //g
                3, //h
                15, //i
                23, //j
                13, //k
                6, //l
                14, //m
                10, //n
                12, //o
                8, //p
                4, //q
                1, //r
                5, //s
                25, //t
                2, //u
                22, //v
                21, //w
                9, //x
                0, //y
                19, //z

        });
    }
}
