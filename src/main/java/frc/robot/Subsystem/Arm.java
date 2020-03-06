package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.*;


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

    // armMotorFreeAjust();
    // jointMotorFreeAdjust();

    SmartDashboard.putNumber("arm", armMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("joint", jointMotor.getSelectedSensorPosition());

    SmartDashboard.putBoolean("armlim", getArmLimitSwitch());
    SmartDashboard.putBoolean("jointLim", getArmLimitSwitch());
    

      if(jointMotor.getSensorCollection().isFwdLimitSwitchClosed()){
     
        jointMotor.setSelectedSensorPosition(0);
        
      }else{

      }

      if(armMotor.getSensorCollection().isFwdLimitSwitchClosed()){

        armMotor.setSelectedSensorPosition(0);
        
      }else{

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

  public void armMotorFreeAjust(){
    double ratio = 0.35;
    double inputPower = Robot.oi.logitech_F310.getRawAxis(1)*ratio;
    boolean boolA = armMotor.getSelectedSensorPosition() < 111111;
    boolean boolB = armMotor.getSensorCollection().isFwdLimitSwitchClosed();

    if(boolA== false && boolB == false){
      armMotor.set(inputPower);
    }else if(boolA == true && boolB == false){
      armMotor.set(-Math.abs(inputPower));
    }else if(boolA && boolB){
      armMotor.set(Math.abs(inputPower));
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

  public void jointMotorFreeAdjust(){
    double ratio = 0.4;
    double inputPower = -Robot.oi.logitech_F310.getRawAxis(5)*ratio;
    boolean boolA = jointMotor.getSelectedSensorPosition() > -80000;
    boolean boolB = jointMotor.getSensorCollection().isFwdLimitSwitchClosed();

    if(boolA==true && boolB == false){
      jointMotor.set(inputPower);
    }else if(boolA == false && boolB == false){
      jointMotor.set(Math.abs(inputPower));
    }else if(boolA == true && boolB == true){
      jointMotor.set(-Math.abs(inputPower));
    }else{
      joingMotorStop();
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
