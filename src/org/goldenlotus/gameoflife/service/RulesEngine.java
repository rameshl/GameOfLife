package org.goldenlotus.gameoflife.service;

import org.goldenlotus.gameoflife.vo.Cell;

import java.util.Map;

/**
 * Created by rameshl
 * Date: 11/17/11
 */
public interface RulesEngine {
    Map<String, Cell> getTickGrid();

    void setTickGrid(Map<String, Cell> tickGrid);

    void applySustenanceRule();

    void applyReproductionRule();
}
