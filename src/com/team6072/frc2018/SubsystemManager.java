package com.team6072.frc2018;

import com.team6072.frc2018.loops.Looper;
import com.team6072.frc2018.subsystems.Subsystem;

import java.util.List;

/**
 * Used to reset, start, stop, and update all subsystems at once
 */
public class SubsystemManager {

    private final List<Subsystem> mAllSubsystems;

    public SubsystemManager(List<Subsystem> allSubsystems) {
        mAllSubsystems = allSubsystems;
    }

    public void outputToSmartDashboard() {
        mAllSubsystems.forEach((s) -> s.outputToSmartDashboard());
    }

    public void writeToLog() {
        mAllSubsystems.forEach((s) -> s.writeToLog());
    }

    public void stop() {
        mAllSubsystems.forEach((s) -> s.stop());
    }

    public void zeroSensors() {
        mAllSubsystems.forEach((s) -> s.zeroSensors());
    }

    public void registerEnabledLoops(Looper enabledLooper) {
        mAllSubsystems.forEach((s) -> s.registerEnabledLoops(enabledLooper));
    }
}
