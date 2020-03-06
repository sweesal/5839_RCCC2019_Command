package frc.robot.Subsystem.PIDsubsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveBasePID extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public DriveBasePID() {
    // Intert a subsystem name and PID values here
    super("DriveBasePID", 0, 0, 0);

  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  protected double returnPIDInput() {
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {

  }
}
