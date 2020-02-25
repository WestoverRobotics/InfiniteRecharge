/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Moore: Use the RobotContainer to consolidate all other classes and systems into a single area to work.

package frc.robot;

//These are imported systems, motors, and controllers from the FRC library:
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // Moore: You're pulling subsystems and commands from other areas in the code to use in the RobotContainer here.
  
  public static final XboxController m_Joystick = new XboxController(0);

  private final SimpleAuto m_autoCommand = SimpleAuto();
  private final DriveTrain m_drivetrain = new DriveTrain();
  public static final XboxController m_driveController = new XboxController(0);
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  //public static final XboxController.Axis KLEFT_AXIS;
  //public static final XboxController.Axis KRIGHT_AXIS;
  //public static final XboxController.Button RIGHT_TRIGGER_BUTTON;


  // Moore: This is where the buttons of the Xbox Controller are assigned a variable:
  Joystick joy1 = new Joystick(0);
  JoystickButton btn1 = new JoystickButton(joy1, 1);
  JoystickButton btn2 = new JoystickButton(joy1, 2);
  JoystickButton btn3 = new JoystickButton(joy1, 3);
  JoystickButton btn4 = new JoystickButton(joy1, 4);
  JoystickButton btn5 = new JoystickButton(joy1, 5);
  JoystickButton btn6 = new JoystickButton(joy1, 6);
  JoystickButton btn7 = new JoystickButton(joy1, 7);
  JoystickButton btn8 = new JoystickButton(joy1, 8);
  JoystickButton btn9 = new JoystickButton(joy1, 9);
  JoystickButton btn10 = new JoystickButton(joy1, 10);
  JoystickButton btn11 = new JoystickButton(joy1, 11);
  JoystickButton btn12 = new JoystickButton(joy1, 12);

  private SimpleAuto SimpleAuto() {
    return null;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
