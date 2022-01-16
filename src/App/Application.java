package App;

import Dao.GameDao;
import java.sql.SQLException;
import java.util.*;

public class Application {
Scanner sc = new Scanner(System.in);
GameDao gameDao = new GameDao();

List<String> options = List.of("1). Create Entry","2). Read entry","3). Read all entries",
        "4). Update entry","5). Delete entry"," Exit application press y");


public void start() {
    String selection = "";

     do {
         optionLoop();
         selection = sc.nextLine();
         try {
             switch (selection){
                 case "1": createMember();
                 break;
                 case "2": readEntry();
                 break;
                 case "3": readAllWithLimit();
                 break;
                 case "4": updateEntry();
                 break;
                 case "5": deleteEntry();
                 break;
             }

         } catch (Exception e) {
            e.printStackTrace();
         }
         System.out.println("Press enter to continue...");
         sc.nextLine();
     } while (!selection.equalsIgnoreCase("y"));
}

    private void deleteEntry() throws Exception {
        System.out.println("Enter id for row you'd like to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        gameDao.deleteRow(id);
    }

    public void optionLoop(){
    for (int i = 0; i < options.size(); i++){
        System.out.println(options.get(i));
        }
    }

    private void createMember() throws SQLException {
        System.out.print(" Enter game name:  ");
        String gameName = sc.nextLine();
        System.out.print(" Enter time to play:  ");
        String lengthPlay = sc.nextLine();
        System.out.print(" Enter type of game:  ");
        String type = sc.nextLine();
        gameDao.createNewGame(gameName,lengthPlay,type);
    }
    private void readEntry() throws SQLException {
        System.out.println("Enter id for entry you'd like to view: ");
        int id = Integer.parseInt(sc.nextLine());
        gameDao.readIndividualEntry(id);

    }
    private void updateEntry() throws SQLException {
        System.out.println(" Enter row id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print(" Enter game name:  ");
        String gameName = sc.nextLine();
        System.out.print(" Enter time to play:  ");
        String lengthPlay = sc.nextLine();
        System.out.print(" Enter type of game:  ");
        String type = sc.nextLine();

        gameDao.updateEntry(gameName,lengthPlay,type, id);
    }

    private void readAllWithLimit() throws SQLException {
        System.out.println("How many games would you like to see? ");
        int limit = Integer.parseInt(sc.nextLine());
        gameDao.readAllEntry(limit);

    }

}
