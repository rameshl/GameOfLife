package org.goldenlotus.gameoflife.service;

import org.goldenlotus.gameoflife.vo.Cell;

import java.util.Map;

/**
 * Created by rameshl
 * Date: 11/17/11
 */
public interface GameService {
    Map<String,Cell> proceedToNextTick(Map<String, Cell> lifeGrid);
}
