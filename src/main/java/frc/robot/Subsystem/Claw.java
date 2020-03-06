package frc.robot.Subsystem;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class Claw extends Subsystem {

  private CANSparkMax clawMotor = RobotMap.clawMotor;
  private Solenoid clawCylinder = RobotMap.clawCylinder;

  private CANEncoder clawEncoder = clawMotor.getEncoder();
  private CANPIDController clawPIDController;

  public DigitalInput limitSwitchLeft = RobotMap.limitSwitchBallLeft;
  public DigitalInput limitSwitchRight = RobotMap.limitSwitchBallRight;

  public boolean clawFlag = false;
  public boolean ballCollectorFlag = false;
  public boolean grabberFlag = false;

  private static final double claw_kP = 9.25e-5;
  private static final double claw_kI = 9.25e-7;
  private static final double claw_kD = 7e-6;
  
  private static final int maxRPM = 5500;


  public Claw(){
    ConfigClawMotorPID();

  }

  @Override
  public void initDefaultCommand() {
  //  setDefaultCommand(new ClawClose());

    
  }

  @Override
  public void periodic(){
    GetBallCollectorFlag();
    GetClawFlag();
    GetGrabberFlag();

    SmartDashboard.putNumber("motor_claw", clawEncoder.getVelocity());


  }

  public void ConfigClawMotorPID(){
    clawMotor.restoreFactoryDefaults();
    clawPIDController = clawMotor.getPIDController();

    clawPIDController.setP(claw_kP);
    clawPIDController.setI(claw_kI);
    clawPIDController.setD(claw_kD);

    
  }

  public boolean GetClawFlag(){
    if(Robot.oi.logitech_F310.getRawButtonPressed(8)) {
        clawFlag = clawFlag ? false : true;
    }
    return clawFlag;
  }

  public boolean GetGrabberFlag(){
    if(Robot.oi.logitech_F310.getRawButtonPressed(10)) {
        grabberFlag = grabberFlag ? false : true;
    }
    return grabberFlag;
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
      clawMotor.set(-0.5);
    }
  }

  public void clawMotorReverseFast(){
    // if(isPanelGot()){
    //   clawMotorStop();
    // }else{
    //   clawMotor.set(-0.9);
    // }
    clawMotor.set(-0.9);
  }



  public void clawMotorRun(){
    clawMotor.set(0.85);
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

  public void clawMotorRunPID(){
    clawPIDController.setReference(maxRPM*0.7, ControlType.kVelocity);

  }

  public void clawMotorReversePID(){
    clawPIDController.setReference(-maxRPM*0.8, ControlType.kVelocity);

  }

  public void clawMotorStopPID(){
    clawPIDController.setReference(0, ControlType.kVelocity);
  }

}
