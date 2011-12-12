import org.goldenlotus.gameoflife.service.GameService;
import org.goldenlotus.gameoflife.service.GameServiceImpl;
import org.goldenlotus.gameoflife.utils.GameUtils;
import org.goldenlotus.gameoflife.vo.Cell;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by rameshl
 * Date: 11/17/11
 */
public class GameInit {
    private static int tickCount = 0;
    private static int tickLimit = 1;

    public static void main(String[] args){
        Map<String, Cell> seedGrid = new HashMap<String, Cell>();
        //populate the values from the initial input
        populateSeed(seedGrid);

        //initialize the service
        GameService gameService = new GameServiceImpl();

        Map<String, Cell> tickGrid;

        do{
            tickCount++;
            tickGrid = gameService.proceedToNextTick(seedGrid);

            //Print out living cells
            System.out.println("The living cells after tick "+tickCount+" are \n\n");
            for(String key : tickGrid.keySet()){
                System.out.print(key+" \t");
            }
        }while(tickCount < tickLimit);
    }

    private static void populateSeed(Map<String, Cell> seedGrid){
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        System.out.println("\n\n\nYou are in the game of life\n\n\n");
        System.out.println("1. Enter coordinates of a living cell");
        System.out.println("2. Tick and quit");
        System.out.print("\n Your choice : ");
        userChoice = Integer.parseInt(scanner.nextLine());

        while (userChoice != 2) {
            Cell newCell = new Cell();
            System.out.print("\n\n Please enter X coordinate : ");
            String coordX = scanner.nextLine();
            System.out.print("\n\n Please enter Y coordinate : ");
            String coordY = scanner.nextLine();
            newCell.setCoordX(coordX);
            newCell.setCoordY(coordY);
            newCell.setCellAlive(true);
            seedGrid.put(GameUtils.getKeyString(coordX, coordY), newCell);

            System.out.println("1. Enter coordinates of a living cell");
            System.out.println("2. Tick and quit");
            System.out.print("\n Your choice : ");
            userChoice = Integer.parseInt(scanner.nextLine());
        }
    }
}
