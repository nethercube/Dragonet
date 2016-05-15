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

public class Dragonet {
	
	private final static boolean RELEASE = false;
	
	@Getter
	private final Logger logger;
	
	@Getter
	private boolean javascriptEnabled;
	
	@Getter
	private File pluginsDir;
	
	@Getter 
	private File scriptsDir;
	
	private org.mcstats.Metrics metrics;
	
	public Dragonet(Server server) {
		this.logger = LoggerFactory.getLogger("Dragonet");
		initialize();
	}
	
	public void initialize() {
		this.logger.info("Starting Dragonet Server version " + (RELEASE ? "Release " : "") + Versioning.DRAGONET_VERSION + "... ");
        if (!RELEASE) {
            this.logger.warn("** This is a snapshot or an un-official build of Dragonet, you may expirence bugs and errors! ");
        }
		
		if (!pluginsDir.exists()) {
            this.pluginsDir = new File("plugins/").mkdirs();
        }
		if(!scriptsDir.exists()) {
			this.scriptsDir = new File("scripts/").mkdirs();
		}
	}
	
}
