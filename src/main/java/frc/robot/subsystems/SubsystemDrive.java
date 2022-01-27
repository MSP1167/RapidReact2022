/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ManualCommandDrive;

public class SubsystemDrive extends SubsystemBase {
  
  private CANSparkMax
    leftMaster,
    leftSlave,
    rightMaster,
    rightSlave;
    
  public SubsystemDrive() {
    leftMaster = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
    leftSlave = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightMaster = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
    rightSlave = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
    super.setDefaultCommand(new ManualCommandDrive());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double left, double right) {
    leftMaster.set(left);
    leftSlave.set(left);
    rightMaster.set(right);    
    rightSlave.set(right);
  }
}
