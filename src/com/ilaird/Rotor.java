package com.ilaird;

public class Rotor implements IRotor {

    private int offset = 0;
    private int rollover = 25;
    private IRotor nextRotor;
    private int[][] wires;

    @Override
    public void SetOffset(int o) { offset = o; }

    @Override
    public int GetOffset() { return offset; }

    @Override
    public void AttachTo(IRotor r) { nextRotor = r; }

    @Override
    public void NextOffset() {

        if (offset == rollover)
            nextRotor.NextOffset();

        if (++offset > 25)
            offset = 0;
    }

    @Override
    public void PushRotor(boolean force) {
        if (force || offset == rollover)
            NextOffset();
    }

    @Override
    public int Signal(int i) {
        int xi = SignalFromRight(i);
        int yi = SignalNextRotor(xi);
        int out = SignalFromLeft(yi);
        return AdjustInputs(out, -1);
    }

    protected void Program(int rollover, int[][] v) {
        this.rollover = rollover;
        wires = v;
    }

    private int AdjustInputs(int i) {
        return AdjustInputs(i, 1);
    }

    private int AdjustInputs(int i, int multi) {
        int x = i + (offset * multi);
        if (x > 25)
            x -= 26;
        else if (x < 0)
            x += 26;
        return x;
    }

    private int SignalFromRight(int i) {
        int x = AdjustInputs(i);
        return wires[x][1];
    }

    private int SignalNextRotor(int i) {
        int x = AdjustInputs(i, -1);
        return nextRotor.Signal(x);
    }

    private int SignalFromLeft(int i) {
        int x = AdjustInputs(i);
        return wires[x][0];
    }
}
