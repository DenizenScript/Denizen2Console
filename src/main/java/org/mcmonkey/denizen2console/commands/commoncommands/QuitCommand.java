package org.mcmonkey.denizen2console.commands.commoncommands;

import org.mcmonkey.denizen2core.commands.AbstractCommand;
import org.mcmonkey.denizen2core.commands.CommandEntry;
import org.mcmonkey.denizen2core.commands.CommandQueue;

public class QuitCommand extends AbstractCommand {

    // <--[command]
    // @Name quit
    // @Arguments
    // @Short Quits the program.
    // @Updated 2016/04/02
    // @Authors mcmonkey
    // @Group Common
    // @Minimum 0
    // @Maximum 0
    // @Description
    // Quits the program.
    // TODO: Explain more?
    // @Example
    // # This example quits the program.
    // - quit
    // @Tags
    // None.
    // -->

    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public String getArguments() {
        return "";
    }

    @Override
    public int getMinimumArguments() {
        return 0;
    }

    @Override
    public int getMaximumArguments() {
        return 0;
    }

    @Override
    public boolean isWaitable() {
        return false;
    }

    @Override
    public void execute(CommandQueue queue, CommandEntry entry) {
        System.exit(0);
    }
}
