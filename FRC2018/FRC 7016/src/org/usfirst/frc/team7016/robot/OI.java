/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7016.robot;



import org.usfirst.frc.team7016.robot.commands.RetractCommand;
import org.usfirst.frc.team7016.robot.commands.ShootCommand;
import org.usfirst.frc.team7016.robot.commands.SwitchCamera;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick mainStick = new Joystick(0);
	private Button switchCamera = new JoystickButton(mainStick,RobotMap.SWITCH_CAMERA_BUTTON);
	private Button retract = new JoystickButton(mainStick, RobotMap.RETRACT_BUTTON);
	private Button shoot = new JoystickButton(mainStick, RobotMap.SHOOT_BUTTON);
public OI() {
	retract.whileHeld(new RetractCommand());
	shoot.whileHeld(new ShootCommand());
	switchCamera.whenPressed(new SwitchCamera());
}
}