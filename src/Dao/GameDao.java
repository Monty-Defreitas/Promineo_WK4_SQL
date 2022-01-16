package Dao;

import Entity.Games;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDao {
    private final Connection connection;

    public GameDao (){
        connection = DBConnection.initializeConnection();
    }

    public void createNewGame(String gameName, String playtime, String type) throws SQLException {
        String ENTER_NEW_GAME_QUERY = "INSERT INTO games(name,playtime,type) VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(ENTER_NEW_GAME_QUERY);
        ps.setString(1,gameName);
        ps.setString(2, playtime);
        ps.setString(3,type);
        ps.executeUpdate();
    }
    public void readIndividualEntry(int id) throws SQLException {
        String GET_GAME_BY_ID = "SELECT * FROM games WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(GET_GAME_BY_ID);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        List<Games> game = new ArrayList<Games>();
        while (rs.next()){
            game.add(new Games(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        for (Games games : game) {
            System.out.println(games.getRow() + " " + "Game name: " + games.getName() + "Playtime: " + games.getPlayTime() + "Type: " + games.getType());
        }
    }
    public void readAllEntry(int limit) throws SQLException {
        String GET_ALL_ENTRIES = "SELECT * FROM games";
        PreparedStatement ps = connection.prepareStatement(GET_ALL_ENTRIES);
        ResultSet rs = ps.executeQuery();
        List<Games> members = new ArrayList<Games>();

        for(int i = 0; i < limit ; i++) {
            rs.next();
            members.add(new Games(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        for (Games game : members) {
            System.out.println(game.getRow() + " " + "Game name: " + game.getName() + " | Play time " + game.getPlayTime() + " Minutes" + " " + " |Type of Game: " + game.getType());
        }
    }
    public void updateEntry(String gameName, String playtime, String type, int id) throws SQLException {
        String UPDATE_GAME_BY_ID = "UPDATE games SET name = ?, playtime = ?, type = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(UPDATE_GAME_BY_ID);
        ps.setString(1,gameName);
        ps.setString(2, playtime);
        ps.setString(3,type);
        ps.setInt(4, id);
        ps.executeUpdate();
    }

    public void deleteRow(int id) throws SQLException {
        String DELETE_BY_ID = "DELETE FROM games WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
}
