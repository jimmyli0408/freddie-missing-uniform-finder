package com.mailChimp.freedie.app.utils;

import com.mailChimp.freedie.app.model.Grid;
import com.mailChimp.freedie.app.model.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileParser {

    public List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public Grid parseGrid(List<String> lines) {
        Grid grid = new Grid();

        lines.stream()
                .filter(line -> !line.contains("fold") && !line.isEmpty())
                .forEach(line -> {
                    String[] values = line.split(",");
                    int curX = Integer.parseInt(values[0].split("=")[1].trim());
                    int curY = Integer.parseInt(values[1].split("=")[1].trim());
                    grid.addMarkedPoint(new Pair(curX, curY));
                    grid.setX(Math.max(grid.getX(), curX));
                    grid.setY(Math.max(grid.getY(), curY));
                });

        return grid;
    }
}
