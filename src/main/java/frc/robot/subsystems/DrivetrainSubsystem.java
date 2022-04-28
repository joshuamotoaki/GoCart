// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

  private CANSparkMax leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor;
  private DifferentialDrive myDrive;

  public DrivetrainSubsystem() {
    leftFrontMotor = new CANSparkMax(Constants.LEFT_FRONT_MOTOR_ID, MotorType.kBrushless);
    leftRearMotor = new CANSparkMax(Constants.LEFT_REAR_MOTOR_ID, MotorType.kBrushless);
    rightFrontMotor = new CANSparkMax(Constants.RIGHT_FRONT_MOTOR_ID, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(Constants.RIGHT_REAR_MOTOR_ID, MotorType.kBrushless);

    leftFrontMotor.restoreFactoryDefaults();
    leftRearMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightRearMotor.restoreFactoryDefaults();

    leftRearMotor.follow(leftFrontMotor);
    rightFrontMotor.follow(rightRearMotor);

    enableCoastMode();

    myDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  public void enableCoastMode() {
    leftFrontMotor.setIdleMode(IdleMode.kCoast);
    leftRearMotor.setIdleMode(IdleMode.kCoast);
    rightFrontMotor.setIdleMode(IdleMode.kCoast);
    rightRearMotor.setIdleMode(IdleMode.kCoast);
  }

  public void enableBrakeMode() {
    leftFrontMotor.setIdleMode(IdleMode.kBrake);
    leftRearMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotor.setIdleMode(IdleMode.kBrake);
    rightRearMotor.setIdleMode(IdleMode.kBrake);
  }

  public void DriveArcade(double speed, double rotation) {
    myDrive.arcadeDrive(speed, rotation);
  }

  public void DriveTank(double leftSpeed, double rightSpeed) {
    myDrive.tankDrive(leftSpeed, rightSpeed);
  }

}
