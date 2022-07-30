package main;

import Locations.Floor;
import Locations.Room;
import objekte.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class main
{
    public static Scanner scanner = new Scanner(System.in);
    public static Boolean playing = true;
    public static Player player;
    public static Flashlight flashlight;
    public static Flashlight fl;
    public static Battery battery;
    public static void main(String[] args)
    {
        //Create Rooms and Player
        init();

        //Handelt den user Input
        performLogic();

    }

    public static void init(){




        Floor Floor1 = new Floor("Erdgeschoss","ein langer Flur im Erdgeschoss mit 5 Räumen",new ArrayList<>());
        flashlight = new Flashlight("Taschenlampe", false,"Eine Taschenlampe-um Licht ins dunkle zu bringen");
        fl = new Flashlight("Taschenlampe",true,"Eine Taschenlampe um Licht-ins dunkle zu bringen");
        Room Room1 = new Room(new ArrayList<>(List.of(flashlight, new Earphones("Airpods 3","E2934FAW","Airpods die einem ein gutes-Musikerlebnis erlauben"))),Floor1,"Raum 1","Raum 1",false);
        //"Airpods die einem Mut geben"
        battery = new Battery("Batterie","Batterien für um-einen Akku zu betreiben");
        Room Room2 = new Room(new ArrayList<>(List.of(battery)),Floor1,"Raum 2","Raum 2",false);
        Room Room3 = new Room(new ArrayList<>(List.of(new Note("Ein Fetzen Papier","Der Code Lautet:5544"))),Floor1,"Raum 3","Raum 3",true);
        Room Room4 = new Room(new ArrayList<>(List.of(new Key("Herz geformter Schlüssel","Ein Herz geformter Schlüssel-Wo der wohl reinpasst"))),Floor1,"Raum 4","Raum 4",true);
        Room Room5 = new Room(new ArrayList<>(List.of(new SuspicousDoor("Seltsame Tür","Eine Seltsame Tür"))),Floor1,"Raum 5","Raum 5",true);
       // "Die Kombinationszahl für das Schloss in E5 lautet : 4432"
        // Item Description String if over 30 characters part with "-"
        Floor1.setRooms(List.of(Room1,Room2,Room3,Room4,Room5));

        player = new Player(Floor1,false,false,false);

    }

    public static void performLogic(){
        while (playing) {
            // ROOM LOGIC
            if (player.inventarOpen == false) {
                if (player.getInInteraction() == false) {

                    System.out.println(ConsoleColors.BLUE + "Du befindest dich in " + player.getCurrentLocation().getDescription());
                    System.out.println("Was möchtest du tun");
                    System.out.println(player.getCurrentLocation().getOptions() + ConsoleColors.RESET);
                    player.getCurrentLocation().performUserAction(ValidScanner());

                    // ITEM IN INTERACTION LOGIC
                } else if (player.getInInteraction() == true) {
                    System.out.println(ConsoleColors.BLUE + "Du hast mit " + player.getCurrentInteractionItem().getName() + " interagiert");
                    System.out.println("Was möchtest du tun");
                    System.out.println(player.getCurrentInteractionItem().getOptions() + ConsoleColors.RESET);
                    player.getCurrentInteractionItem().performUserAction(ValidScanner());
                }
                // INVENTAR LOGIC
            } else if (player.inventarOpen == true) {
                while (player.inventarOpen == true)
                {
                    System.out.println(ConsoleColors.BLUE + "Du interagierst gerade mit dem Inventar\nWas möchtest du tun?" + ConsoleColors.RESET);
                int y = 0;
                // outputing all items in the inventory
                for (Item i : player.getInventar()) {

                    System.out.println(ConsoleColors.BLUE + y + ": " + i.name + ConsoleColors.RESET);
                    y++;

                }
                System.out.println(ConsoleColors.BLUE + "10: Inventar schließen" + ConsoleColors.BLUE);
                // user inputs item of choice or close inventory
                int b = ValidScanner();
                if (b == 10) {
                    player.inventarOpen = false;
                    break;
                }
                if(player.getInventar().size()<b){
                    System.out.println();
                    System.out.println(ConsoleColors.RED+"Bitte eine oben angegebene Zahl auswählen"+ConsoleColors.RESET);
                    System.out.println();
                    break;
                }
                int m = 0;
                //searching for the item in the inventory 0 index
                Boolean foundItem = false;
                for (Item i : player.getInventar()) {
                    if (m == b) {
                        // we found the item
                        player.currentInventarInteraction = i;
                        System.out.println(ConsoleColors.BLUE + i.name + "\n" + i.GetItemOptions() + ConsoleColors.RESET);
                        foundItem = true;
                        break;
                    } else {
                        m++;
                    }


                }

                player.currentInventarInteraction.performItemAction(ValidScanner());
                player.currentInventarInteraction = null;

            }
        }

        }
    }
    public static String standardInput(String re){
        if (main.player.getPreviousLocation() != null && main.player.getCurrentLocation()!=main.player.getPreviousLocation()) {
            re += "9: Zurück nach " + main.player.getPreviousLocation().getName()+"\n";
        }
        if(!main.player.getInventar().isEmpty()){
            re += "10: Öffne Inventar";
        }
        return re;
    }

    public static int ValidScanner()
    {
        int passInt=-1;
        while(passInt==-1) {

            String line = scanner.nextLine();
            try {
                passInt = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED+"Bitte gib eine Zahl ein"+ConsoleColors.RESET);
            }


        }
        return passInt;
    }
}
