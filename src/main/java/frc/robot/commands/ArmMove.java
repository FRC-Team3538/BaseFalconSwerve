package frc.robot.commands;

import frc.robot.Constants;

import frc.robot.subsystems.Arm;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class ArmMove extends CommandBase {    
    private Arm s_Arm;
    private DoubleSupplier movement;

    public ArmMove(Arm s_Arm, DoubleSupplier movement) {
        this.s_Arm = s_Arm;
        addRequirements(s_Arm);

        this.movement = movement;
        
    }

    @Override
    public void execute() {

        /* Get Values, Deadband*/
        double movementVal = MathUtil.applyDeadband(movement.getAsDouble(), Constants.stickDeadband);


        s_Arm.ClawCmd(movementVal);
        /* Drive */
        // s_Swerve.drive(
        //     new Translation2d(translationVal, strafeVal).times(Constants.Swerve.maxSpeed), 
        //     rotationVal * Constants.Swerve.maxAngularVelocity, 
        //     !robotCentricSup.getAsBoolean(), 
        //     true
        // );
    }
}