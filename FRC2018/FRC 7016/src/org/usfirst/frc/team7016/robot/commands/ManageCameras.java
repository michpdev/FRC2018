package org.usfirst.frc.team7016.robot.commands;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team7016.robot.subsystems.CameraManagement;

import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

public class ManageCameras extends Command
{
	private CvSource drain;
	private Mat source, output;
	
	public ManageCameras()
	{
		drain = CameraServer.getInstance().putVideo("hey guys video here", 320, 240);
	}
	
	@Override
	protected boolean isFinished() {return false;}
	
	@Override
	protected void initialize()
	{
		drain.setFPS(10);
		drain.setResolution(320, 240);
	}
	
	@Override
	protected void execute()
	{
		CameraManagement.sinks.get(SwitchCamera.currentCamera).grabFrame(source);
		if(!source.empty())
		{
			Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
			drain.putFrame(output);
		}
		else System.err.println("Camera Error: Image was empty!");
	}
}