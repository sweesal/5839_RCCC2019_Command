/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystem.PIDsubsystems.JointPID;

public class JointReturn extends Command {

  private JointPID joint_SetZero = new JointPID();

  public JointReturn() {
    super("Joint_SetZero");
    requires(joint_SetZero);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    joint_SetZero.setSetpoint(0);
    joint_SetZero.getPIDController().setPID(0.00006, 0, 0.000015);
    joint_SetZero.setOutputRange(-0.6, 0.6);
    joint_SetZero.setAbsoluteTolerance(500);
    joint_SetZero.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    joint_SetZero.enable();
    // if(joint_SetZero.onTarget()){
    //   Robot.arm.jointMotorRunAntiClockSlow();
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.arm.getJointLimitSwitch();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    joint_SetZero.disable();
    joint_SetZero.jointMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
