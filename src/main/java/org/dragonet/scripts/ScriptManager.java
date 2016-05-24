package org.dragonet.scripts;

import org.dragonet.DragonetServer;

import java.io.File;

public class ScriptManager {

    private DragonetServer server;

    public ScriptManager(DragonetServer server) {
        this.server = server;
    }

    public void loadScripts() {
        File dir =  server.scriptsDir;

        if(!dir.isDirectory()) {
            try {
                if(!dir.mkdir()) {
                    server.logger.warn("COULDN'T CREATE SCRIPTS DIRECTORY");
                    server.logger.info("Please create it yourself.");
                }
            } catch(Exception e) { e.printStackTrace(); }
        }
    }

}
