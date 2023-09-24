package com.mailChimp.freedie.app.service.Impl;

import com.mailChimp.freedie.app.model.Grid;
import com.mailChimp.freedie.app.model.Pair;
import com.mailChimp.freedie.app.service.DecodeService;

import java.util.HashSet;
import java.util.Set;

public class FoldServiceImpl implements DecodeService {

    @Override
    public void foldUp(Grid grid, int foldLineNum) {

        int maxY = grid.getY();
        foldProcess(grid, foldLineNum, maxY, true);
    }

    @Override
    public void foldLeft(Grid grid, int foldLineNum) {

        int maxX = grid.getX();;
        foldProcess(grid, foldLineNum, maxX, false);
    }

    private void foldProcess(Grid grid, int foldLineNum, int maxCord, boolean isUp) {
        Set<Pair> markedPoints = grid.getMarkedPoints();
        Set<Pair> foldedPoints = new HashSet<>();
        int lineNotOverlapped = ((maxCord - foldLineNum) - 1) - (foldLineNum - 1);

        for (Pair point : markedPoints) {

            int preX = point.getX();
            int preY = point.getY();

            if (isUp) {

                if (preY > foldLineNum) {
                    if (lineNotOverlapped < 0) {
                        int lineStart = -lineNotOverlapped;
                        foldedPoints.add(new Pair(preX, lineStart + (maxCord - preY)));
                    }else {
                        foldedPoints.add(new Pair(preX, maxCord - preY));
                    }
                }else {

                    if (lineNotOverlapped > 0) {
                        foldedPoints.add(new Pair(preX, preY + lineNotOverlapped));
                    } else {
                        foldedPoints.add(point);
                    }
                }
            }else {

                if (preX > foldLineNum) {
                    if (lineNotOverlapped < 0) {
                        int lineStart = -lineNotOverlapped;
                        foldedPoints.add(new Pair(lineStart + (maxCord - preX), preY));
                    }else {
                        foldedPoints.add(new Pair(maxCord - preX, preY));
                    }
                }else {
                    if (lineNotOverlapped > 0) {
                        foldedPoints.add(new Pair(preX + lineNotOverlapped, preY));
                    } else {
                        foldedPoints.add(point);
                    }
                }
            }
        }

        grid.setMarkedPoints(foldedPoints);

        int newSize = Math.max(foldLineNum - 1, maxCord - foldLineNum - 1);

        if (isUp) {
            grid.setY(newSize);
        }else {
            grid.setX(newSize);
        }

    }

}
