package com.ilaird;

public class Machine implements IMachine {

    private IKeyboard keyboard = new Keyboard();
    private ILightBoard lightBoard = new LightBoard();
    private IRotor rotor1, rotor2, rotor3;

    @Override
    public String Cipher(String value) {

        StringBuilder sb = new StringBuilder();

        for (char c : value.toCharArray()) {

            int i1 = keyboard.Press(c);

            if (i1 < 0) {
                sb.append(c);
                continue;
            }

            rollover();
            int i2 = rotor3.Signal(i1);
            char i3 = lightBoard.Illuminate(i2);
            sb.append(i3);

        }
        return sb.toString().toUpperCase();
    }

    @Override
    public void SetRotorCode(String code) {
        char[] _code = code.toCharArray();
        rotor1.SetOffset(keyboard.Press(_code[0]));
        rotor2.SetOffset(keyboard.Press(_code[1]));
        rotor3.SetOffset(keyboard.Press(_code[2]));
    }

    @Override
    public String GetRotorCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(lightBoard.Illuminate(rotor1.GetOffset()));
        sb.append(lightBoard.Illuminate(rotor2.GetOffset()));
        sb.append(lightBoard.Illuminate(rotor3.GetOffset()));
        return sb.toString().toUpperCase();
    }

    @Override
    public void InstallRotors(IRotor rotor1, IRotor rotor2, IRotor rotor3, IRotor reflector) {

        rotor3.AttachTo(rotor2);
        rotor2.AttachTo(rotor1);
        rotor1.AttachTo(reflector);

        this.rotor3 = rotor3;
        this.rotor2 = rotor2;
        this.rotor1 = rotor1;
    }

    private void rollover() {
        // rotor1.PushRotor(false);
        rotor2.PushRotor(false);
        rotor3.PushRotor(true);
    }
}
