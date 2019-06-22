package com.ilaird;

public class Reflector implements IRotor {

    private int[] wires;

    @Override
    public void SetOffset(int o) { }

    @Override
    public int GetOffset() { return 0; }

    @Override
    public void AttachTo(IRotor r) { }

    @Override
    public void NextOffset() { }

    @Override
    public void PushRotor(boolean force) { }

    @Override
    public int Signal(int i) { return wires[i]; }

    protected void Program(int[] v) { wires = v; }
}
