package objekte;
import main.ConsoleColors;


import main.main;

import java.io.Console;

public class SuspicousDoor extends Item
{
    public boolean locked = true;
    public SuspicousDoor(String name, String description) {
        super(name,description);

    }


    @Override
    public String getOptions(){

        return " 0: Öffnen " + "\n 9: Zurück";
    }
    @Override
    public void performUserAction(int i) {
        switch (i){

            case 0:

                if(this.locked==true) {
                    Boolean weFoundItem = false;
                    for (Item t : main.player.getInventar()) {
                        if (t.name == "Herz geformter Schlüssel") {

                            System.out.println(ConsoleColors.GREEN+"Du hast den Herzschlüssel benutzt"+ConsoleColors.RESET);
                            weFoundItem = true;
                            this.locked = false;
                            break;

                        }


                    }
                    if(weFoundItem==false) {
                        System.out.println(ConsoleColors.YELLOW + "Die Tür hat ein Herzförmiges Schlüsselloch.... Hmmm");
                        System.out.println("Ich brauche einen Schlüssel!" + ConsoleColors.RESET);
                    }


                }
                else{
                    System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT+"Du bist nach draußen gekommen! GLÜCKWUNSCH!!!!!!"+ConsoleColors.RESET);
                    main.playing = false;
                }

                break;

            case 9:
                main.player.setInInteraction(false);
                break;
            default:
                System.out.println();
                System.out.println(ConsoleColors.RED+"Bitte eine oben angegebene Zahl auswählen"+ConsoleColors.RESET);
                System.out.println();
                break;


        }

    }
}
