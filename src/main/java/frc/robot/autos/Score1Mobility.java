// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveBackwards;
import frc.robot.commands.SpinIntakeForward;
import frc.robot.commands.StopDrive;
import frc.robot.commands.StopIntake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Score1Mobility extends SequentialCommandGroup {

  /** Creates a new Score1Mobility. */
  public Score1Mobility() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SpinIntakeForward(),
      new WaitCommand(1),
      new StopIntake()
    );
  }
}

/* ,
      new DriveBackwards(),
      new WaitCommand(1),
      new StopDrive() */