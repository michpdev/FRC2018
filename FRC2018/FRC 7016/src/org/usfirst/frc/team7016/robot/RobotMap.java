/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7016.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int FRONT_LEFT_PWM = 0;
	public static final int FRONT_RIGHT_MOTOR_PWM = 2;
	public static final int REAR_LEFT_MOTOR_PWM = 1;
	public static final int REAR_RIGHT_MOTOR_PWM = 3;
	
	public static final int LEFT_MECH1_MOTOR_PWM = 4;
	public static final int LEFT_MECH2_MOTOR_PWM = 5;
	public static final int LEFT_MECH3_MOTOR_PWM = 6;		
	public static final int LEFT_MECH4_MOTOR_PWM = 7;
	
	public static final int RIGHT_MECH1_MOTOR_PWM = 8;
	public static final int RIGHT_MECH2_MOTOR_PWM = 9;
	public static final int RIGHT_MECH3_MOTOR_PWM = 10;		
	public static final int RIGHT_MECH4_MOTOR_PWM = 11;
	
	
	public static final int MAIN_JOYSTICK_INDEX = 0;
	public static final int SWITCH_CAMERA_BUTTON = 1;
	public static final int RETRACT_BUTTON = 2;
	public static final int SHOOT_BUTTON = 3;
			
}
