package Entity;


public class Games {


    private String row;
    private String name;
    private String playTime;
    private String type;

    public Games(String row,String name, String playTime, String type) {
        this.row = row;
        this.name = name;
        this.playTime = playTime;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPlayTime() {
        return playTime;
    }

    public String getType() {
        return type;
    }

    public String getRow() {
        return row;
    }

}
