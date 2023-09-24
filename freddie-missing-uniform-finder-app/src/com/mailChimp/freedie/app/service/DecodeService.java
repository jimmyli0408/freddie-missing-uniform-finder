package com.mailChimp.freedie.app.service;

import com.mailChimp.freedie.app.model.Grid;


public interface DecodeService {

    /**
     * Folds the grid upwards based on the given fold line number.
     */
    public void foldUp(Grid gird, int foldLineNum);

    /**
     * Folds the grid to the left based on the given fold line number.
     */
    public void foldLeft(Grid grid, int foldLineNum);
}
