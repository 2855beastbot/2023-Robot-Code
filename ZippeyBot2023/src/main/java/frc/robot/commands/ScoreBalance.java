package frc.robot.commands;
import java.lang.Character.Subset;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.autoBalance;
import frc.robot.subsystems.Drivetrain;

public class ScoreBalance extends CommandBase {
    
    private final autoBalance m_AutoBalance;
    private final Drivetrain m_Drivetrain;

    public ScoreBalance(Drivetrain drive){

        m_Drivetrain = drive;
        addRequirements(m_Drivetrain);

        m_AutoBalance = new autoBalance();
        

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        double speed = m_AutoBalance.scoreAndBalance();
        m_Drivetrain.drive(speed, speed);

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
