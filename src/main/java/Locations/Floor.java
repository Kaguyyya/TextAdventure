package Locations;
import main.main;
import objekte.Player;
import main.ConsoleColors;

import java.util.List;

public class Floor extends Location{
    private String name;
    private String description;
    private List<Room> rooms;

    public Floor(String name, String description, List<Room> rooms) {
        this.name = name;
        this.description = description;
        this.rooms = rooms;
    }
    @Override
    public String getOptions(){
        String re = "";
        for (int i = 0; i < rooms.size(); i++) {
            re +=  i + ": Gehe in " + rooms.get(i).getName() + "\n";
        }
       re = main.standardInput(re);
        return re;
    }
    @Override
    public void performUserAction(int i)
    {
        if(i == 10 && main.player.getInventar().size()>=1){
            main.player.inventarOpen = true;
            return;
        }
        try {

                main.player.setPreviousLocation(rooms.get(i).getMyFloor());

                main.player.setCurrentLocation(rooms.get(i));

        }catch (Exception e){
            System.out.println(ConsoleColors.RED +"Bitte wähle eine Oben angegebene Zahl"+ ConsoleColors.RESET);
        }

    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return  this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
