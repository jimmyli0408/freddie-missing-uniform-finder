package com.mailChimp.freedie.app.utils;

import com.mailChimp.freedie.app.model.Grid;
import com.mailChimp.freedie.app.model.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileParser {

    /**
     * Reads all the lines from the given file.
     * @param fileName - Path to the file to be read.
     * @return List of strings, each representing a line from the file.
     */
    public List<String> readFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    /**
     * Parses the grid based on the provided lines:
     * 1. Skips lines with fold instructions.
     * 2. Processes non-empty lines to determine marked points.
     * @param lines - List of strings from the file.
     * @return Grid object representing the parsed state.
     */
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
