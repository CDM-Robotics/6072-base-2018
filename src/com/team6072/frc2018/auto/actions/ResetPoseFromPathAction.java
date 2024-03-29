package com.team6072.frc2018.auto.actions;

import edu.wpi.first.wpilibj.Timer;

import com.team6072.frc2018.RobotState;
import com.team6072.frc2018.paths.PathContainer;
import com.team6072.frc2018.subsystems.Drive;
import com.team6072.lib.util.math.RigidTransform2d;

/**
 * Resets the robot's current pose based on the starting pose stored in the pathContainer object.
 * 
 * @see PathContainer
 * @see Action
 * @see RunOnceAction
 */
public class ResetPoseFromPathAction extends RunOnceAction {

    protected PathContainer mPathContainer;

    public ResetPoseFromPathAction(PathContainer pathContainer) {
        mPathContainer = pathContainer;
    }

    @Override
    public synchronized void runOnce() {
        RigidTransform2d startPose = mPathContainer.getStartPose();
        RobotState.getInstance().reset(Timer.getFPGATimestamp(), startPose);
        Drive.getInstance().setGyroAngle(startPose.getRotation());
    }
}
