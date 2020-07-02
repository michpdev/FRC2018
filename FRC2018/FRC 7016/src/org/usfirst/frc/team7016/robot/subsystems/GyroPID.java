package org.usfirst.frc.team7016.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroPID extends PIDSubsystem
{
	private static double pid = 0.0d;
	
	public GyroPID() 
	{
		super(SmartDashboard.getNumber("Proportional", 0.0d), SmartDashboard.getNumber("Integral", 0.0d), SmartDashboard.getNumber("Derivative", 0.0d));
	}

	@Override
	protected double returnPIDInput() {return RobotMovement.gyro.getAngle();}

	@Override
	protected void usePIDOutput(double output) {pid = output;}

	@Override
	protected void initDefaultCommand() {setDefaultCommand(null);}
	
	public static double getAngle() 
	{
		return pid;
	}
}