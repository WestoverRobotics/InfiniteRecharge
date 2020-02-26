/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveManual extends CommandBase {
  private final DriveTrain m_drivetrain;
  /**
   * Creates a new DriveManual.
   */
  public DriveManual(DriveTrain m_drivetrain) {
    this.m_drivetrain = m_drivetrain;
    addRequirements(m_drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  // Moore: Details of curveDrive in relation to joystick & trigger function to speed, rotation, quickturn
  @Override
  public void execute() {
  
  double speed = RobotContainer.m_driveController.getRawAxis(2) - RobotContainer.m_driveController.getRawAxis(3);
  double rotation = -RobotContainer.m_driveController.getRawAxis(0);
  boolean quickturn = speed > -0.2 && speed < 0.2;

  if( speed > -0.1 && speed < 0.1){
    speed = 0;
  }
 
  if( rotation > -0.1 && rotation <0.1){
    rotation = 0;
  }

  // Moore: Calling curveDrive from DriveTrain  
    
  m_drivetrain.curvatureDrive(speed, rotation, quickturn);

  //m_drivetain.tankDrive(RobotContainer.m_driverController.getRawAxis(1), RobotContainer.m_driveController.getRawAxis(5));
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
