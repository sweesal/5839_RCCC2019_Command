/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.ArmPID;

public class ArmSetFlat extends Command {
  //It's not flat, it's up a little bit!

  private ArmPID armPID_SetFlat = new ArmPID();

  public ArmSetFlat() {
    super("ArmPID_SetFlat");
    requires(armPID_SetFlat);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    armPID_SetFlat.setSetpoint(73000);
    armPID_SetFlat.getPIDController().setPID(0.0000325, 0, 0);
    armPID_SetFlat.setAbsoluteTolerance(500);
    armPID_SetFlat.setOutputRange(-0.425, 0.425);
    armPID_SetFlat.disable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    armPID_SetFlat.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return armPID_SetFlat.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    armPID_SetFlat.disable();
    armPID_SetFlat.armMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
