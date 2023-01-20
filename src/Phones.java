import java.util.*;


public class Phones extends Products{
    private int battery;
    private String color;
    private int camera;
    private final LinkedHashSet<String> brandNames = new LinkedHashSet<>();
    private final ArrayList<Phones> phonesArr = new ArrayList<Phones>();
    private final Phones[] phones = new Phones[100];

    public Phones(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen,int camera,int battery,String color,String brandName) {
        super(id, price, discountRate, stockAmount, name, ram, storage, screen,brandName);
        this.battery = battery;
        this.color = color;
        this.camera = camera;
    }
    public Phones(){

    }
    @Override   //Checked
    public void AddProduct(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen,int camera,int battery,String color,String brandName) {

        phones[id] = new Phones(id,price,discountRate,stockAmount,name,ram,storage,screen,camera,battery,color,brandName);
        brandNames.add("-"+brandName);
        this.phonesArr.add(phones[id]);
    }

    public void DeleteProduct(int id)  //Checked
    {
        phonesArr.remove(phones[id]);
        //If it is the last product of this brand, it must be deleted.
    }
    public void ListPhones()        //Checked
    {
        this.phonesArr.sort(new IDComparatorPhone());
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s    | %-10s | %-8s   | %-5s | %8s | %8s | %-5s   |","ID","Name","Price"
                ,"Brand","Storage","Screen","Camera","Battery","Ram");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Phones value : this.phonesArr) {
            System.out.printf("| %-2s | %-30s | %-10s TL | %-10s | %-8s GB| %-5s | %8s MP | %8s mAh | %-5s GB|",
                    value.id, value.name, value.price, value.brandName,
                    value.storage, value.screen, value.camera,value.battery,value.ram);
            System.out.println();

        }


    }
    public void ListPhones(ArrayList<Phones> phoneList)        //Checked
    {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s    | %-10s | %-8s   | %-5s | %-5s | %-5s | %-5s |","ID","Name","Price"
                ,"Brand","Storage","Screen","Ram","Color","Battery");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");


        for (Phones value : phoneList) {
            System.out.printf("| %-2s | %-30s | %-10s TL | %-10s | %-8s GB| %-5s | %-5s GB |",
                    value.id, value.name, value.price, value.brandName,
                    value.storage, value.screen, value.ram);
            System.out.println();

        }


    }
    public void ListPhones(int choose)      //Checked
    {
        /*Case 1 sort by alphabetical order
          Case 2 sort by price order low to high
          Case 3 sort by price order high to low
          Case 4 sort by storage
          Case 5 sort by screen
          Case 6 sort by ram
          Case 7 sort by discount rate
        */
        switch (choose) {
            case 1 -> {
                phonesArr.sort(new NameComparatorNotebbok());
                this.ListPhones(phonesArr);
            }
            case 2 -> {
                phonesArr.sort(new PriceComparatorSBPhone());
                this.ListPhones(phonesArr);
            }
            case 3 -> {
                phonesArr.sort(new PriceComparatorSBPhone());
                Collections.reverse(phonesArr);
                this.ListPhones(phonesArr);
            }
            case 4 -> {
                phonesArr.sort(new StorageComparatorPhone());
                this.ListPhones(phonesArr);
            }
            case 5 -> {
                phonesArr.sort(new ScreenComparatorPhone());
                this.ListPhones(phonesArr);
            }
            case 6 -> {
                phonesArr.sort(new RamComparatorPhone());
                this.ListPhones(phonesArr);
            }
            case 7 -> {
                phonesArr.sort(new DiscountRateComparatorPhone());
                this.ListPhones(phonesArr);
            }
        }
    }
    public void ListBrandNames()    //Checked
    {
        for (String str:this.brandNames) {
            System.out.println(str);
        }
    }

    public Phones[] getPhones() {
        return phones;
    }
}

class IDComparatorPhone implements Comparator<Phones>
{
    @Override
    public int compare(Phones o1, Phones o2) {
        return Double.compare(o1.id,o2.id);
    }
}
class NameComparatorNotebbok implements Comparator<Phones> {
    @Override
    public int compare(Phones o1, Phones o2) {
        return o1.name.compareTo(o2.name);
    }
}

class DiscountRateComparatorPhone implements Comparator<Phones> {
    @Override
    public int compare(Phones o1, Phones o2) {
        return -1 * Double.compare(o1.discountRate,o2.discountRate);
    }
}

class PriceComparatorSBPhone implements Comparator<Phones>
{
    @Override
    public int compare(Phones o1, Phones o2) {
        return Double.compare(o1.price, o2.price);
    }
}
class RamComparatorPhone implements Comparator<Phones>
{
    @Override
    public int compare(Phones o1, Phones o2) {
        return -1 * Double.compare(o1.ram,o2.ram);
    }
}
class ScreenComparatorPhone implements Comparator<Phones> {
    @Override
    public int compare(Phones o1, Phones o2) {
        return -1 * Double.compare(o1.screen,o2.screen);
    }
}
class StorageComparatorPhone implements Comparator<Phones>{
    @Override
    public int compare(Phones o1, Phones o2) {
        return -1 * Double.compare(o1.storage,o2.storage);
    }
}

