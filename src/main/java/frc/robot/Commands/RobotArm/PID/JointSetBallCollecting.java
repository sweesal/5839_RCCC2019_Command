/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.JointPID;

public class JointSetBallCollecting extends Command {

  private JointPID jointPID_SetCollectBall = new JointPID();

  public JointSetBallCollecting() {
    super("Joint_SetCollectBall");
    requires(jointPID_SetCollectBall);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    jointPID_SetCollectBall.setSetpoint(-67500);
    jointPID_SetCollectBall.getPIDController().setPID(0.00003, 0, 0);
    jointPID_SetCollectBall.setAbsoluteTolerance(500);
    jointPID_SetCollectBall.setOutputRange(-0.45, 0.45 );
    jointPID_SetCollectBall.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    jointPID_SetCollectBall.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return jointPID_SetCollectBall.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    jointPID_SetCollectBall.disable();
    jointPID_SetCollectBall.jointMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
