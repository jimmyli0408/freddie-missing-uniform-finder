package com.mailChimp.freedie.app.service;

import com.mailChimp.freedie.app.model.Grid;


public interface DecodeService {

    public void foldUp(Grid gird, int foldLineNum);

    public void foldLeft(Grid grid, int foldLineNum);
}
