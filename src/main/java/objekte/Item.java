package objekte;

import main.main;

public class Item {
    public String name;
    public String description;

    public Item(String name,String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getOptions()
    {
        return "";
    }

    public void performUserAction(int i)
    {
    }

    public void performItemAction(int i)
    {

    }
    public String GetItemOptions()
    {
       return"";
    }
}
