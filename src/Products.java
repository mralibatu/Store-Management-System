import java.util.LinkedHashMap;

public abstract class Products{
    public int id;
    public String name;
    public String brandName;
    public double price;
    public double discountRate;
    public double screen;
    public int stockAmount;
    public int ram;
    public int storage;
    public LinkedHashMap<Integer,String> list = new LinkedHashMap<>();
    public String[] info;


    public Products(int id,double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen,String brandName) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.brandName = brandName;
    }

    public Products() {

    }

    public void AddProduct(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen,int camera,int battery,String color,String brandName)
    {

    }
    public void AddProduct(int id, double price, double discountRate, int stockAmount, String name, int ram, int storage, double screen,String brandName)
    {

    }

    /*public int GenerateID()
    {
        if(list.get(0) == null){
            list.put(0,"");
        }
      Integer[] IDs = list.keySet().toArray(new Integer[0]);

      return IDs[IDs.length - 1] + 1;
    }*/
}
