package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final PS4Controller theactualgoodone = new PS4Controller(0);
    private final PS4Controller operator = new PS4Controller(1);
   

    /* Drive Controls */
    private final int translationAxis = PS4Controller.Axis.kLeftY.value;       //XboxController.Axis.kLeftY.value;
    private final int strafeAxis = PS4Controller.Axis.kLeftX.value;
    private final int rotationAxis = PS4Controller.Axis.kRightX.value;
   
    private final int clawAxis = PS4Controller.Axis.kRightY.value;
    private final int forwardAxis = PS4Controller.Axis.kR2.value;
    private final int reverseAxis = PS4Controller.Axis.kL2.value;
  

    /* Driver Buttons */
 //   private final JoystickButton intakeforward = new JoystickButton(driver, PS4Controller.Button.kR2.value);


    private final JoystickButton zeroGyro = new JoystickButton(driver, PS4Controller.Button.kOptions.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, PS4Controller.Button.kL1.value);
    private final JoystickButton snipermode = new JoystickButton(driver, PS4Controller.Button.kR1.value);
    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final Arm s_Arm = new Arm();
    private final Intake s_Intake = new Intake();

    public double translation = -theactualgoodone.getRawAxis(translationAxis);
    public double strafe = -theactualgoodone.getRawAxis(strafeAxis);
    public double rotation = -theactualgoodone.getRawAxis(rotationAxis);

    public double claw = operator.getRawAxis(clawAxis);
    public double intakeforward = operator.getRawAxis(forwardAxis);
    public double intakereverse = operator.getRawAxis(reverseAxis);
   
  //  public double clawmove = operator.getRawAxis(clawAxis);
//    public double intake_forward = operator.getRawAxis(intakeforward.);
 //   public double intake_reverse = operator.getRawAxis(intakereverse);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        

        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -theactualgoodone.getRawAxis(translationAxis) * 1.0, 
                () -> -theactualgoodone.getRawAxis(strafeAxis) * 1.0, 
                () -> -theactualgoodone.getRawAxis(rotationAxis) * 1.0, 
                () -> robotCentric.getAsBoolean()
            )
        );
 
        s_Arm.setDefaultCommand(new ArmMove(s_Arm, () -> operator.getRawAxis(clawAxis) * 0.7));

        s_Intake.setDefaultCommand(new IntakeMove(s_Intake, () -> operator.getRawAxis(forwardAxis), () -> operator.getRawAxis(reverseAxis)));

        // Configure the button bindings
        configureButtonBindings();

    }

    /**^
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));

        // intakeforward.onTrue(new InstantCommand(() -> s_Arm.IntakeCmd());
        // new InstantCommand(() -> s_Arm.ClawCmd(clawmove * 0.2));
        // // new InstantCommand(() -> s_Arm.IntakeCmd((intake_forward - intake_reverse) * 0.2));
        // //s_Arm.setDefaultCommand(s_Arm.ClawCmd(clawmove));
        // s_Arm.IntakeCmd(intake_forward - intake_reverse);
        // s_Arm.ClawCmd(clawmove);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return new exampleAuto(s_Swerve);
    }
}
