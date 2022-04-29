// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ManualDrive extends CommandBase {

  private DrivetrainSubsystem sub;
  private Supplier<Double> leftSide, rightSide;
  private Supplier<Boolean> slowMode;
  // private String mode = "tank";               // TODO: Other modes are "arcade" and "curvature"

  private Timer timer = new Timer();
  private double time = 0.0;

  public ManualDrive(DrivetrainSubsystem mew, Supplier<Double> leftSide, Supplier<Double> rightSide, Supplier<Boolean> slowMode) {
    this.sub = mew;
    this.leftSide = leftSide;
    this.rightSide = rightSide;
    this.slowMode = slowMode;
    addRequirements(sub);
  }

  public ManualDrive(DrivetrainSubsystem mew, Supplier<Double> leftSide, Supplier<Double> rightSide, Supplier<Boolean> slowMode, double time) {
    this.sub = mew;
    this.leftSide = leftSide;
    this.rightSide = rightSide;
    this.slowMode = slowMode;
    this.time = time;
    addRequirements(sub);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    double left = leftSide.get();
    double right = rightSide.get();
    boolean slow = slowMode.get();

    if (slow) {
      left *= 0.5;
      right *= 0.5;
    }

    System.out.println(right);
    sub.DriveTank(left, right);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return time == 0.0 ? false : timer.get() >= time;
  }
}
