package com.team6072.frc2018.auto.modes;

import com.team6072.frc2018.auto.AutoModeBase;
import com.team6072.frc2018.auto.AutoModeEndedException;
import com.team6072.frc2018.auto.actions.BeginShootingAction;
import com.team6072.frc2018.auto.actions.DeployIntakeAction;
import com.team6072.frc2018.auto.actions.DrivePathAction;
import com.team6072.frc2018.auto.actions.ResetPoseFromPathAction;
import com.team6072.frc2018.auto.actions.ScoreGearAction;
import com.team6072.frc2018.auto.actions.WaitAction;
import com.team6072.frc2018.paths.CenterGearToShootRed;
import com.team6072.frc2018.paths.PathContainer;
import com.team6072.frc2018.paths.StartToCenterGearRed;

/**
 * Scores the preload gear onto the center peg then shoots the 10 preloaded fuel
 * 
 * @see AutoModeBase
 */
public class CenterGearThenShootModeRed extends AutoModeBase {

    @Override
    protected void routine() throws AutoModeEndedException {
        PathContainer gearPath = new StartToCenterGearRed();
        runAction(new ResetPoseFromPathAction(gearPath));
        runAction(new DrivePathAction(gearPath));
        runAction(new DeployIntakeAction());
        runAction(new ScoreGearAction());
        runAction(new DrivePathAction(new CenterGearToShootRed()));
        runAction(new BeginShootingAction());
        runAction(new WaitAction(15));
    }
}
