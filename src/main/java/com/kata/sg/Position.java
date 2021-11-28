package com.kata.sg;

public class Position {

    private int x;
    private int limitX;
    private int y;
    private int limitY;

    public Position(int x, int limitX, int y, int limitY) {
        this.x = x;
        this.limitX = limitX;
        this.y = y;
        this.limitY = limitY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    void moveRight() {
        if (x < limitX)
            ++x;
    }

    void moveLeft() {
        if (x > 0)
            --x;
    }

    void moveUp() {
        if (y < limitY)
            ++y;
    }

    void moveDown() {
        if (y > 0)
            --y;
    }

    public int getLimitX() {
        return limitX;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }
}
