// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;


public class RobotContainer {
  // Subsystems
  private final DrivetrainSubsystem myDrive = new DrivetrainSubsystem();

  // Controllers
  private XboxController cont = new XboxController(Constants.CONT_ID);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

 
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
