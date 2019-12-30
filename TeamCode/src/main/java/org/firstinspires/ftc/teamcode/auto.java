package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "auto")
public class auto extends LinearOpMode {

    private DcMotor ForRight;
    private DcMotor ForLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor RightMotor;
    private DcMotor LeftMotor;
    private DcMotor LeftE;
    private DcMotor RightE;
    private Servo Griper;
    private Servo Graple;
    private Servo Servo1;
    private Servo Servo2;
    private Servo Oner;
    private final static double POWER = 0.4;
    private final static int TICKS_PER_ROUND = 560;
    private final static int GEAR = 15;
    private final static double PI = 3.141;
    private final static int DIAMETER = 75;
    private int skyStone = 1;

    @Override
    public void runOpMode() throws InterruptedException {
        ForRight = hardwareMap.get(DcMotor.class, "ForRight");
        ForLeft = hardwareMap.get(DcMotor.class, "ForLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        RightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        LeftMotor = hardwareMap.get(DcMotor.class, "LeftMotor");
        LeftE = hardwareMap.get(DcMotor.class, "left");
        RightE = hardwareMap.get(DcMotor.class, "right");
        Griper = hardwareMap.get(Servo.class, "Griper");
        Graple = hardwareMap.get(Servo.class, "Graple");
        Servo1 = hardwareMap.get(Servo.class, "Servo1");
        Servo2 = hardwareMap.get(Servo.class, "Servo2");
        Oner = hardwareMap.get(Servo.class, "Oner");
        LeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        SetMotorPower(0);
        SetMotorsMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ForLeft.setTargetPosition(0);
        ForRight.setTargetPosition(0);
        BackRight.setTargetPosition(0);
        BackLeft.setTargetPosition(0);
        SetMotorsMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        SetMotorPower(POWER);

        while (opModeIsActive() && !gamepad1.a);

        move(1000);
        LeftMotor.setPower(-1);
        RightMotor.setPower(-1);
        int i = 0;
        while (opModeIsActive() && IsBusy()) {
            i++;
            telemetry.addData("stage1", i);
            telemetry.addData("ForRight", ForRight.getCurrentPosition());
            telemetry.addData("ForLeft", ForLeft.getCurrentPosition());
            telemetry.addData("BackRight", BackRight.getCurrentPosition());
            telemetry.addData("BackLeft", BackLeft.getCurrentPosition());
            telemetry.update();
        }
        while (opModeIsActive() && !gamepad1.a)
        move(-1000);
        LeftMotor.setPower(0);
        RightMotor.setPower(0);
    }
    private boolean IsBusy(){
        return ForLeft.isBusy() || ForRight.isBusy() || BackRight.isBusy() || BackLeft.isBusy();
    }
    private void SetMotorPower(double power) {
        ForRight.setPower(power);
        ForLeft.setPower(power);
        BackLeft.setPower(power);
        BackRight.setPower(power);
    }
    private void SetMotorsMode(DcMotor.RunMode mode) {
        ForRight.setMode(mode);
        ForLeft.setMode(mode);
        BackRight.setMode(mode);
        BackLeft.setMode(mode);
    }
    private void move(int foreword) {
        ForRight.setTargetPosition((int)(ForRight.getCurrentPosition() + foreword*TICKS_PER_ROUND/GEAR*DIAMETER*PI));
        ForLeft.setTargetPosition((int)(ForLeft.getCurrentPosition() + foreword*TICKS_PER_ROUND/GEAR*DIAMETER*PI));
        BackRight.setTargetPosition((int)(BackRight.getCurrentPosition() + foreword*TICKS_PER_ROUND/GEAR*DIAMETER*PI));
        BackLeft.setTargetPosition((int)(BackLeft.getCurrentPosition() + foreword*TICKS_PER_ROUND/GEAR*DIAMETER*PI));
    }
    private void AddToPos(int Left, int Right) {
        ForLeft.setTargetPosition(ForLeft.getCurrentPosition() + Left);
        ForRight.setTargetPosition(ForRight.getCurrentPosition() + Right);
        BackLeft.setTargetPosition(BackLeft.getCurrentPosition() + Left);
        BackRight.setTargetPosition(BackRight.getCurrentPosition() + Right);
    }
    private void AddToPos(int FL, int FR, int BL, int BR) {
        ForLeft.setTargetPosition(ForLeft.getCurrentPosition() + FL);
        ForRight.setTargetPosition(ForRight.getCurrentPosition() + FR);
        BackLeft.setTargetPosition(BackLeft.getCurrentPosition() + BL);
        BackRight.setTargetPosition(BackRight.getCurrentPosition() + BR);
    }
}