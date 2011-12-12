package org.goldenlotus.gameoflife.service;

import org.goldenlotus.gameoflife.vo.Cell;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rameshl
 * Date: 11/16/11
 */
public class GameServiceImpl implements GameService {

    @Override
    public Map<String,Cell> proceedToNextTick(Map<String, Cell> lifeGrid){
        RulesEngine rulesEngine = new RulesEngineImpl(lifeGrid);
        rulesEngine.setTickGrid(new HashMap<String, Cell>());
        rulesEngine.applySustenanceRule();
        rulesEngine.applyReproductionRule();
        return rulesEngine.getTickGrid();
    }

}
