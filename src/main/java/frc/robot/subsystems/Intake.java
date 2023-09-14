package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    public static WPI_TalonFX intake = new WPI_TalonFX(13);

    public Intake() {
        intake.configFactoryDefault();
    }

    public void periodic() {
    }

    public void IntakeCmd(double input)
    {
        boolean intakeForward = false;

        if (input > 0.1)
        {
            intakeForward = true;
        }
        else if (input < -0.1)
        {
            intakeForward = false;
        }
        else if (intakeForward)
        {
            input = 0.1;
        }
        else 
        {
            input = -0.1;
        }
        intake.set(input);
    }

    public static void SpinIntake() {
        intake.set(-.25);
    }
}


