package org.usfirst.frc.team7016.robot.subsystems;

import org.usfirst.frc.team7016.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMovement extends Subsystem {
	private static Spark frontLeftMotor = new Spark(RobotMap.FRONT_LEFT_PWM);
	private static Spark frontRightMotor = new Spark(RobotMap.FRONT_RIGHT_MOTOR_PWM);
	private static Spark rearLeftMotor = new Spark(RobotMap.REAR_LEFT_MOTOR_PWM);
	private static Spark rearRightMotor = new Spark(RobotMap.REAR_RIGHT_MOTOR_PWM);
	
	private static Spark bagMotor1 = new Spark(RobotMap.LEFT_MECH1_MOTOR_PWM);
	private static Spark bagMotor2 = new Spark(RobotMap.LEFT_MECH2_MOTOR_PWM);
	private static Spark andyMark1 = new Spark(RobotMap.LEFT_MECH3_MOTOR_PWM);
	private static Spark pro1 = new Spark(RobotMap.LEFT_MECH4_MOTOR_PWM);
	
	private static Spark bagMotor3 = new Spark(RobotMap.RIGHT_MECH1_MOTOR_PWM);
	private static Spark bagMotor4 = new Spark(RobotMap.RIGHT_MECH2_MOTOR_PWM);
	private static Spark andyMark2 = new Spark(RobotMap.RIGHT_MECH3_MOTOR_PWM);
	private static Spark pro2 = new Spark(RobotMap.RIGHT_MECH4_MOTOR_PWM);
	
	private static SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	private static SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	public static SpeedControllerGroup bagMotors = new SpeedControllerGroup(bagMotor1,bagMotor2, bagMotor3, bagMotor4);
	public static SpeedControllerGroup andyMarks = new SpeedControllerGroup(andyMark1, andyMark2);
	public static SpeedControllerGroup pros = new SpeedControllerGroup(pro1,pro2);
	
	
	public static DifferentialDrive robot = new DifferentialDrive(leftDrive,rightDrive);
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();		
	@Override
			
	protected void initDefaultCommand() {
		//setDefaultCommand(new DriveCommand());
		
	}
	
}
