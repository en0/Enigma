package com.ilaird;

public interface IMachine {
    void SetRotorCode(String code);
    String GetRotorCode();
    String Cipher(String value);
    void InstallRotors(IRotor rotor1, IRotor rotor2, IRotor rotor3, IRotor reflector);
}
