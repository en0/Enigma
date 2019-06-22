package com.ilaird;

public interface IRotor {
    void SetOffset(int o);
    int GetOffset();
    void NextOffset();
    void PushRotor(boolean force);
    int Signal(int i);
    void AttachTo(IRotor r);
}
