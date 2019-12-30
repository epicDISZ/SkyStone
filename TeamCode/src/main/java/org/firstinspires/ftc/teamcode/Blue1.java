bpackage org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name = "Blue1")
public class Blue1 extends AutoMain {

    @Override
    public void init() {
        super.init();
        autoState = AutoState.ready;
    }

    @Override
    public void loop() {
        super.loop();
        switch (autoState) {
            case ready:
                driveToCube(CubePositions.left);
                autoState = AutoState.drivingToCube;
                break;
            case drivingToCube:
                if (isMoving()) {
                    autoState = AutoState.intakeCube;
                }
        }
    }

    public void driveToCube(CubePositions cubePosition) {
        drive(1000);
        strafe(false, cubePosition.value);
    }
}
