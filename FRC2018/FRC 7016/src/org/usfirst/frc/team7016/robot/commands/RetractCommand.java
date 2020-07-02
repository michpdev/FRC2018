package org.usfirst.frc.team7016.robot.commands;


import org.usfirst.frc.team7016.robot.subsystems.RobotMovement;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RetractCommand extends Command
{
	
	public RetractCommand() {
		requires(new RobotMovement());
	}
	
	@Override
	protected boolean isFinished() 
	{
		return false;
	}
	@Override
	protected void initialize()
	{
		RobotMovement.bagMotors.set(SmartDashboard.getNumber("bagMotors", -0.8));
		RobotMovement.andyMarks.set(SmartDashboard.getNumber("andyMarks",-0.8));
		RobotMovement.pros.set(SmartDashboard.getNumber("pros", -0.8));
	}
	
	@Override
	protected void end() 
	{
		RobotMovement.bagMotors.set(0);
		RobotMovement.andyMarks.set(0);
		RobotMovement.pros.set(0);
	}
}