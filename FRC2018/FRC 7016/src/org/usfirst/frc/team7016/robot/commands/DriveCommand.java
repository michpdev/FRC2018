package org.usfirst.frc.team7016.robot.commands;

import org.usfirst.frc.team7016.robot.OI;
import org.usfirst.frc.team7016.robot.subsystems.RobotMovement;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command
{
	private final double MINIMUM_SPEED = 0.5d;
	private final double MAXIMUM_SPEED = 1.0d;
	
	private double speedMultiplier = 0.0;
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
@Override
protected void execute()
{
	speedMultiplier = (((-OI.mainStick.getRawAxis(3) + 1) / 2) * (MAXIMUM_SPEED - MINIMUM_SPEED)) + MINIMUM_SPEED;
	RobotMovement.robot.arcadeDrive(-OI.mainStick.getRawAxis(1) * speedMultiplier, OI.mainStick.getRawAxis(0) * speedMultiplier * 0.85);
	System.out.println("speedMultiplier: "+speedMultiplier+"\nmainStick.getRawAxis(1): "+OI.mainStick.getRawAxis(1));
}
	
}
