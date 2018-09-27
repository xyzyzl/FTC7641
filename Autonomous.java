package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;


public class Autonomous extends LinearOpMode {
	
	private ColorSensor front;
	
	private DcMotor leftFront;
	private DcMotor rightFront;
	private DcMotor leftBack;
	private DcMotor rightBack;
	private DcMotor intake; // constantly runs
	
	@Override
	public void runOpMode() {
		leftFront = hardwareMap.get(DcMotor.class, "lf");
		rightFront = hardwareMap.get(DcMotor.class, "rf");
		leftBack = hardwareMap.get(DcMotor.class, "lb");
		rightBack = hardwareMap.get(DcMotor.class, "rb");
		front = hardwareMap.get(ColorSensor.class, "fr");
		
		front.enableLed(true);
		
		while (front.alpha() < 20) {
			double r = Math.hypot(1, 0);
			double robotAngle = 0;
			double rightX = 1;
			final double v1 = r * Math.cos(robotAngle) + rightX;
			final double v2 = r * Math.sin(robotAngle) - rightX;
			final double v3 = r * Math.sin(robotAngle) + rightX;
			final double v4 = r * Math.cos(robotAngle) - rightX;
			
			leftFront.setPower(v1);
			rightFront.setPower(v2);
			leftBack.setPower(v3);
			rightBack.setPower(v4);
		}
	}
}
