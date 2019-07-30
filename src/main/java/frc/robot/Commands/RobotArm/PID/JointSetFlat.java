/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.JointPID;



public class JointSetFlat extends Command {

  private JointPID joint_SetFlat = new JointPID();

  public JointSetFlat() {
    super("Joint_SetFlat");
    requires(joint_SetFlat);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    joint_SetFlat.setSetpoint(-35000);
    joint_SetFlat.getPIDController().setPID(0.0000285, 0.00000015, 0);
    joint_SetFlat.setAbsoluteTolerance(100);
    joint_SetFlat.setOutputRange(-0.35, 0.35);
    joint_SetFlat.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    joint_SetFlat.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return joint_SetFlat.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    joint_SetFlat.disable();
    joint_SetFlat.jointMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
