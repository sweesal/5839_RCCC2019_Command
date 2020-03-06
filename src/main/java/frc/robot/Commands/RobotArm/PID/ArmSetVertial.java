/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.ArmPID;

public class ArmSetVertial extends Command {

  private ArmPID armPID_SetVertical = new ArmPID();

  public ArmSetVertial() {
  //  requires(Robot.armPID);
    super("ArmPID_SetVertical");
    requires(armPID_SetVertical);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  



  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    armPID_SetVertical.setSetpoint(100000);
    armPID_SetVertical.getPIDController().setPID(0.0000325, 0.0000001, 0);
    armPID_SetVertical.setAbsoluteTolerance(500);
    armPID_SetVertical.setOutputRange(-0.4875, 0.4875);
    armPID_SetVertical.disable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    armPID_SetVertical.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return armPID_SetVertical.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    armPID_SetVertical.disable();
    armPID_SetVertical.armMotor.set(0);
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
