package frc.robot.subsystems;

import frc.robot.SwerveModule;
import frc.robot.Constants;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;

import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Arm extends SubsystemBase {
    public WPI_TalonFX claw = new WPI_TalonFX(12);

    public Arm() {
        claw.configFactoryDefault();
        claw.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 10, 15, 1));
    }
    public void periodic() {
        SmartDashboard.putNumber("Arm Current", claw.getSupplyCurrent());
        SmartDashboard.putNumber("Arm Position", claw.getSelectedSensorPosition());

    }

    public void ClawCmd(double input)
    {
        claw.set(input);
    }

    public void ClawUp()
    {
        
    }
}

