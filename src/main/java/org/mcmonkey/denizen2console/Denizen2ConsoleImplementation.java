package org.mcmonkey.denizen2console;

import org.mcmonkey.denizen2core.Denizen2Implementation;
import org.mcmonkey.denizen2core.commands.CommandEntry;
import org.mcmonkey.denizen2core.commands.CommandQueue;

import java.io.File;

public class Denizen2ConsoleImplementation extends Denizen2Implementation {

    @Override
    public void outputException(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void outputInfo(String text) {
        System.out.println("[Info] " + text);
    }

    @Override
    public void outputInvalid(CommandQueue commandQueue, CommandEntry commandEntry) {
        System.out.println("Invalid/unknown command: " +commandEntry.originalLine + "... -> " + commandEntry.arguments);
    }

    @Override
    public void outputError(String message) {
        System.out.println("[Error] " + message);
    }

    @Override
    public File getScriptsFolder() {
        return new File("./scripts/");
    }
}
