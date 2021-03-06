/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.GamePieceCollecting;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClawMotorReverse extends Command {
  public ClawMotorReverse() {
    requires(Robot.claw);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.claw.clawMotorStop();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    if(Robot.claw.GetGrabberFlag()){
      
    }
    Robot.claw.clawMotorReverse();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.claw.isPanelGot();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.claw.clawOut();
    Robot.claw.clawMotorStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
