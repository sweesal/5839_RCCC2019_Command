/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.ArmPID;

public class ArmSetSecondStage extends Command {

  private ArmPID armPID_SetSecondStage = new ArmPID();

  public ArmSetSecondStage() {
    super("ArmPID_SetSecondStage");
    requires(armPID_SetSecondStage);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }




  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    armPID_SetSecondStage.setSetpoint(85000);
    armPID_SetSecondStage.getPIDController().setPID(0.0000085, 0.00000005, 0);
    armPID_SetSecondStage.setAbsoluteTolerance(500);
    armPID_SetSecondStage.setOutputRange(-0.45, 0.45);
    armPID_SetSecondStage.disable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    armPID_SetSecondStage.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return armPID_SetSecondStage.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    armPID_SetSecondStage.disable();
    armPID_SetSecondStage.armMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
