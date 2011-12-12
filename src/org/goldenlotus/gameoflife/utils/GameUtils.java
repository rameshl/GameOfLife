package org.goldenlotus.gameoflife.utils;

import org.goldenlotus.gameoflife.vo.Cell;

import java.util.StringTokenizer;

/**
 * Created by rameshl
 * Date: 11/17/11
 */
public class GameUtils {

    private static final int ADJACENCY = 1;

    public static Cell populateCellCoordinates(String key){
//        System.out.println("Processing key : "+key);
        StringTokenizer tokenizer = new StringTokenizer(key, ",");
        Cell newCell = new Cell();
        newCell.setCoordX(tokenizer.nextToken());
        newCell.setCoordY(tokenizer.nextToken());
        return newCell;
    }

    public static String getKeyString(String coordX, String coordY){
        StringBuilder builder = new StringBuilder();
        builder.append(coordX);
        builder.append(",");
        builder.append(coordY);
        return builder.toString();
    }

    public static String buildKeyString(String coordX, String coordY, int option){
        switch (option){
            case 1:
                coordX = Integer.toString(Integer.parseInt(coordX) - ADJACENCY);
                coordY = Integer.toString(Integer.parseInt(coordY) + ADJACENCY);
                break;
            case 2:
                coordX = Integer.toString(Integer.parseInt(coordX) - ADJACENCY);
                break;
            case 3:
                coordX = Integer.toString(Integer.parseInt(coordX) - ADJACENCY);
                coordY = Integer.toString(Integer.parseInt(coordY) - ADJACENCY);
                break;

            case 4:
                coordY = Integer.toString(Integer.parseInt(coordY) + ADJACENCY);
                break;
            case 5:
                coordY = Integer.toString(Integer.parseInt(coordY) + ADJACENCY);
                break;

            case 6:
                coordX = Integer.toString(Integer.parseInt(coordX) + ADJACENCY);
                coordY = Integer.toString(Integer.parseInt(coordY) + ADJACENCY);
                break;
            case 7:
                coordX = Integer.toString(Integer.parseInt(coordX) + ADJACENCY);
                break;
            case 8:
                coordX = Integer.toString(Integer.parseInt(coordX) + ADJACENCY);
                coordY = Integer.toString(Integer.parseInt(coordY) - ADJACENCY);
                break;
            default:
                break;
        }
        return getKeyString(coordX, coordY);
    }

}
