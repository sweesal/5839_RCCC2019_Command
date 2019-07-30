package frc.robot.Subsystem;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.Commands.DriveBase.RobotDrive;


public class DriveBase extends Subsystem {

  public static final int kTimeoutMs = 20;

  public static final int driveBase_kSlotID = 0;
  public static final double driveBase_kP = 5e-5;
  public static final double driveBase_kI = 8.5e-7;
  public static final double driveBase_kD = 0;
  public static final double driveBase_kIzone = 0; 
  public static final double kMaxOutput = 1;
  public static final double kMinOutput = -1;
  public static final double maxRPM = 4250;


  public CANSparkMax left_1 = RobotMap.leftFrontMotor;
  public CANSparkMax left_2 = RobotMap.leftMiddleMotor;
  public CANSparkMax left_3 = RobotMap.leftRearMotor;
  public CANSparkMax right_1 = RobotMap.rightFrontMotor;
  public CANSparkMax right_2 = RobotMap.rightMiddleMotor;
  public CANSparkMax right_3 = RobotMap.rightRearMotor;

  public CANEncoder left_1_Encoder = left_1.getEncoder();
  public CANEncoder right_1_Encoder = right_1.getEncoder();

  public CANPIDController left_1_PID = left_1.getPIDController();
  public CANPIDController right_1_PID = right_1.getPIDController();
  
  public SpeedControllerGroup speedControllerGroupLeft = new SpeedControllerGroup(left_1, left_2, left_3);
  public SpeedControllerGroup speedControllerGroupRight = new SpeedControllerGroup(right_1, right_2, right_3);

  public DifferentialDrive differentialDrive = new DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight);

  public DriveBase(){
    ConfigDriveBaseStartUpSettings();
    differentialDrive.setSafetyEnabled(false);
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

  public void tankDrive_Velocity(double leftInput, double rightInput){

    // double inputLeft = Robot.oi.logitech_F310.getRawAxis(5);
    // double inputRight =-Robot.oi.logitech_F310.getRawAxis(1);

    // double inputLeft = Robot.oi.Extreme3D_2.getRawAxis(1);
    // double inputRight = -Robot.oi.Extreme3D_1.getRawAxis(1);

    double setPointLeft = ConfigJoystickInput(leftInput);
    double setPointRight = ConfigJoystickInput(rightInput);

    left_1_PID.setReference(setPointLeft, ControlType.kVelocity);
    right_1_PID.setReference(-setPointRight, ControlType.kVelocity);


}

  public void Stop_PercentOutput(){
    speedControllerGroupLeft.set(0);
    speedControllerGroupRight.set(0);
  }

  public void ConfigDriveBaseStartUpSettings(){
    ConfigFactoryDefault();
    ConfigMasterPID();

    left_2.follow(left_1);
    left_3.follow(left_1);
    right_2.follow(right_1);
    right_3.follow(right_1);


  }

  public void ConfigFactoryDefault(){
    left_1.restoreFactoryDefaults();
    left_2.restoreFactoryDefaults();
    left_3.restoreFactoryDefaults();
    right_1.restoreFactoryDefaults();
    right_2.restoreFactoryDefaults();
    right_3.restoreFactoryDefaults();
  }

  public void ConfigMasterPID(){
    left_1_PID.setP(driveBase_kP, driveBase_kSlotID);
    left_1_PID.setI(driveBase_kI, driveBase_kSlotID);
    left_1_PID.setD(driveBase_kD, driveBase_kSlotID);

    right_1_PID.setP(driveBase_kP, driveBase_kSlotID);
    right_1_PID.setI(driveBase_kI, driveBase_kSlotID);
    right_1_PID.setD(driveBase_kD, driveBase_kSlotID);
  }

  public double ConfigJoystickInput(double input){

    if(Math.abs(input) > 0.1){
      return input*input*input*maxRPM;
    }else if(Math.abs(input) > 1.001){
      return maxRPM;
    }else{
      return 0;
    }

  }

    public static double prevLeftVelocity, prevRightVelocity;
    public static double maxLeftVelocity, maxRightVelocity;

    public static double prevLeftAccel, prevRightAccel;
    public static double maxLeftAccel, maxRightAccel;

    public static double prevRightJerk, prevLeftJerk;
    public static double maxRightJerk, maxLeftJerk;

    public static double leftDistance = 0;
    public static double rightDistance = 0;

    public Timer maxVelAccelTimer;

    public void MovementRecorderInit(){

      maxVelAccelTimer = new Timer();

      maxVelAccelTimer.reset();
      maxVelAccelTimer.start();
      

      prevLeftVelocity = 0;
      prevRightVelocity = 0;
      maxLeftVelocity = 0;
      maxRightVelocity = 0;
      prevLeftAccel = 0;
      prevRightAccel = 0;
          

      maxLeftAccel = 0;
      maxRightAccel = 0;


      maxRightJerk = 0;
      maxLeftJerk = 0;
          
  }



  public void ResetDistance(){

      leftDistance = 0;
      rightDistance = 0;

    }


  public void VelAccel(){

   // double distance = 0;
        
    double leftMpS = EncoderToMs(left_1_Encoder.getVelocity(), 6);
    double rightMpS = EncoderToMs(right_1_Encoder.getVelocity(), 6);
      

  double leftAccel = 0;
  double rightAccel = 0;

  double rightJerk = 0;
  double leftJerk = 0;
      


  if(maxVelAccelTimer.get()>.02)
  {

    leftDistance = leftDistance + leftMpS;
    rightDistance =  rightDistance + rightMpS;
      
    prevLeftVelocity = leftMpS;
    prevRightVelocity = rightMpS;
  

    leftAccel = (leftMpS - prevLeftVelocity) / .02;
    rightAccel = (rightMpS - prevRightVelocity) / .02;

    leftJerk = (leftAccel - prevLeftAccel) / .02;
    rightJerk = (rightAccel - prevRightAccel) / .02;

    leftDistance = leftDistance + leftMpS;
    rightDistance =  rightDistance + rightMpS;



          if(leftAccel > maxLeftAccel)
          {
      // If current bigger than max, set max to current
            maxLeftAccel = leftAccel;
          }
          if(rightAccel > maxRightAccel)
          {
      // If current bigger than max, set max to current
            maxRightAccel = rightAccel;
          }

          if(leftJerk > maxLeftJerk)
          {
            maxLeftJerk = leftJerk;
          }
          if(rightJerk > maxRightJerk)
          {
            maxRightJerk = rightJerk;
          }
    
        }

        SmartDashboard.putNumber("accelLeftMax", maxLeftAccel);
        SmartDashboard.putNumber("accelRightMax", maxRightAccel);
        SmartDashboard.putNumber("jerkLeftMax", maxLeftJerk);
        SmartDashboard.putNumber("jerkRightMax", maxRightJerk);

        SmartDashboard.putNumber("accelLeft", leftAccel);
        SmartDashboard.putNumber("accelRight", rightAccel);
        SmartDashboard.putNumber("jerkLeft", leftJerk);
        SmartDashboard.putNumber("jerkRight", rightJerk);

        prevLeftVelocity = leftMpS;
        prevRightVelocity = rightMpS;

        prevLeftAccel = leftAccel;
        prevRightAccel = rightAccel;


  }

  public double EncoderToMs(double encoderVal, double wheelRadius){

    return Math.abs(encoderVal) / .1  / 6000 * .0254 * wheelRadius * Math.PI * 2;
    
  }



}
