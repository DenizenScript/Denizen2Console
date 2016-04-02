package org.mcmonkey.denizen2console;

import org.mcmonkey.denizen2core.Denizen2Implementation;

public class Denizen2ConsoleImplementation extends Denizen2Implementation {

    @Override
    public void outputException(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void outputInfo(String text) {
        System.out.println(text);
    }
}
