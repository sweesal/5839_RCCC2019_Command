package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.Autonomous.TestContainer;
import frc.robot.Subsystem.Arm;
import frc.robot.Subsystem.Claw;
import frc.robot.Subsystem.Collector;
import frc.robot.Subsystem.DriveBase;
import frc.robot.Subsystem.PanelTracking;
import frc.robot.Subsystem.PIDsubsystems.ArmPID;
import frc.robot.Subsystem.PIDsubsystems.JointPID;



public class Robot extends TimedRobot {

  public static Arm arm;
  public static Claw claw;
  public static Collector collector;
  public static DriveBase driveBase;
  public static ArmPID armPID;
  public static JointPID jointPID;
  public static PanelTracking panelTracking;
  public static OI oi;

  TestContainer container;


  @Override
  public void robotInit() {

    RobotMap.init();
    arm = new Arm();
    claw = new Claw();
    collector = new Collector();
    driveBase = new DriveBase();
    armPID = new ArmPID();
    jointPID = new JointPID();
    panelTracking = new PanelTracking();


    oi = new OI();

    container = new TestContainer();

  }


  @Override
  public void robotPeriodic() {
  }


  @Override
  public void disabledInit() {

  }


  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }



  @Override
  public void autonomousInit() {
    container.reset();
    container.getAutoCommand().schedule();

  }


  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {

  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }
  



  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();

  }
}
