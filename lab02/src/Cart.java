import hust.soict.globalict.aims.disc.DigitalVideoDisc;

import java.util.Objects;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    int qutyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qutyOrdered == MAX_NUMBERS_ORDERED) System.out.println("The cart is almost full");
        else {
            itemsOrdered[qutyOrdered] = disc;
            qutyOrdered++;
            System.out.println("The disc has been added");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qutyOrdered == 0) System.out.println("The cart is already empty");
        else {
            DigitalVideoDisc[] arr_new = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
            for(int i=0, k=0;i<qutyOrdered;i++){
                if(!Objects.equals(itemsOrdered[i].getTitle(), disc.getTitle())){
                    arr_new[k]=itemsOrdered[i];
                    k++;
                }
            }
            qutyOrdered--;
            itemsOrdered = arr_new;
            System.out.println("The disc has been removed");
        }
    }

    public float totalCost() {
        float sum = 0;
        for(int i = 0; i<qutyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}
