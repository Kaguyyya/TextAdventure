package objekte;

import main.main;
import main.ConsoleColors;

public class Flashlight extends Item{

    public boolean battery = false;
    public Flashlight(String name,Boolean batteryincludet,String description) {
        super(name,description);
        this.battery = batteryincludet;
    }
    @Override
    public String getOptions(){
        return " 0: Batterie einlegen " + "\n 1: Mitnehmen"+ "\n 9: Zurück";
    }
    @Override
    public void performUserAction(int i) {
        switch (i){

            case 0:
                if(this.battery == false){

                    if(main.player.getInventar().contains(main.battery)){
                        System.out.println(ConsoleColors.GREEN+"Du hast die Batterie eingelegt"+ConsoleColors.RESET);
                        this.battery = true;
                        main.player.removeItemToInv(main.battery);
                    }else {
                        System.out.println(ConsoleColors.RED+"Du hast keine Batterie"+ConsoleColors.RESET);
                    }

                }else{
                    System.out.println(ConsoleColors.GREEN+"Da ist schon eine Batterie drinne "+ConsoleColors.RESET);
                }
                break;
            case 1:
                if(this.battery == false &&  !main.player.getInventar().contains(main.battery))
                {
                    System.out.println(ConsoleColors.YELLOW+"Ohne Batterien wird mir die Taschenlampe wohl nichts nützen"+ConsoleColors.RESET);
                }
                else if(this.battery == false && main.player.getInventar().contains(main.battery))
                {
                    System.out.println(ConsoleColors.YELLOW+"Vielleicht sollte ich meine Batterien zuerst einlegen"+ConsoleColors.RESET);
                }
                else
                {

                    main.player.addItemToInv(main.fl);
                    System.out.println(ConsoleColors.GREEN+"Du hast " + main.player.getCurrentInteractionItem().name+ " mitgenommen" + ConsoleColors.RESET);
                    main.player.getCurrentLocation().removeItem(main.player.getCurrentInteractionItem());
                    main.player.setInInteraction(false);

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


    public void performAction(){
        if(battery == true) {
            if (main.player.getCanSee() == true) {
                main.player.setCanSee(false);
            } else {
                main.player.setCanSee(true);
            }
        }
    }
    @Override
    public void performItemAction(int i) {
        switch (i){

            case 0:

                // 9x51
                int breite = 51;
                int höhe = 9;
                //Calculating itemName spaces
                String itemName = "#";
                char[] charArray = this.name.toCharArray();
                int howManySpaces = 25-charArray.length/2;
                for(int b =howManySpaces;b>0;b--)
                {
                    //  initial spaces
                    itemName +=" ";
                }
                for(int v=0;v<charArray.length;v++){
                    itemName += charArray[v];
                }
                for(int h=49-howManySpaces-charArray.length;h>0;h--){
                    itemName+=" ";
                }
                // end of calculation

                // calculating ItemDescription spaces



                String itemDescription ="#";
                String itemDescription1="#";
                String itemDescription2="#";
                char[] charArray2 = this.description.toCharArray();
                if(charArray2.length<=30)
                {

                    int howManySpaces2 = 25-charArray2.length/2;

                    for(int u=howManySpaces2;u>0;u--)
                    {
                        // inital spaces
                        itemDescription+=" ";
                    }
                    for(int q=0;q<charArray2.length;q++){
                        itemDescription += charArray2[q];
                    }
                    for(int e=49-howManySpaces2-charArray2.length;e>0;e--){
                        itemDescription+=" ";
                    }
                    itemDescription+="#";

                }
                else
                {
                    char[] firstArray = null;
                    char[] secondArray=null;



                    String[] split = this.description.split("-",2);
                    for(String a:split)
                    {
                        if(firstArray==null)
                        {
                            firstArray =a.toCharArray();
                        }
                        else
                        {
                            secondArray = a.toCharArray();
                        }
                    }
                    // first char array
                    int howManySpaces2 = 25-firstArray.length/2;

                    for(int u=howManySpaces2;u>0;u--)
                    {
                        // inital spaces
                        itemDescription1+=" ";
                    }
                    for(int q=0;q<firstArray.length;q++){
                        itemDescription1 += firstArray[q];
                    }
                    for(int e=49-howManySpaces2-firstArray.length;e>0;e--){
                        itemDescription1+=" ";
                    }
                    itemDescription1+="#";
                    // second char array
                    int howManySpaces3 = 25-secondArray.length/2;

                    for(int u=howManySpaces3;u>0;u--)
                    {
                        // inital spaces
                        itemDescription2+=" ";
                    }
                    for(int q=0;q<secondArray.length;q++){
                        itemDescription2 += secondArray[q];
                    }
                    for(int e=49-howManySpaces3-secondArray.length;e>0;e--){
                        itemDescription2+=" ";
                    }
                    itemDescription2+="#";


                }





                itemName +="#";
                System.out.print(ConsoleColors.PURPLE);
                System.out.println("###################################################");
                System.out.println("#               **** Inventory  ****              #");
                System.out.println("#                                                 #");
                System.out.println("#                      ITEM                       #");
                System.out.println("#                                                 #");
                System.out.println(itemName);
                System.out.println("#                                                 #");
                if(charArray2.length<30){
                    System.out.println(itemDescription);
                }
                else{
                    System.out.println(itemDescription1);
                    System.out.println(itemDescription2);
                }
                System.out.println("#                                                 #");
                System.out.println("#                                                 #");
                System.out.println("###################################################");
                System.out.print(ConsoleColors.RESET);

                break;
            case 1:
                if(battery == true) {
                    if (main.player.getCanSee() == true)
                    {

                        main.player.setCanSee(false);
                        System.out.println(ConsoleColors.GREEN+"Ich sehe jetzt weniger"+ConsoleColors.RESET);
                    } else {
                        main.player.setCanSee(true);
                        System.out.println(ConsoleColors.GREEN+"Ich sehe jetzt mehr"+ConsoleColors.RESET);
                    }
                }


                break;
            case 10:
                main.player.inventarOpen=false;
                break;
            default:
                System.out.println();
                System.out.println(ConsoleColors.RED+"Bitte eine oben angegebene Zahl auswählen"+ConsoleColors.RESET);
                System.out.println();
                break;


        }
    }
    @Override
    public String GetItemOptions()
    {
        return " 0: Ansehen\n"+" 1: Benutzen\n"+"10: Inventar schließen";
    }

}
