package frc.robot.Subsystem.PIDsubsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

public class ArmPID extends PIDSubsystem {

  public WPI_TalonSRX armMotor = RobotMap.armMotor;
 
  public ArmPID() {

    super("ArmPID", 0, 0, 0);

  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  protected double returnPIDInput() {

    return armMotor.getSelectedSensorPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    armMotor.pidWrite(-output);
  }
}
