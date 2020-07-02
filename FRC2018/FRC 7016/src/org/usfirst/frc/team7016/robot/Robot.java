/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7016.robot;

import edu.wpi.first.wpilibj.TimedRobot; 
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team7016.robot.commands.DriveCommand;
import org.usfirst.frc.team7016.robot.commands.Forward;
import org.usfirst.frc.team7016.robot.commands.ManageCameras;
import org.usfirst.frc.team7016.robot.subsystems.RobotMovement;

public class Robot extends TimedRobot {
	public static final RobotMovement robotMovement = new RobotMovement();
	public static OI oi;
    private Command cameraCommand;
	private Command autonomousCommand;
	private Command teleopCommand;
	private SendableChooser<Command> autonomousChooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		teleopCommand = new DriveCommand();
		cameraCommand = new ManageCameras();
		autonomousCommand = new Forward(5);
		
		SmartDashboard.putData("Auto mode", autonomousChooser);
		SmartDashboard.putNumber("bagMotors", -0.8);
		SmartDashboard.putNumber("andyMarks", -0.8);
		SmartDashboard.putNumber("pros", -0.8);
		cameraCommand.start();
	}

	@Override
	public void disabledInit() {
		//if(teleopCommand.isRunning()) teleopCommand.cancel();
		//if(autonomousCommand.isRunning()) autonomousCommand.cancel();
		if(teleopCommand != null) if(teleopCommand.isRunning()) teleopCommand.cancel();
		if(autonomousCommand != null) if(autonomousCommand.isRunning()) autonomousCommand.cancel();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		autonomousCommand = autonomousChooser.getSelected();

		if(teleopCommand != null) if(teleopCommand.isRunning()) teleopCommand.cancel();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		/*if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}*/
		if(autonomousCommand != null) if(autonomousCommand.isRunning()) autonomousCommand.cancel();
		if(teleopCommand != null) teleopCommand.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
	}
}
