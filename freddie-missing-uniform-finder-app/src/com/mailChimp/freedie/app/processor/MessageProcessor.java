package com.mailChimp.freedie.app.processor;

import com.mailChimp.freedie.app.constant.freedieAppConstants;
import com.mailChimp.freedie.app.model.Grid;
import com.mailChimp.freedie.app.model.Pair;
import com.mailChimp.freedie.app.service.DecodeService;
import com.mailChimp.freedie.app.utils.FileParser;

import java.io.IOException;;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.mailChimp.freedie.app.constant.freedieAppConstants.BLANK;
import static com.mailChimp.freedie.app.constant.freedieAppConstants.MARKED;

public class MessageProcessor {

    private final DecodeService decodeService;
    private final FileParser fileParser;

    public  MessageProcessor(DecodeService decodeService) {
        this.decodeService = decodeService;
        this.fileParser = new FileParser();
    }

    /**
     * @param name file path to read file
     * Processes the file content:
     * 1. Reads the file lines.
     * 2. Parses the grid.
     * 3. Decodes the fold instructions.
     * 4. Print the final state of the gird.
     */
    public void process(String name) throws IOException {
        List<String> lines = fileParser.readFile(name);
        Grid grid = fileParser.parseGrid(lines);
        executeDecode(grid, lines);
        printFinalGrid(grid);
    }

    /**
     * @param lines instructions read from file
     * Executes the decoding based on the fold instructions present in the lines
     */
    private void executeDecode(Grid grid, List<String> lines) {
        lines.stream()
                .filter(line -> line.contains("fold"))
                .forEach(line -> {
                    //Decode fold instructions
                    String[] decodeValues = line.split(" ");
                    int foldNum = Integer.parseInt(decodeValues[3].split("=")[1].trim());

                    if (decodeValues[1].equals(freedieAppConstants.UP)) {
                        decodeService.foldUp(grid, foldNum);
                    }else {
                        decodeService.foldLeft(grid, foldNum);
                    }
                });
    }

    /**
     * Prints the final state of the grid.
     * An 'empty' space is represented by a blank character,
     * and a 'marked' space is represented by the MARKED character.
     */
    private void printFinalGrid(Grid grid) {
        Set<Pair> markedPoints = grid.getMarkedPoints();
        int xSize = grid.getX() + 1;
        int ySize = grid.getY() + 1;
        char[][] messageGrid = new char[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            Arrays.fill(messageGrid[i], BLANK);
        }

        for (Pair point : markedPoints) {
            int x = point.getX();
            int y = point.getY();
            try {
                messageGrid[y][x] = MARKED;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("coordinate x: " + x + "cordinate y: " + y + "is not valid");
            }
        }

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j <xSize; j++) {
                System.out.print(messageGrid[i][j]);
            }
            System.out.println();
        }

    }
}
