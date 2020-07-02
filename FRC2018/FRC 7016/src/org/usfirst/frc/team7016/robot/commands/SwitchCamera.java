package org.usfirst.frc.team7016.robot.commands;



import org.usfirst.frc.team7016.robot.subsystems.CameraManagement;

import edu.wpi.first.wpilibj.command.Command;

public class SwitchCamera extends Command
{
	public static int currentCamera = 0;

	@Override
	protected void initialize()
	{
		if(currentCamera <= CameraManagement.cameras.size()) currentCamera++;
		else currentCamera = 0;
	}
	
	@Override
	protected boolean isFinished() {return true;}
}