/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands.GamePieceCollecting.CommandGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.GamePieceCollecting.ClawClose;
//import frc.robot.Commands.GamePieceCollecting.ClawClose;
import frc.robot.Commands.GamePieceCollecting.CollectorBack;
import frc.robot.Commands.GamePieceCollecting.CollectorIntake;
import frc.robot.Commands.RobotArm.PID.PID_Group.ReturnToZero;
import frc.robot.Commands.RobotArm.PID.PID_Group.SetBallGrabbingPreState;

public class GetTheBallReturnToNormalState extends CommandGroup {

  
  public GetTheBallReturnToNormalState() {
    addSequential(new SetBallGrabbingPreState(), 1);
    addParallel(new ClawClose());
    addSequential(new CollectorBack(), 0.25);
    addParallel(new ReturnToZero(), 3);
    addParallel(new CollectorIntake(), 0.05);
    addSequential(new ReturnToZero(), 0.05);
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
