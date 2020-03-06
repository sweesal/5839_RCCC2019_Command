/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.RobotArm.PID;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystem.PIDsubsystems.JointPID;

public class JointSetLowestBallCollectingState extends Command {

  private JointPID jointPID_SetLowestBallCollectingState = new JointPID();

  public JointSetLowestBallCollectingState() {
    super("Joint_SetLowestBallCollectingState");
    requires(jointPID_SetLowestBallCollectingState);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    jointPID_SetLowestBallCollectingState.setSetpoint(-17500);
    jointPID_SetLowestBallCollectingState.getPIDController().setPID(0.00004, 0, 0.00001);
    jointPID_SetLowestBallCollectingState.setAbsoluteTolerance(500);
    jointPID_SetLowestBallCollectingState.setOutputRange(-0.6, 0.6);
    jointPID_SetLowestBallCollectingState.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    jointPID_SetLowestBallCollectingState.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return jointPID_SetLowestBallCollectingState.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    jointPID_SetLowestBallCollectingState.disable();
    jointPID_SetLowestBallCollectingState.jointMotor.set(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
