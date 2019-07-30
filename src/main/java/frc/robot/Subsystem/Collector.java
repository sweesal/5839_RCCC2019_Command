package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Collector extends Subsystem {

  private WPI_TalonSRX collectMotor = RobotMap.collecterMotor;
  private Solenoid collectorCylinders = RobotMap.collectorCylinder;

  public Collector(){

  }

  @Override
  public void periodic() {

  }



  @Override
  public void initDefaultCommand() {

  }


    public void collectorIntakeBall(){
      collectMotor.set(0.6);
    }

    public void collectorOuttakeBall(){
      collectMotor.set(-0.6);
    }

    public void collectorStopBallMotor(){
      collectMotor.set(0);
    }

    public void collectorOut(){
      collectorCylinders.set(true);
    }

    public void collectorBack(){
      collectorCylinders.set(false);
    }

}
