package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.GamePieceCollecting.ClawClose;
import frc.robot.Commands.GamePieceCollecting.ClawMotorReverse;
import frc.robot.Commands.GamePieceCollecting.ClawMotorRun;
import frc.robot.Commands.GamePieceCollecting.ClawOpen;
import frc.robot.Commands.GamePieceCollecting.ClawOperating;
import frc.robot.Commands.GamePieceCollecting.CollectorBack;
import frc.robot.Commands.GamePieceCollecting.CollectorIntake;
import frc.robot.Commands.GamePieceCollecting.CollectorOut;
import frc.robot.Commands.GamePieceCollecting.CollectorOuttake;
import frc.robot.Commands.GamePieceCollecting.CommandGroup.CollectBall;
import frc.robot.Commands.GamePieceCollecting.CommandGroup.GetPanel;
import frc.robot.Commands.GamePieceCollecting.CommandGroup.GetTheBallReturnToNormalState;
import frc.robot.Commands.GamePieceCollecting.CommandGroup.GrabTheBallOnTheField;
import frc.robot.Commands.RobotArm.ArmMotorRunAntiClock;
import frc.robot.Commands.RobotArm.ArmMotorRunClock;
import frc.robot.Commands.RobotArm.JointMotorRunAntiClock;
import frc.robot.Commands.RobotArm.JointMotorRunClock;
import frc.robot.Commands.RobotArm.PID.ArmReturn;
import frc.robot.Commands.RobotArm.PID.ArmSetFlat;
import frc.robot.Commands.RobotArm.PID.ArmSetSecondStage;
import frc.robot.Commands.RobotArm.PID.JointReturn;
import frc.robot.Commands.RobotArm.PID.JointSetBallCollecting;
import frc.robot.Commands.RobotArm.PID.JointSetFlat;
import frc.robot.Commands.RobotArm.PID.PID_Group.BallGrabbing;
import frc.robot.Commands.RobotArm.PID.PID_Group.RetrunGrabState;
import frc.robot.Commands.RobotArm.PID.PID_Group.SetBallGrabbingPreState;
import frc.robot.Commands.RobotArm.PID.PID_Group.SetSecondStagePanel;

public class OI {

    public Joystick logitech_F310;
    public JoystickButton leftFrontButton;
    public JoystickButton rightFrontButton;
    public JoystickButton leftMiddleButton;
    public JoystickButton rightMiddleButton;
    public JoystickButton redButton;
    public JoystickButton yellowButton;
    public JoystickButton blueButton;
    public JoystickButton greenButton;
    public JoystickButton axisLeftButton;
    public JoystickButton axisRightButton;

    public OI(){

        logitech_F310 = new Joystick(0);

        leftFrontButton = new JoystickButton(logitech_F310, 5);
        rightFrontButton = new JoystickButton(logitech_F310, 6);
        leftMiddleButton = new JoystickButton(logitech_F310, 7);
        rightMiddleButton = new JoystickButton(logitech_F310, 8);
        redButton = new JoystickButton(logitech_F310, 2);
        yellowButton = new JoystickButton(logitech_F310, 4);
        blueButton = new JoystickButton(logitech_F310, 3);
        greenButton = new JoystickButton(logitech_F310, 1);
        axisLeftButton = new JoystickButton(logitech_F310, 9);
        axisRightButton = new JoystickButton(logitech_F310, 10);




        yellowButton.whileHeld(new ArmMotorRunAntiClock());
        greenButton.whileHeld(new ArmMotorRunClock());

        redButton.whileHeld(new JointMotorRunAntiClock());
        blueButton.whileHeld(new JointMotorRunClock());

        leftFrontButton.whenPressed(new BallGrabbing());
        rightFrontButton.whenPressed(new GetTheBallReturnToNormalState());

        // leftMiddleButton.whileHeld(new ClawMotorRun());
        // rightMiddleButton.whileHeld(new ClawMotorReverse());

        leftMiddleButton.whileHeld(new RetrunGrabState());
        rightMiddleButton.whileHeld(new ClawOperating());


        // axisLeftButton.whileHeld(new ArmSetFlat());
        // axisRightButton.whileHeld(new JointSetFlat());

        axisLeftButton.whileHeld(new ClawMotorRun());
        axisRightButton.whenPressed(new ClawMotorReverse());




        SmartDashboard.putData(new ArmMotorRunClock());
        SmartDashboard.putData(new ArmMotorRunAntiClock());
        SmartDashboard.putData(new JointMotorRunClock());
        SmartDashboard.putData(new JointMotorRunAntiClock());

        SmartDashboard.putData(new ClawMotorRun());
        SmartDashboard.putData(new ClawMotorReverse());

        SmartDashboard.putData(new ClawOpen());
        SmartDashboard.putData(new ClawClose());

        SmartDashboard.putData(new CollectorIntake());
        SmartDashboard.putData(new CollectorOuttake());

        SmartDashboard.putData(new CollectorOut());
        SmartDashboard.putData(new CollectorBack());

    
        
    }


    public Joystick returnLogicollDualAction(){
        return logitech_F310;
    }
    
}
