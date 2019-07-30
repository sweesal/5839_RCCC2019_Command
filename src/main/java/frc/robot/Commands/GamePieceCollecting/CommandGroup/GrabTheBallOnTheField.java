/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.GamePieceCollecting.CommandGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.GamePieceCollecting.ClawMotorRunFast;
import frc.robot.Commands.GamePieceCollecting.ClawOpen;
import frc.robot.Commands.GamePieceCollecting.CollectorIntake;
import frc.robot.Commands.GamePieceCollecting.CollectorOut;
import frc.robot.Commands.RobotArm.PID.ArmReturn;
import frc.robot.Commands.RobotArm.PID.JointSetBallCollecting;


public class GrabTheBallOnTheField extends CommandGroup {
  /**
   * Add your docs here.
   */
  public GrabTheBallOnTheField() {

    addSequential(new ClawOpen(), 0.3);
    addSequential(new CollectorOut(), 0.3);
    addParallel(new ArmReturn());
    addParallel(new ClawMotorRunFast());
    addParallel(new JointSetBallCollecting());
    addParallel(new CollectorIntake());
    
    // if(RobotMap.jointMotor.getSelectedSensorPosition() > -15000 || RobotMap.armMotor.getSelectedSensorPosition() > 35000){
    //   addSequential(new SetBallGrabbingPreState(), 1.25);
    //   addSequential(new CollectorOut(), 0.5);
    //   addParallel(new ArmReturn(), 0.25);
    //   addParallel(new ClawMotorRun());
    //   addParallel(new JointSetBallCollecting());
    //   addParallel(new CollectorIntake());
    // }else{
    //   addSequential(new CollectorOut());
    //   addParallel(new ArmReturn(), 0.25);
    //   addParallel(new ClawMotorRun());
    //   addParallel(new JointSetBallCollecting());
    //   addParallel(new CollectorIntake());
    // }

    


    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
