package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class Arm extends Subsystem {

  public WPI_TalonSRX armMotor = RobotMap.armMotor;
  public WPI_TalonSRX jointMotor = RobotMap.jointMotor;

  public DigitalInput limitSwitchArm = RobotMap.limitSwitchArm;
  public DigitalInput limitSwitchJoint = RobotMap.limitSwitchJoint;

  public DigitalOutput LED = RobotMap.LED; 

  public Arm(){
    armMotor.setSelectedSensorPosition(0);
    jointMotor.setSelectedSensorPosition(0);

    armMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    jointMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

    // armMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    // jointMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("arm", armMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("joint", jointMotor.getSelectedSensorPosition());

    SmartDashboard.putBoolean("armlim", getArmLimitSwitch());
    SmartDashboard.putBoolean("jointLim", getArmLimitSwitch());
    

      if(jointMotor.getSensorCollection().isFwdLimitSwitchClosed()){
        LED.set(false);
        jointMotor.setSelectedSensorPosition(0);
        
      }else{
        LED.set(true);
      }

      if(armMotor.getSensorCollection().isFwdLimitSwitchClosed()){
        LED.set(false);
        armMotor.setSelectedSensorPosition(0);
        
      }else{
        LED.set(true);
      }
    }

    public void armMotorStop(){
      armMotor.set(0);
    }

    public void joingMotorStop(){
      jointMotor.set(0);
    }

  public void armMotorRunClock(){
    if(armMotor.getSensorCollection().isFwdLimitSwitchClosed() == true){
      armMotor.setSelectedSensorPosition(0);
      armMotorStop();
    }else{
      if(armMotor.getSelectedSensorPosition() < 10000){
        armMotor.set(0.15);
      }else{
        armMotor.set(0.3);
      }
      

    }
  }
  
  public void armMotorRunAntiClock(){
    if(armMotor.getSelectedSensorPosition() < 111111){
      if(armMotor.getSelectedSensorPosition() > 100000){
        armMotor.set(-0.15);
      }else{
        armMotor.set(-0.3);
      }

    }else{
      armMotorStop();
    }

  }

  public void jointMotorRunClock(){

    if(jointMotor.getSelectedSensorPosition() > -80000){
      jointMotor.set(-0.3);
    }else{
      joingMotorStop();
    }


  }

  public void jointMotorRunAntiClock(){
    if(jointMotor.getSensorCollection().isFwdLimitSwitchClosed() == true){
      jointMotor.setSelectedSensorPosition(0);
      joingMotorStop();
    }else if(jointMotor.getSelectedSensorPosition() > 500){
      jointMotor.setSelectedSensorPosition(0);
    }else{
      jointMotor.set(0.3);
    }
  }

  public boolean getJointLimitSwitch(){
    return jointMotor.getSensorCollection().isFwdLimitSwitchClosed(); 
    
  }

  public boolean getArmLimitSwitch(){
    return armMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public void armMotorRunClockSlow(){
    if(armMotor.getSensorCollection().isFwdLimitSwitchClosed() == true){
      armMotor.setSelectedSensorPosition(0);
      armMotorStop();
    }else{
      armMotor.set(0.125);

    }
  }

  public void jointMotorRunAntiClockSlow(){
    if(jointMotor.getSensorCollection().isFwdLimitSwitchClosed() == true){
      jointMotor.setSelectedSensorPosition(0);
      joingMotorStop();
    }else if(jointMotor.getSelectedSensorPosition() > 500){
      jointMotor.setSelectedSensorPosition(0);
    }else{
      jointMotor.set(0.125);
    }
  }


}
