package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "ff")
public class ff extends OpMode {
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
    double i;
    double f;
    final static double SLOWING = 1.5;
    final static double POWER = 0.3;
    final static double POWER2 = 1;
    final static double EMAX = 1030;
    final static double EMIN = 50;
    @Override
    public void init() {
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
        LeftE.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftE.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightE.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    @Override
    public void loop() {
        telemetry.update();
        telemetry.addData("El",LeftE.getCurrentPosition());
if (((LeftE.getCurrentPosition() >= EMIN && -gamepad2.right_stick_y<-0.222) || ((LeftE.getCurrentPosition() <= EMAX) && -gamepad2.right_stick_y>0.222))){
    LeftE.setPower(-gamepad2.right_stick_y/4);
}else {
    LeftE.setPower(0);
}
    }
}
