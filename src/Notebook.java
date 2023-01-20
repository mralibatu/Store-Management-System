import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Notebook extends Products{

    private final LinkedHashSet<String> brandNames = new LinkedHashSet<>();
    private final ArrayList<Notebook> notebooksArr = new ArrayList<Notebook>();
    private final Notebook[] notebooks = new Notebook[100];

    public Notebook(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen, String brandName) {
        super(id, price, discountRate, stockAmount, name, ram, storage, screen, brandName);
    }

    public Notebook(){

    }

    @Override
    public void AddProduct(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen, String brandName) {

        notebooks[id] = new Notebook(id,price,discountRate,stockAmount,name,ram,storage,screen,brandName);
        brandNames.add("-"+brandName);
        this.notebooksArr.add(notebooks[id]);
    }

    public void DeleteProduct(int id){
        notebooksArr.remove(notebooks[id]);
    }

    public void ListNotebooks(){
        this.notebooksArr.sort(new IDComparatorNotebook());
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s    | %-10s | %-8s   | %-5s | %-5s   |","ID","Name","Price"
                ,"Brand","Storage","Screen","Ram");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Notebook notebook : this.notebooksArr) {
            System.out.printf("| %-2s | %-30s | %-10s TL | %-10s | %-8s GB| %-5s | %-5s GB |",
                    notebook.id, notebook.name, notebook.price, notebook.brandName,
                    notebook.storage, notebook.screen, notebook.ram);
            System.out.println();

        }
    }

    public void ListNotebooks(ArrayList<Notebook> phoneList)        //Checked
    {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s    | %-10s | %-8s   | %-5s | %-5s   |","ID","Name","Price"
                ,"Brand","Storage","Screen","Ram");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Notebook value : phoneList) {
            System.out.printf("| %-2s | %-30s | %-10s TL | %-10s | %-8s GB| %-5s | %-5s GB |",
                    value.id, value.name, value.price, value.brandName,
                    value.storage, value.screen, value.ram);
            System.out.println();

        }


    }

    public void ListNotebooks(int choose){
        /*
            Case 1 sort by alphabetical order
            Case 2 sort by price order low to high
            Case 3 sort by pricer order high to low
            Case 4 sort by storage
            Case 5 sort by screen
            Case 6 sort by ram
            Case 7 sort by discount rate
         */

        switch (choose) {
            case 1 -> {
                notebooksArr.sort(new NameComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
            case 2 -> {
                notebooksArr.sort(new PriceComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
            case 3 -> {
                notebooksArr.sort(new PriceComparatorNotebook());
                Collections.reverse(notebooksArr);
                this.ListNotebooks(notebooksArr);
            }
            case 4 -> {
                notebooksArr.sort(new StorageComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
            case 5 -> {
                notebooksArr.sort(new ScreenComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
            case 6 -> {
                notebooksArr.sort(new RamComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
            case 7 -> {
                notebooksArr.sort(new DiscountRateComparatorNotebook());
                this.ListNotebooks(notebooksArr);
            }
        }
    }

    public Notebook[] getNotebooks() {
        return notebooks;
    }
}
class IDComparatorNotebook implements Comparator<Notebook>{
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Double.compare(o1.id,o2.id);
    }
}
class NameComparatorNotebook implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.name.compareTo(o2.name);
    }
}
class PriceComparatorNotebook implements Comparator<Notebook>{
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Double.compare(o1.price,o2.price);
    }
}
class StorageComparatorNotebook implements Comparator<Notebook>{
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return -1 * Double.compare(o1.storage,o2.storage);
    }
}
class ScreenComparatorNotebook implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return -1 * Double.compare(o1.screen,o2.screen);
    }
}
class RamComparatorNotebook implements Comparator<Notebook>{
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return -1 * Double.compare(o1.ram,o2.ram);
    }
}
class DiscountRateComparatorNotebook implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return -1 * Double.compare(o1.discountRate,o2.discountRate);
    }
}