package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;



public class Robot extends TimedRobot {


  @Override
  public void robotInit() {

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

  }


  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }


  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }
  

  @Override
  public void teleopInit() {

  }

  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();

  }
}
