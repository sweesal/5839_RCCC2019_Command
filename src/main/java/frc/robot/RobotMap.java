package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class RobotMap {

    public static CANSparkMax leftFrontMotor;
    public static CANSparkMax leftMiddleMotor;
    public static CANSparkMax leftRearMotor;
    public static CANSparkMax rightFrontMotor;
    public static CANSparkMax rightMiddleMotor;
    public static CANSparkMax rightRearMotor;
    public static CANSparkMax clawMotor;

    public static WPI_TalonSRX armMotor;
    public static WPI_TalonSRX jointMotor;
    public static WPI_TalonSRX collecterMotor;

    public static DigitalInput armLimitSwitch;
    public static DigitalInput jointLimitSwitch;
    
    public static DigitalInput limitSwitchArm;
    public static DigitalInput limitSwitchJoint;
    public static DigitalInput limitSwitchBallLeft;
    public static DigitalInput limitSwitchBallRight;
    public static DigitalOutput LED;

    public static Solenoid clawCylinder;
    public static Solenoid collectorCylinder;

    public static PowerDistributionPanel pdp;

    public static void init(){

        leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);//invert
        leftMiddleMotor = new CANSparkMax(2, MotorType.kBrushless);//invert
        leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);//invert
    //    leftRearMotor.setInverted(true);
        rightFrontMotor = new CANSparkMax(4, MotorType.kBrushless);
        rightMiddleMotor = new CANSparkMax(5, MotorType.kBrushless);
        rightRearMotor = new CANSparkMax(6, MotorType.kBrushless);

        // leftFrontMotor.setInverted(true);
        // leftMiddleMotor.setInverted(true);
        // leftRearMotor.setInverted(true);

        clawMotor = new CANSparkMax(7, MotorType.kBrushless);

        armMotor = new WPI_TalonSRX(8);
        jointMotor = new WPI_TalonSRX(9);
        jointMotor.setInverted(true);
        SmartDashboard.putData("arm8", armMotor);
        SmartDashboard.putNumber("joint9", jointMotor.getSelectedSensorPosition());
        collecterMotor = new WPI_TalonSRX(10);

        LED = new DigitalOutput(0);
       // LED.set(false);
        //LED.enablePWM(0);
        
        limitSwitchArm = new DigitalInput(3);
        limitSwitchJoint = new DigitalInput(4);
        limitSwitchBallLeft = new DigitalInput(1);
        limitSwitchBallRight = new DigitalInput(2);

        clawCylinder = new Solenoid(20, 1);
        collectorCylinder = new Solenoid(20, 2);

        pdp = new PowerDistributionPanel(0);

        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
        camera.setConnectionStrategy(ConnectionStrategy.kAutoManage);
        camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 30);

    }


    public static void ConfigSmartDashBooardDisplay(){

    }
    
}
