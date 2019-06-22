package com.ilaird;

public class Main {

    public static void main(String[] args) {

        IMachine machine = new Machine();

        machine.InstallRotors(
                new Rotor1(),
                new Rotor2(),
                new Rotor3(),
                new ReflectorB());

        String code = "ABC";
        String message = "ROMUL LBIBB";

        machine.SetRotorCode(code);
        String cipher = machine.Cipher(message);

        System.out.println("Start Code: " + code);
        System.out.println("Output: " + cipher);
        System.out.println("End Code: " + machine.GetRotorCode());
    }
}
