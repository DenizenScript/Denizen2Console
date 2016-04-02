package org.mcmonkey.denizen2console;

import org.mcmonkey.denizen2console.commands.commoncommands.QuitCommand;
import org.mcmonkey.denizen2core.Denizen2Core;
import org.mcmonkey.denizen2core.utilities.debugging.Debug;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Denizen2Console {

    public static void main(String[] args) {
        Denizen2Core.init(new Denizen2ConsoleImplementation());
        Denizen2Core.register(new QuitCommand());
        System.out.println("Denizen2: SimpleConsoleImplementation, running core: " + Denizen2Core.version);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String str = buffer.readLine();
                Denizen2Core.runString(str);
            }
            catch (Exception ex) {
                Debug.exception(ex);
            }
        }
    }
}
