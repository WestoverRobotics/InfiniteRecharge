/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// Moore: This is where systems, motors, controller, etc are imported from FRC Libraries.

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


// Moore: This is where motor controllers are assign to motors and gearboxes.

public class DriveTrain extends SubsystemBase {
  private final VictorSP rightFront;
  private final VictorSP rightBack;
  private final VictorSP leftFront;
  private final VictorSP leftBack;
  private final DifferentialDrive m_drive;

  // Moore: This is where gearboxes and motors are grouped together.
  
  public static SpeedControllerGroup driveTrainRightMotors;
  public static SpeedControllerGroup driveTrainLeftMotors;


  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

    // Moore: Assigning motor controllers a variable and speedcontroller group.
    
    rightFront = new VictorSP(0);
    rightBack = new VictorSP(1);
    leftFront = new VictorSP(3);
    leftBack = new VictorSP(2);

    driveTrainLeftMotors = new SpeedControllerGroup(rightFront, rightBack);

    driveTrainRightMotors = new SpeedControllerGroup(leftFront, leftBack);

    m_drive = new DifferentialDrive (driveTrainRightMotors, driveTrainLeftMotors);

    m_drive.setSafetyEnabled(false);

    setDefaultCommand(new DriveManual(this));
  }

  // Moore: This is where types of drives are detailed. Multiple can be present at one time. You have to assign specific drives.
  
  public void tankdrive(double left, double right){
    m_drive.tankDrive(left, right);
  }

  public void curvatureDrive(double speed, double rotation, boolean quickturn){
    m_drive.curvatureDrive(speed, rotation, quickturn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
