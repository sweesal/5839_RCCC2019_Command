/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.DriveBase;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RobotDrive extends Command {
  public RobotDrive() {
    requires(Robot.driveBase);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  //      Robot.driveBase.arcadeDrive_PercentOutput_Original(Robot.oi.logitech_F310.getRawAxis(1), -Robot.oi.logitech_F310.getRawAxis(4));
    //     Robot.driveBase.tankDrive_Velocity(Robot.oi.logitech_F310.getRawAxis(1), Robot.oi.logitech_F310.getRawAxis(5));
          Robot.driveBase.tankDrive_Velocity(-Robot.oi.cycController.getRawAxis(4), -Robot.oi.cycController.getRawAxis(1)); 
   //       Robot.driveBase.tankDrive_PercentOutput_Original(-Robot.oi.cycController.getRawAxis(4)*0.65, -Robot.oi.cycController.getRawAxis(1)*0.65);
   //       Robot.driveBase.tankDrive_PercentOutput_Original(Robot.oi.logitech_F310.getRawAxis(1)*0.99, Robot.oi.logitech_F310.getRawAxis(5)*0.99);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  //  Robot.driveBase.Stop_PercentOutput();
   Robot.driveBase.tankDrive_Velocity(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
