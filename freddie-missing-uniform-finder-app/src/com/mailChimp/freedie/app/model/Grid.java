package com.mailChimp.freedie.app.model;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    int x;
    int y;

    Set<Pair> markedPoints;

    public Grid() {
        x = -1;
        y = -1;
        markedPoints = new HashSet<>();
    }

    public Set<Pair> getMarkedPoints() {
        return markedPoints;
    }

    public void setMarkedPoints(Set<Pair> markedPoints) {
        this.markedPoints = markedPoints;
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

    public void addMarkedPoint(Pair point) {
        this.markedPoints.add(point);
    }
}
