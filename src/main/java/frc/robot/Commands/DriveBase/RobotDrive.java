package frc.robot.Commands.DriveBase;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RobotDrive extends Command {
  public RobotDrive() {
    requires(Robot.driveBase);
  }


  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
  //        Robot.driveBase.arcadeDrive_PercentOutput_Original(Robot.oi.logitech_F310.getRawAxis(1), -Robot.oi.logitech_F310.getRawAxis(4));
  //        Robot.driveBase.tankDrive_Velocity(Robot.oi.logitech_F310.getRawAxis(1), Robot.oi.logitech_F310.getRawAxis(5));
          Robot.driveBase.tankDrive_Velocity(-Robot.oi.cycController.getRawAxis(4), -Robot.oi.cycController.getRawAxis(1)); 
  //        Robot.driveBase.tankDrive_PercentOutput_Original(-Robot.oi.cycController.getRawAxis(4)*0.925, -Robot.oi.cycController.getRawAxis(1)*0.925);
  //        Robot.driveBase.tankDrive_PercentOutput_Original(Robot.oi.logitech_F310.getRawAxis(1)*0.95, Robot.oi.logitech_F310.getRawAxis(5)*0.95);
  }


  @Override
  protected boolean isFinished() {
    return false;
    
  }
  


  @Override
  protected void end() {
  //   Robot.driveBase.Stop_PercentOutput();
  //     Robot.driveBase.tankDrive_Velocity(0, 0);
         Robot.driveBase.Velocity_Move(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
