package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class AutoMain extends OpMode {
    private DcMotorEx frontLeft = null;
    private DcMotorEx rearLeft = null;
    private DcMotorEx frontRight = null;
    private DcMotorEx rearRight = null;
    private DcMotorEx leftElevator = null;
    private DcMotorEx rightElevator = null;
    private DcMotorEx leftIntake = null;
    private DcMotorEx rightIntake = null;
    AutoState autoState = AutoState.initializing;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        rearLeft = hardwareMap.get(DcMotorEx.class, "rearLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        rearRight = hardwareMap.get(DcMotorEx.class, "rearRight");
        leftElevator = hardwareMap.get(DcMotorEx.class, "leftElevator");
        rightElevator = hardwareMap.get(DcMotorEx.class, "rightElevator");
        leftIntake = hardwareMap.get(DcMotorEx.class, "leftIntake");
        rightIntake = hardwareMap.get(DcMotorEx.class, "rightIntake");
    }

    @Override
    public void loop() {
        //General telemetry stuff
        telemetry.addData("State", autoState);
        telemetry.update();
    }

    public void drive(int position) {
        addTargetPosition(frontLeft, position);
        addTargetPosition(rearLeft, position);
        addTargetPosition(frontRight, position);
        addTargetPosition(rearRight, position);
    }

    public void turn(boolean driveLeft, int position) { //TODO: (int angle)
        int sign = (driveLeft) ? 1 : -1;
        addTargetPosition(frontLeft, position * -sign);
        addTargetPosition(rearLeft, position * -sign);
        addTargetPosition(frontRight, position * sign);
        addTargetPosition(rearRight, position * sign);
    }

    public void strafe(boolean driveLeft, int position) {
        int sign = (driveLeft) ? 1 : -1;
        addTargetPosition(frontLeft, position * -sign);
        addTargetPosition(rearLeft, position * sign);
        addTargetPosition(frontRight, position * sign);
        addTargetPosition(rearRight, position * -sign);
    }

    public void diagonal(boolean driveLeft, int position) {
        int leftMult = (driveLeft) ? 1 : 0;
        int rightMult = (driveLeft) ? 0 : 1;
        addTargetPosition(frontLeft, position * rightMult);
        addTargetPosition(rearLeft, position * leftMult);
        addTargetPosition(frontRight, position * leftMult);
        addTargetPosition(rearRight, position * rightMult);
    }

    public void addTargetPosition(DcMotorEx motor, int position) {
        motor.setTargetPosition(motor.getTargetPosition() + position);
    }

    public boolean isMoving() {
        return  checkMotorTolerence(frontLeft, 10) && checkMotorTolerence(rearLeft, 10) && checkMotorTolerence(frontRight, 10) && checkMotorTolerence(rearRight, 10);
    }

    public boolean checkMotorTolerence(DcMotorEx motor, int tolerence) {
        return motor.getCurrentPosition() > motor.getTargetPosition() - tolerence && motor.getCurrentPosition() < motor.getTargetPosition() + tolerence;
    }
}
