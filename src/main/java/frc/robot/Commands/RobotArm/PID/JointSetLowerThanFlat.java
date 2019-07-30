/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.JointPID;

public class JointSetLowerThanFlat extends Command {


  private JointPID jointPID_SetLowerThanFlat = new JointPID();



  public JointSetLowerThanFlat() {
    super("Joint_SetLowerThanFlat");
    requires(jointPID_SetLowerThanFlat);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    jointPID_SetLowerThanFlat.setSetpoint(-49500);
    jointPID_SetLowerThanFlat.getPIDController().setPID(0.00003, 0, 0);
    jointPID_SetLowerThanFlat.setAbsoluteTolerance(510);
    jointPID_SetLowerThanFlat.setOutputRange(-0.425, 0.425);
    jointPID_SetLowerThanFlat.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    jointPID_SetLowerThanFlat.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return jointPID_SetLowerThanFlat.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    jointPID_SetLowerThanFlat.disable();
    jointPID_SetLowerThanFlat.jointMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
