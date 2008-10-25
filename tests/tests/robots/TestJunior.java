/*******************************************************************************
 * Copyright (c) 2001, 2008 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Pavel Savara
 *     - Initial implementation
 *******************************************************************************/
package robots;


import org.junit.Test;

import helpers.RobotTestBed;
import robocode.battle.events.TurnEndedEvent;
import robocode.battle.snapshot.RobotSnapshot;
import robocode.security.SecurePrintStream;
import junit.framework.Assert;


/**
 * @author Pavel Savara (original)
 */
public class TestJunior extends RobotTestBed {
	@Test
	public void run() {
		super.run();
	}

	public String getRobotNames() {
		return "testing.JuniorEvents,sample.SittingDuck";
	}

	public void onTurnEnded(TurnEndedEvent event) {
		final RobotSnapshot robot = event.getTurnSnapshot().getRobots().get(0);

		if (event.getTurnSnapshot().getTurn() == 596) {
			final String out = robot.getOutputStreamSnapshot();

			Assert.assertTrue(out.contains("robocode.BulletMissedEvent 5"));
			Assert.assertTrue(out.contains("robocode.ScannedRobotEvent 105"));
			Assert.assertTrue(out.contains("robocode.BulletHitEvent 24"));
			Assert.assertTrue(out.contains("robocode.StatusEvent 595"));
			Assert.assertTrue(out.contains("robocode.WinEvent 1"));
		}
	}
}