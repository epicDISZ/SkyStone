package org.firstinspires.ftc.teamcode;

public enum CubePositions {
    left(1000),
    middle(2500),
    right(4000),
    farLeft(5500),
    farMiddle(7000),
    farRight(8500);

    public final int value;

    private CubePositions(int value){
        this.value = value;
    }
}
