package frc.robot.Subsystem.PIDsubsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;


public class JointPID extends PIDSubsystem {

  public WPI_TalonSRX jointMotor = RobotMap.jointMotor;

  public JointPID() {
    super("JointPID", 0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
  }

  @Override
  protected double returnPIDInput() {
    return jointMotor.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    jointMotor.pidWrite(output);
  }
}
