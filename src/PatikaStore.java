import java.util.Scanner;


public class PatikaStore {
    static Notebook notebook = new Notebook();
    static Phones phones = new Phones();
    static boolean isEmptyNotebook = true;
    static boolean isEmptyPhone = true;

    public PatikaStore(){

    }
    public boolean Login(){
        //Database
        final String username = "mralibatu";
        final String password = "91w1q%EkWJnG40wR$b*B";
        //final String username = "1";
        //final String password = "1";
        final int right = 5;
        int tryTime = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t Welcome to Patika Store Admin Panel ");
        String enteredUsername = "";
        String enteredPassword = "";
        do {
            System.out.print("Enter your username : ");
            enteredUsername = input.nextLine();
            System.out.print("Enter your password : ");
            enteredPassword = input.nextLine();
            if (!((enteredUsername.equals(username)) && enteredPassword.equals(password))) {
                System.out.println("Wrong password or username. Try again!");
                tryTime++;
                System.out.println("Remaining try : " + (right - tryTime));
            }
            if (tryTime == right) {
                System.out.println("You have no right to try!");
                return false;
            }
        } while (!((enteredUsername.equals(username)) && enteredPassword.equals(password)) && tryTime < right);

        System.out.println("Welcome " + username + " !");
        Menu();
        return true;
    }
    public void Menu() {
        System.out.println("Choose an operation\n" +
                "1 - Notebooks\n" +
                "2 - Phones\n" +
                "0 - Quit");
        int chooseMenu = GetChoose();
        System.out.println(chooseMenu);
        switch (chooseMenu) {
            case 0 ->{
                System.out.println("Have a good day!");
            }
            case 1 -> {
                if(isEmptyNotebook){
                    System.out.println("Please add some products!");
                    AddProductNotebook();

                }
                notebook.ListNotebooks();
                NotebookMenu();
            }
            case 2 ->{
                if(isEmptyPhone){
                    System.out.println("Please add some products!");
                    AddProductPhone();
                }
                phones.ListPhones();
                PhoneMenu();
            }
            default -> {
                System.out.println("Wrong number entered");
                Menu();
            }
        }
    }

    public void NotebookMenu() {
        System.out.println("\n");
        System.out.println("""
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 0 to Sort Menu
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 1 to Main Menu
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 2 to Add Product
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 3 to Delete Product""");
        int chooseNotebookMenu = GetChoose();
        switch (chooseNotebookMenu){
            case 0 ->
            {
                NotebookSortMenu();
            }
            case 1 ->
            {
                Menu();
            }case 2->
            {
                AddProductNotebook();
            }case 3->
            {
                DeleteProductNotebook();
            }
            default -> {
                System.out.println("Wrong number entered");
                NotebookMenu();
            }
        }
    }

    public void PhoneMenu(){
        System.out.println("\n");
        System.out.println("""
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 0 to Sort Menu
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 1 to Main Menu
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 2 to Add Product
                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPress 3 to Delete Product
                """);
        int choosePhoneMenu = GetChoose();
        switch (choosePhoneMenu){
            case 0 ->{
                PhoneSortMenu();
            }
            case 1 ->{
                Menu();
            }
            case 2 ->{
                AddProductPhone();
            }
            case 3 ->{
                DeleteProductPhone();
            }
            default -> {
                System.out.println("Wrong number entered");
                PhoneMenu();
            }
        }
    }


    public void NotebookSortMenu()
    {
        System.out.println("""
                1 - Sort by Alphabetical
                2 - Sort by Price (low to high)
                3 - Sort by Price (high to low)
                4 - Sort by Storage
                5 - Sort by Screen Size
                6 - Sort by Ram
                7 - Sort by Discount Rate""");
        int choose = GetChoose();
        notebook.ListNotebooks(choose);
        NotebookMenu();
    }

    public void PhoneSortMenu(){
        System.out.println("""
                1 - Sort by Alphabetical
                2 - Sort by Price (low to high)
                3 - Sort by Price (high to low)
                4 - Sort by Storage
                5 - Sort by Screen Size
                6 - Sort by Ram
                7 - Sort by Discount Rate""");
        int choose = GetChoose();
        phones.ListPhones(choose);
        PhoneMenu();
    }

    public void AddProductNotebook()
    {
        isEmptyNotebook = false;
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t****************Add Product****************");
        System.out.println("How many products do you want to enter? ");
        int productCount = input.nextInt();
        for (int i = 0; i < productCount; i++)
        {
            System.out.print("ID : ");
            int id = input.nextInt();
            System.out.print("Name : ");
            String name = input.next();
            System.out.print("Price : ");
            double price = input.nextDouble();
            System.out.print("Brand : ");
            String brandName = input.next();
            System.out.print("Storage : ");
            int storage = input.nextInt();
            System.out.print("Screen : ");
            double screen = input.nextDouble();
            System.out.print("Ram : ");
            int ram = input.nextInt();
            System.out.print("Discount Rate : ");
            double discountRate = input.nextDouble();
            System.out.print("Stock : ");
            int stockAmount = input.nextInt();

            notebook.AddProduct(id,price,discountRate,stockAmount,name,ram,storage,screen,brandName);
        }

        NotebookMenu();
    }

    public void AddProductPhone(){
        isEmptyPhone = false;
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t****************Add Product****************");
        System.out.println("How many products do you want to enter? ");
        int productCount = input.nextInt();
        for (int i = 0; i < productCount; i++)
        {
            System.out.print("ID : ");
            int id = input.nextInt();
            System.out.print("Name : ");
            String name = input.next();
            System.out.print("Price : ");
            double price = input.nextDouble();
            System.out.print("Brand : ");
            String brandName = input.next();
            System.out.print("Storage : ");
            int storage = input.nextInt();
            System.out.print("Screen : ");
            double screen = input.nextDouble();
            System.out.print("Camera : ");
            int camera = input.nextInt();
            System.out.print("Battery : ");
            int battery = input.nextInt();
            System.out.print("Ram : ");
            int ram = input.nextInt();
            System.out.print("Color : ");
            String color = input.next();
            System.out.print("Discount Rate : ");
            double discountRate = input.nextDouble();
            System.out.print("Stock : ");
            int stockAmount = input.nextInt();

            phones.AddProduct(id,price,discountRate,stockAmount,name,ram,storage,screen,camera,battery,color,brandName);
        }

        PhoneMenu();

    }
    public void DeleteProductNotebook()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t****************Delete Product****************");
        System.out.println();
        System.out.print("ID : ");
        int id = input.nextInt();
        System.out.println("Are you sure about to delete this product : " + notebook.getNotebooks()[id].name);
        System.out.println("Y | N");
        String choose = input.next().toLowerCase();
        switch (choose){
            case "Y" ->
            {
                notebook.DeleteProduct(id);
                System.out.println("The product is deleted");
                System.out.println("Returning to menu...");
                NotebookMenu();
            }
            case "N" ->
            {
                System.out.println("Canceled...");
                System.out.println("Returning to menu...");
                NotebookMenu();
            }
            default ->
            {
                System.out.println("Wrong Input");
                System.out.println("Returning to menu...");
                DeleteProductNotebook();
            }
        }
    }
    public void DeleteProductPhone(){
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t****************Delete Product****************");
        System.out.println();
        System.out.print("ID : ");
        int id = input.nextInt();
        System.out.println("Are you sure about to delete this product : " + phones.getPhones()[id].name);
        System.out.println("Y | N");
        String choose = input.next();
        switch (choose){
            case "Y" ->
            {
                phones.DeleteProduct(id);
                System.out.println("The product is deleted");
                System.out.println("Returning to menu...");
                PhoneMenu();
            }
            case "N" ->
            {
                System.out.println("Canceled...");
                System.out.println("Returning to menu...");
                PhoneMenu();
            }
            default ->
            {
                System.out.println("Wrong Input");
                System.out.println("Returning to menu...");
                DeleteProductPhone();
            }
        }
    }
    public int GetChoose(){
        Scanner input = new Scanner(System.in);
        int chooseMenu = -1;
        try{
            chooseMenu = input.nextInt();
        }catch (java.util.InputMismatchException e){
            System.out.println(e);
        }finally {
            if(chooseMenu == -1){
                chooseMenu = 0;
            }
        }

        return chooseMenu;
    }

}
