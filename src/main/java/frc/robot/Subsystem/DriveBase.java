package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.Commands.DriveBase.RobotDrive;


public class DriveBase extends Subsystem {

  public CANSparkMax leftFrontMotor = RobotMap.leftFrontMotor;
  public CANSparkMax leftMiddleMotor = RobotMap.leftMiddleMotor;
  public CANSparkMax leftRearMotor = RobotMap.leftRearMotor;
  public CANSparkMax rightFrontMotor = RobotMap.rightFrontMotor;
  public CANSparkMax rightMiddleMotor = RobotMap.rightMiddleMotor;
  public CANSparkMax rightRearMotor = RobotMap.rightRearMotor;
  
  public SpeedControllerGroup speedControllerGroupLeft = new SpeedControllerGroup(leftFrontMotor, leftMiddleMotor, leftRearMotor);
  public SpeedControllerGroup speedControllerGroupRight = new SpeedControllerGroup(rightFrontMotor, rightMiddleMotor, rightRearMotor);

  public DifferentialDrive differentialDrive = new DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight);

  public DriveBase(){

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RobotDrive());
  }

  
  @Override
  public void periodic() {

  }

  public void tankDrive_PercentOutput_Original(double inputLeft, double inputRight){

    differentialDrive.tankDrive(inputLeft, inputRight);

  }

  public void arcadeDrive_PercentOutput_Original(double inputForward, double inputTurning){

    differentialDrive.arcadeDrive(inputForward, inputTurning);
      
  }

  public void Stop_PercentOutput(){
    speedControllerGroupLeft.set(0);
    speedControllerGroupRight.set(0);
  }



}
