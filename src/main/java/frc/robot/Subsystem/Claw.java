package frc.robot.Subsystem;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class Claw extends Subsystem {

  private CANSparkMax clawMotor = RobotMap.clawMotor;
  private Solenoid clawCylinder = RobotMap.clawCylinder;

  public DigitalInput limitSwitchLeft = RobotMap.limitSwitchBallLeft;
  public DigitalInput limitSwitchRight = RobotMap.limitSwitchBallRight;

  public boolean clawFlag = false;
  public boolean ballCollectorFlag = false;

  @Override
  public void initDefaultCommand() {
  //  setDefaultCommand(new ClawClose());

    
  }

  @Override
  public void periodic(){
    GetBallCollectorFlag();
    GetClawFlag();

  }

  public boolean GetClawFlag(){
    if(Robot.oi.logitech_F310.getRawButtonPressed(8)) {
        clawFlag = clawFlag ? false : true;
    }
    return clawFlag;
  }

  public boolean GetBallCollectorFlag(){
    if(Robot.oi.logitech_F310.getRawButtonPressed(5)) {
      ballCollectorFlag = ballCollectorFlag ? false : true;
    }
    return ballCollectorFlag;
  }

  public void clawMotorReverse(){
    if(isPanelGot()){
      clawMotorStop();
    }else{
      clawMotor.set(-0.6);
    }
  }

  public void clawMotorReverseFast(){
    if(isPanelGot()){
      clawMotorStop();
    }else{
      clawMotor.set(-0.9);
    }
  }

  public void clawMotorRun(){
    clawMotor.set(0.9);
  }

  public void clawMotorRunFast(){
    clawMotor.set(0.8);
  }

  public void clawMotorStop(){
    clawMotor.set(0);
  }

  public void clawOut(){
    clawCylinder.set(true);
  }

  public void clawBack(){
    clawCylinder.set(false);
  }

  public boolean isPanelGot(){
    if(limitSwitchLeft.get() == false && limitSwitchRight.get() == false){
      return true;
    }else{
      return false;
    }
  }

}
