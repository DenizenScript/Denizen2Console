package org.mcmonkey.denizen2console;

import org.mcmonkey.denizen2console.commands.commoncommands.QuitCommand;
import org.mcmonkey.denizen2core.Denizen2Core;
import org.mcmonkey.denizen2core.utilities.CoreUtilities;
import org.mcmonkey.denizen2core.utilities.debugging.Debug;
import org.mcmonkey.denizen2core.utilities.yaml.YAMLConfiguration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Denizen2Console {

    public final static String version;

    static {
        YAMLConfiguration config = null;
        try {
            InputStream is = Denizen2Console.class.getResourceAsStream("/denizen2console.yml");
            config = YAMLConfiguration.load(CoreUtilities.streamToString(is));
            is.close();
        }
        catch (Exception ex) {
            Debug.exception(ex);
        }
        if (config == null) {
            version = "UNKNOWN (Error reading version file!)";
        }
        else {
            version = config.getString("VERSION", "UNKNOWN") + " (build " + config.getString("BUILD_NUMBER", "UNKNOWN") + ")";
        }
    }

    public static final Object syncer = new Object();

    public static void main(String[] args) {
        Denizen2Core.init(new Denizen2ConsoleImplementation());
        Denizen2Core.register(new QuitCommand());
        Denizen2Core.load();
        System.out.println("Denizen2: SimpleConsoleImplementation, running core: " + Denizen2Core.version);
        QueueThread qt = new QueueThread();
        qt.start();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String str = buffer.readLine();
                synchronized (Denizen2Console.syncer) {
                    Denizen2Core.runString(str);
                }
            }
            catch (Exception ex) {
                Debug.exception(ex);
            }
        }
    }
}
