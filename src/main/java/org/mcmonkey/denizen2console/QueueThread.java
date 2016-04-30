package org.mcmonkey.denizen2console;

import org.mcmonkey.denizen2core.Denizen2Core;

public class QueueThread extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Denizen2Console.syncer) {
                Denizen2Core.tick(0.05);
            }
            try {
                sleep(50);
            }
            catch (InterruptedException ex) {
                return;
            }
        }
    }
}
