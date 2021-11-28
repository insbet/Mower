package com.kata.sg;

import java.util.List;

public class Mower {
    Position position;
    OrientationEnum orientation;

    public Mower(Position position, OrientationEnum orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public void turnRight() {
        if (OrientationEnum.N.equals(this.orientation)) {
            this.orientation = OrientationEnum.E;
        } else if (OrientationEnum.E.equals(this.orientation)) {
            this.orientation = OrientationEnum.S;
        } else if (OrientationEnum.S.equals(this.orientation)) {
            this.orientation = OrientationEnum.W;
        } else if (OrientationEnum.W.equals(this.orientation)) {
            this.orientation = OrientationEnum.N;
        }
    }

    public void turnLeft() {
        if (OrientationEnum.N.equals(this.orientation)) {
            this.orientation = OrientationEnum.W;
        } else if (OrientationEnum.E.equals(this.orientation)) {
            this.orientation = OrientationEnum.N;
        } else if (OrientationEnum.S.equals(this.orientation)) {
            this.orientation = OrientationEnum.E;
        } else if (OrientationEnum.W.equals(this.orientation)) {
            this.orientation = OrientationEnum.S;
        }
    }

    public void move() {
        if (OrientationEnum.N.equals(this.orientation)) {
            position.moveUp();
        } else if (OrientationEnum.E.equals(this.orientation)) {
            position.moveRight();
        } else if (OrientationEnum.S.equals(this.orientation)) {
            position.moveDown();
        } else if (OrientationEnum.W.equals(this.orientation)) {
            position.moveLeft();
        }
    }

    public void executeInstructions(List<DirectionEnum> directions) {
        directions.stream().forEach(d -> {
            if (DirectionEnum.A.equals(d)) {
                this.move();
            } else if (DirectionEnum.D.equals(d)) {
                this.turnRight();
            } else if (DirectionEnum.G.equals(d)) {
                this.turnLeft();
            }
        });
    }
}
