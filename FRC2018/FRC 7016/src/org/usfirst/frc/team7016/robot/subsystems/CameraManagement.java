package org.usfirst.frc.team7016.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.UsbCameraInfo;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraManagement extends Subsystem
{
	public static ArrayList<UsbCamera> cameras = new ArrayList<UsbCamera>();
	public static ArrayList<CvSink> sinks = new ArrayList<CvSink>();
	
	public CameraManagement()
	{
		for(UsbCameraInfo cameraInfo: UsbCamera.enumerateUsbCameras())
		{
			cameras.add(CameraServer.getInstance().startAutomaticCapture(cameraInfo.dev));
			System.out.println(cameraInfo.dev);
		}
		
		for(UsbCamera cam: cameras)
		{
			cam.setFPS(10);
			cam.setResolution(320,240);
			sinks.add(CameraServer.getInstance().getVideo(cam));
		}
		
		for(CvSink sink: sinks) sink.setEnabled(true);
	}
	
	@Override
	protected void initDefaultCommand() {setDefaultCommand(null);}
}