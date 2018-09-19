package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;

public class DriveTrain extends LinearOpMode {
	// mecanum wheels
	private DcMotor leftFront;
	private DcMotor rightFront;
	private DcMotor leftBack;
	private DcMotor rightBack;
	
	public void runOpMode() {
		leftFront = hardwareMap.get(DcMotor.class, "leftFront");
		rightFront = hardwareMap.get(DcMotor.class, "rightFront");
		leftBack = hardwareMap.get(DcMotor.class, "leftBack");
		rightBack = hardwareMap.get(DcMotor.class, "rightBack");
		
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		
		// wait for the game to start !
		waitForStart();
		
		// run till the end
		while(opModeIsActive()) {
			// is now running
			telemetry.addData("Status", "Running");
			telemetry.update();
			// move the mecanums
			double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
			double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
			double rightX = gamepad1.right_stick_x;
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
