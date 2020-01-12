/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import frc.robot.Subsystem.DriveBase;

/**
 * Add your docs here.
 */
public class TestContainer {
    private DriveBase drive = new DriveBase();

    public Command getAutoCommand(){
        TrajectoryConfig config = new TrajectoryConfig(maxVelocityMetersPerSecond, maxAccelerationM;
        config.setKinematics(drive.getKinematics());

        Trajectory trajectory = TrajectoryGenerator.generateTrajectory(initial, interiorWaypoints, end, config);
    
        RamseteController command = new RamseteController(

        );

        
    }

    public void reset() {
        drive.reset();
    }
}
