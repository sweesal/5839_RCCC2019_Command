/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystem.PIDsubsystems.ArmPID;

public class ArmReturn extends Command {

  private ArmPID armPID_SetZero = new ArmPID();

  public ArmReturn() {
    super("ArmPID_SetZero");
    requires(armPID_SetZero);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    armPID_SetZero.setSetpoint(0);
    armPID_SetZero.getPIDController().setPID(0.00003, 0.00000005, 0.000025);
    armPID_SetZero.setOutputRange(-0.475, 0.475);
    armPID_SetZero.disable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    armPID_SetZero.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.arm.getArmLimitSwitch();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    armPID_SetZero.disable();
    armPID_SetZero.armMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
