/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.DriveManualCommand;
import frc.robot.util.Xbox;

public class SubsystemDrive extends Subsystem {
  /**
   * Creates a new ExampleSubsystem.
   */

  private final CANSparkMax neoDriver;

  public SubsystemDrive() {
    this.neoDriver = new CANSparkMax(Constants.DRIVE_MASTER_ID, MotorType.kBrushless);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveManualCommand());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(Joystick joystick) {
    double throttle = Xbox.RT(joystick) - Xbox.LT(joystick);
    this.neoDriver.set((throttle < -1 ? -1 : (throttle > 1 ? 1 : throttle)));
  }
}
