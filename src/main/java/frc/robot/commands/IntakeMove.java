package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Intake;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class IntakeMove extends CommandBase {    
    private Intake s_Intake;
    private DoubleSupplier forward;
    private DoubleSupplier reverse;

    public IntakeMove(Intake s_Intake, DoubleSupplier forward, DoubleSupplier reverse) {
        this.s_Intake = s_Intake;
        addRequirements(s_Intake);

        this.forward = forward;
        this.reverse = reverse;

        
    }

    @Override
    public void execute() {

        /* Get Values, Deadband*/
        double forwardVal = MathUtil.applyDeadband(forward.getAsDouble(), (Constants.stickDeadband)/2.0);
        double reverseVal = MathUtil.applyDeadband(reverse.getAsDouble(), (Constants.stickDeadband)/2.0);


        s_Intake.IntakeCmd(forwardVal * 0.3 - reverseVal * 0.3);
        /* Drive */
        // s_Swerve.drive(
        //     new Translation2d(translationVal, strafeVal).times(Constants.Swerve.maxSpeed), 
        //     rotationVal * Constants.Swerve.maxAngularVelocity, 
        //     !robotCentricSup.getAsBoolean(), 
        //     true
        // );
    }
}