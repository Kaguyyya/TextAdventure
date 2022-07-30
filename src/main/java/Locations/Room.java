package Locations;
import main.ConsoleColors;
import main.main;
import objekte.Flashlight;
import objekte.Item;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Room extends Location {
    public String name;
    public Boolean isDark;
    public String description;
    public List<Item> content;
    public Floor myFloor;



    public Room(List<Item> content, Floor myFloor, String name, String description,Boolean isDark) {

        this.content = content;
        this.myFloor = myFloor;
        this.name = name;
        this.description = description;
        this.isDark = isDark;

    }

    @Override
    public String getOptions() {
        if(this.isDark==false){
        String re = "";
        for (int i = 0; i < content.size(); i++) {
            re += i + ": Interagiere mit " + content.get(i).getName() + "\n";

        }
            re = main.standardInput(re);
            return re;



        }
        else{

            if(main.player.getCanSee())
            {
                if(this.name!="Raum 5")
                {
                String re = "";
                for (int i = 0; i < content.size(); i++) {
                    re += i + ": Interagiere mit " + content.get(i).getName() + "\n";

                }
                    re = main.standardInput(re);
                    return re;
                }
                else if(this.name=="Raum 5"){
                    if(main.player.getConfidence()!=true)
                    {
                        System.out.println(ConsoleColors.RED+"AHH!!!, Der Raum ist voller Spinnen.....Ich habe Angst"+ConsoleColors.RESET);
                        String re = "";
                        System.out.print(ConsoleColors.BLUE);
                        re = main.standardInput(re);
                        return re;
                    }
                    else{
                        String re = "";
                        for (int i = 0; i < content.size(); i++) {
                            re += i + ": Interagiere mit " + content.get(i).getName() + "\n";


                        }
                        re = main.standardInput(re);
                        return re;


                    }
                }
        }
            else if (main.player.getCanSee()!=true)
            {
                String re = "";
                System.out.println(ConsoleColors.YELLOW+"Es ist zu Dunkel um hier was zu sehen"+ConsoleColors.RESET);
                System.out.print(ConsoleColors.BLUE);
                re = main.standardInput(re);

                return re;
            }
        }

        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getContent() {
        return content;
    }

    public void setContent(List<Item> content) {
        this.content = content;
    }

    public Floor getMyFloor() {
        return myFloor;
    }

    public void setMyFloor(Floor myFloor) {
        this.myFloor = myFloor;
    }

    @Override
    public void performUserAction(int i) {

        if(this.isDark==false) {
            if (i == 9) {
                main.player.setCurrentLocation(main.player.getPreviousLocation());
            } else if (i == 10 && main.player.getInventar().size()>0) {
                main.player.inventarOpen = true;
            } else {
                if(content.size()>i)
                {
                    main.player.setInInteraction(true);
                    main.player.setCurrentInteractionItem(content.get(i));
                }
                else if(content.size()==1){
                    main.player.setInInteraction(true);
                    main.player.setCurrentInteractionItem(content.get(0));
                }
                else{
                    System.out.println();
                    System.out.println(ConsoleColors.RED+"Bitte eine oben angegebene Zahl auswählen"+ConsoleColors.RESET);
                    System.out.println();
                }
            }
        }

        else if(this.isDark==true && main.player.getCanSee()!=true){
            if (i == 9) {
                main.player.setCurrentLocation(main.player.getPreviousLocation());
            } else if (i == 10 & main.player.getInventar().size()>0) {
                main.player.inventarOpen = true;

        }
            else{
                System.out.println();
            System.out.println(ConsoleColors.RED+"Bitte eine oben angezeigte Zahl eingeben"+ConsoleColors.RESET);
                System.out.println();
            }
        }
        else
        {
            if (i == 9) {
                main.player.setCurrentLocation(main.player.getPreviousLocation());
                return;
            } else if (i == 10) {
                main.player.inventarOpen = true;
                return;

            }
            if(content.size()>i)
            {
                main.player.setInInteraction(true);
                main.player.setCurrentInteractionItem(content.get(i));
                return;
            }
            else if(content.size()==1){
                main.player.setInInteraction(true);
                main.player.setCurrentInteractionItem(content.get(0));
                return;
            }
            else{
                System.out.println();
                System.out.println(ConsoleColors.RED+"Bitte eine oben angegebene Zahl auswählen"+ConsoleColors.RESET);
                System.out.println();
            }
        }


    }

    public void removeItem(Item item) {
        List<Item> temp = this.getContent();
        temp.remove(item);
        this.setContent(temp);
        //this.content.remove(item);

    }
}
