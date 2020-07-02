package org.usfirst.frc.team7016.robot.commands;

import org.usfirst.frc.team7016.robot.subsystems.RobotMovement;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Forward extends Command
{	
	private boolean finished = false;
	private double seconds = 0.0;
	private boolean ultrasonic = false;
	
	public Forward()
	{
		requires(new RobotMovement());
		ultrasonic = true;
		seconds = 0;
	}
	
	public Forward(double secondsIn)
	{
		requires(new RobotMovement());
		seconds = secondsIn;
	}
	
	@Override
	protected void initialize()
	{
		//RobotMovement.gyro.reset();
		
		if(!ultrasonic)
			new Thread(() ->
			{
				Timer.delay(seconds * 1000);
				finished = true;
			}).start();
	}
	
	@Override
	protected void execute()
	{
		//SmartDashboard.putNumber("Gyro value (in degrees)", RobotMovement.gyro.getAngle());
		if(ultrasonic)
		{
			double leftSpeed = 0.6d, rightSpeed = 0.6d;
			
			//if()
			
			if(RobotMovement.gyro.getAngle() > 0)
			{
				leftSpeed *= RobotMovement.gyro.getAngle();
				rightSpeed *= -RobotMovement.gyro.getAngle();
			}
			else if(RobotMovement.gyro.getAngle() < 0)
			{
				leftSpeed *= -RobotMovement.gyro.getAngle();
				rightSpeed *= RobotMovement.gyro.getAngle();
			}
			
			RobotMovement.robot.tankDrive(leftSpeed, rightSpeed);
		}
		else
		{
			RobotMovement.robot.arcadeDrive(0.6d, 0/*RobotMovement.gyro.getAngle() * SmartDashboard.getNumber("Auto Turn Multiplier", 0.04d)*/);
		}
	}
	
	@Override
	protected boolean isFinished() 
	{
		if(finished) RobotMovement.robot.arcadeDrive(0, 0);
		return finished;
	}
}