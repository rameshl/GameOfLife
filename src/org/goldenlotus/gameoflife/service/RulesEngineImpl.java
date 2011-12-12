package org.goldenlotus.gameoflife.service;

import org.goldenlotus.gameoflife.utils.GameUtils;
import org.goldenlotus.gameoflife.vo.Cell;

import java.util.*;

/**
 * Created by rameshl
 * Date: 11/16/11
 */
public class RulesEngineImpl implements RulesEngine {

    private Map<String,Cell> seedGrid;
    private Map<String,Cell> tickGrid;

    private final int ORTHOGONAL_LIMIT = 8;

    public Map<String, Cell> getTickGrid() {
        return tickGrid;
    }

    public void setTickGrid(Map<String, Cell> tickGrid) {
        this.tickGrid = tickGrid;
    }

    public RulesEngineImpl(Map<String, Cell> newGrid){
        this.seedGrid = newGrid;
    }

    public void applySustenanceRule(){
        Set<String> keySet = seedGrid.keySet();
        Cell aCell = null;
        for(String key : keySet){
            if(seedGrid.containsKey(key)){
                aCell = seedGrid.get(key);
                int aliveCount = getCountOfLivingNeighbors(aCell);
                if(aliveCount >= 2 && aliveCount <= 3){
                    tickGrid.put(key, aCell);
                }
            }
        }
    }

    public void applyReproductionRule(){
        Set<Cell> reprodCells = findCandidatesForReproduction();
        Cell newCell = null;
        String key = null;
        for(Cell eachDeadCell : reprodCells){
            int livingNeighborCount = getCountOfLivingNeighbors(eachDeadCell);
            if(livingNeighborCount == 3){
                eachDeadCell.setCellAlive(true);
                key = GameUtils.buildKeyString(eachDeadCell.getCoordX(), eachDeadCell.getCoordY(), 0);
                tickGrid.put(key, eachDeadCell);
            }
        }
    }

    private Set<Cell> findCandidatesForReproduction(){
        Set<Cell> deadCells = new HashSet<Cell>();
        Cell eachCell = null, neighborCell = null;
        List<String> neighborsList = null;

        for(String key : seedGrid.keySet()){
            if(seedGrid.containsKey(key)){
                eachCell = seedGrid.get(key);
                neighborsList = findNeighborsForCell(eachCell);
                for(String neighborKey : neighborsList){
                    neighborCell = GameUtils.populateCellCoordinates(neighborKey);
                    neighborCell.setCellAlive(false);
                    try{
                        deadCells.add(neighborCell);
                    }catch(Exception ignoreException){}
                }
            }
        }
        return deadCells;
    }

    private int getCountOfLivingNeighbors(Cell aCell){
        int aliveCount = 0;
        List<String> neighborsList = findNeighborsForCell(aCell);
        for(String neighbor : neighborsList){
            if(seedGrid.containsKey(neighbor)){
                aliveCount++;
            }
        }
        return aliveCount;
    }

    private List<String> findNeighborsForCell(Cell aCell){
        List<String> neighborsOfCell = new ArrayList<String>();

        for(int loop = 1; loop<= ORTHOGONAL_LIMIT; loop++){
            neighborsOfCell.add(GameUtils.buildKeyString(aCell.getCoordX(), aCell.getCoordY(), loop));
        }
        /*neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 2));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 3));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 4));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 5));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 6));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 7));
        neighborsOfCell.add(buildKeyString(aCell.getCoordX(), aCell.getCoordY(), 8));
*/
        return neighborsOfCell;
    }

}
