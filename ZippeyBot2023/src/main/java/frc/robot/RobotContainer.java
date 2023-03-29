// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Grabber m_grabber = new Grabber();
    public final Arm m_arm = new Arm();
    public final Drivetrain m_drivetrain = new Drivetrain();

// Joysticks
private final Joystick joystickRight = new Joystick(1);
private final Joystick joystickLeft = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_drivetrain);

    SmartDashboard.putNumber("Timeout", 3.0);
    SmartDashboard.putNumber("Speed", 0.3);

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Close", new Close( m_grabber ));
    SmartDashboard.putData("Open", new Open( m_grabber ));
    SmartDashboard.putData("Up", new Up( m_arm ));
    SmartDashboard.putData("Down", new Down( m_arm ));
    SmartDashboard.putData("Tank Drive: joystick", new TankDrive(getJoystickLeft(), getJoystickRight(), m_drivetrain));

    SmartDashboard.putData("Autodrive", new Autodrive(SmartDashboard.getNumber("Timeout", 0) , 
      SmartDashboard.getNumber("Speed" , 0) ,  
      m_drivetrain ));

    
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_drivetrain.setDefaultCommand(new TankDrive(getJoystickLeft(), getJoystickRight(), m_drivetrain));


    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    
    m_chooser.addOption("Kick and Run", new Up(m_arm).withTimeout(1).andThen( new Autodrive(6, 0.5, m_drivetrain)));
    m_chooser.setDefaultOption("Hit and Run", new Autodrive(0.5, 0.6, m_drivetrain).andThen( new Autodrive(6, -0.5, m_drivetrain)));
    m_chooser.addOption("Autodrive", (Command)SmartDashboard.getData("Autodrive"));
    m_chooser.addOption("Autonomous Command", new AutonomousCommand());
    m_chooser.addOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton closeButton = new JoystickButton(joystickRight, 1);        
closeButton.whileTrue(new Close( m_grabber ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton downButton = new JoystickButton(joystickRight, 2);        
downButton.whileTrue(new Down( m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton upButton = new JoystickButton(joystickRight, 3);        
upButton.whileTrue(new Up( m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        
final JoystickButton openButton = new JoystickButton(joystickLeft, 1);        
openButton.whileTrue(new Open( m_grabber ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getJoystickLeft() {
        return joystickLeft;
    }

public Joystick getJoystickRight() {
        return joystickRight;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  



}

