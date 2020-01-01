package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class gffgdrg extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
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
    @Override
    public void runOpMode(){
        ForRight = hardwareMap.get(DcMotor.class,"ForRight");
        ForLeft = hardwareMap.get(DcMotor.class,"ForLeft");
        BackRight = hardwareMap.get(DcMotor.class,"BackRight");
        BackLeft = hardwareMap.get(DcMotor.class,"BackLeft");
        RightMotor=hardwareMap.get(DcMotor.class,"RightMotor");
        LeftMotor=hardwareMap.get(DcMotor.class,"LeftMotor");
        LeftE=hardwareMap.get(DcMotor.class,"left");
        RightE=hardwareMap.get(DcMotor.class,"right");
        Griper=hardwareMap.get(Servo.class,"Griper");
        Graple=hardwareMap.get(Servo.class,"Graple");
        Servo1=hardwareMap.get(Servo.class,"Servo1");
        Servo2=hardwareMap.get(Servo.class,"Servo2");
        Oner=hardwareMap.get(Servo.class,"Oner");
        ForLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ForLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();
        ForRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ForLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        ForRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ForLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        ForRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ForLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.update();
        waitForStart();

        ForRight.setPower(0.6);
        ForLeft.setPower(0.6);
        BackRight.setPower(0.6);
        BackLeft.setPower(0.6);
        Range.clip(500,0,1000);


    }
}
