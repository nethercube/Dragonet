/*
 * GNU LESSER GENERAL PUBLIC LICENSE
 *                       Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 * You can view LICENCE file for details.
 *
 * @author The Dragonet Team
 */
package org.dragonet;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.dragonet.utils.Versioning;
import org.dragonet.scripts.ScriptManager;

import java.io.File;

public class DragonetServer {
	
	private final static boolean RELEASE = false;

    private static DragonetServer instance;
	
	@Getter
	public final Logger logger;

	@Getter
	private ScriptManager scriptManager;
	
	@Getter
	private boolean javascriptEnabled;
	
	@Getter
	public File pluginsDir;
	
	@Getter 
	public File scriptsDir;
	
	private org.mcstats.Metrics metrics;

    public static DragonetServer get() {
        return instance;
    }
	
	public DragonetServer() {
        instance = this;
		this.logger = LoggerFactory.getLogger("DragonetServer");
		initialize();
	}
	
	public void initialize() {
        this.logger.info("Starting Dragonet Server version " + (RELEASE ? "Release " : "") + Versioning.DRAGONET_VERSION + "... ");
        if (!RELEASE) {
            this.logger.warn("** This is a snapshot or an un-official build of Dragonet, you may expirence bugs and errors! ");
        }

		if(javascriptEnabled) {
			this.scriptManager = new ScriptManager(this);
			this.logger.info("DAPIS plugins enabled");
		}
    }
	
}
