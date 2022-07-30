package objekte;

import Locations.Location;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Location currentLocation;
    private Location  PreviousLocation;
    public Boolean inventarOpen;
    public Item currentInventarInteraction;
    public Boolean InteractionWithInventarItem;

    public Location getPreviousLocation() {
        return PreviousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        PreviousLocation = previousLocation;
    }

    private Boolean canSee;
    private Boolean confidence;
    private Boolean inInteraction = false;
    private Item currentInteractionItem = null;


    private List<Item> inventar = new ArrayList<>();

    public Player(Location currentLocation, Boolean canSee, Boolean confidence,Boolean inventarOpen) {
        this.currentLocation = currentLocation;
        this.canSee = canSee;
        this.confidence = confidence;
        this.inventarOpen = inventarOpen;
    }

    public List<Item> getInventar() {
        return inventar;
    }

    public void setInventar(List<Item> inventar) {
        this.inventar = inventar;
    }
    public void addItemToInv(Item item){
        this.inventar.add(item);
    }
    public void removeItemToInv(Item item){
        this.inventar.remove(item);
    }

    public Item getCurrentInteractionItem() {
        return currentInteractionItem;
    }

    public void setCurrentInteractionItem(Item currentInteractionItem) {
        this.currentInteractionItem = currentInteractionItem;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Boolean getInInteraction() {
        return inInteraction;
    }

    public void setInInteraction(Boolean inInteraction) {
        this.inInteraction = inInteraction;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getCanSee() {
        return canSee;
    }

    public void setCanSee(Boolean canSee) {
        this.canSee = canSee;
    }

    public Boolean getConfidence() {
        return confidence;
    }

    public void setConfidence(Boolean confidence) {
        this.confidence = confidence;
    }
}
