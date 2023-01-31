import java.util.HashMap;

import java.util.Map;

import java.util.Objects;

import java.util.Scanner;

public class Charging {

    private static class AddressChooser {

        private String location;
        private String connectorType;
        private String chargingType;

        private int hashCode;

        public AddressChooser(String location, String connectorType, String chargingType) {
            this.location = location;
            this.connectorType = connectorType;
            this.chargingType = chargingType;
            this.hashCode = Objects.hash(location, connectorType, chargingType);
        }

        @Override
        public boolean equals(Object o) {

            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            AddressChooser that = (AddressChooser) o;
            return location.equals(that.location) && connectorType.equals(that.connectorType) && chargingType.equals(that.chargingType);
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

    static Map<AddressChooser, String> addressMap = new HashMap<>();

    static Map<String, String> users = new HashMap<>();

    static {

        addressMap.put(new AddressChooser("Bangalore", "A", "AC"), "Basavanagudi");
        addressMap.put(new AddressChooser("Bangalore", "A", "DC"), "Jayanagar");
        addressMap.put(new AddressChooser("Bangalore", "A", "AC or DC"), "Electronic city");
        addressMap.put(new AddressChooser("Bangalore", "8", "AC"), "Hebbal");
        addressMap.put(new AddressChooser("Bangalore", "B", "DC"), "HSR Layout");
        addressMap.put(new AddressChooser("Bangalore", "B", "AC or DC"), "BTM Layout");
        addressMap.put(new AddressChooser("Bangalore", "C", "AC"), "Bommasandra");
        addressMap.put(new AddressChooser("Bangalore", "C",  "DC"), "Madiwala");
        addressMap.put(new AddressChooser("Bangalore", "C", "AC or DC"), "Pragathi Nagar");

        addressMap.put(new AddressChooser("Udupi", "A", "AC"), "Udupi City");
        addressMap.put(new AddressChooser("Udupi", "A", "DC"), "Kundapur");
        addressMap.put(new AddressChooser("Udupi", "A", "AC or DC"), "Trasi");
        addressMap.put(new AddressChooser("Udupi", "B", "AC"), "Saligrama");
        addressMap.put(new AddressChooser("Udupi", "8", "DC"), "Santhekatte");
        addressMap.put(new AddressChooser("Udupi", "B", "AC or DC"), "Kota");
        addressMap.put(new AddressChooser("Udupi", "C", "AC"), "Thekatte");
        addressMap.put(new AddressChooser("Udupi", "C", "DC"), "Koteshwara");
        addressMap.put(new AddressChooser("Udupi", "C", "AC or DC"), "Basroon");

        addressMap.put(new AddressChooser("Mangalore", "A", "AC"), "Mangalore City");
        addressMap.put(new AddressChooser("Mangalore", "A", "DC"), "Surathkal");
        addressMap.put(new AddressChooser("Mangalore", "A", "AC or DC"), "Pumpwell Circle");
        addressMap.put(new AddressChooser("Mangalore", "B", "AC"), "Kankanadi");
        addressMap.put(new AddressChooser("Mangalore", "8", "DC"), "Srinivas nagar");
        addressMap.put(new AddressChooser("Mangalore", "B", "AC or DC"), "PVS Circle");
        addressMap.put(new AddressChooser("Mangalore", "C", "AC"), "Panamboor");
        addressMap.put(new AddressChooser("Mangalore", "C", "DC"), "Marakada");
        addressMap.put(new AddressChooser("Mangalore", "C", "AC or DC"), "Madyar");

        users.put("shambavi", "shambavi");
        users.put("shonima", "shonima");
        users.put("sahithi", "sahithi");

    }

    static boolean valid(String username, String password) {
        if (users.containsKey(username)) {
            if (password.equals(users.get(username)))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username;
        String password;

        String location;
        String connectorType;
        String chargingType;
        String address;

        System.out.println("Hi here to help you with finding near by charging point in your City");

        boolean start = true;
        while (start)
        {
            System.out.println("Enter 1 to login, 2 to register, 3 to exit");
            String option=sc.nextLine();

            if (option.equals("1")) {
                System.out.println("Enter Username\n");
                username = sc.nextLine();
                System.out.println("Enter password\n");
                password = sc.nextLine();
                if (valid(username, password)) {
                    System.out.println("Logged in successfully \n");

                    boolean continueLoop = true;
                    System.out.println("We would need some info before we can help you. \nkindle enter from the options displayed for the further questions asked!\n");

                    while (continueLoop) {

                        System.out.println("\n\n******************************************\n");

                        System.out.println("Enter Location among available cities (Bangalore, Udupi, Mangalore) \n");
                        location = sc.nextLine();

                        System.out.println("Choose Connector type among available Types (A, B, C) \n");
                        connectorType = sc.nextLine();

                        System.out.println("Choose charging type among available Types (AC, DC, AC or DC) \n");
                        chargingType = sc.nextLine();

                        AddressChooser addressChooser = new AddressChooser(location, connectorType, chargingType);

                        System.out.println("Getting nearest charging location for you\n");

                        if (addressMap.containsKey(addressChooser)) {
                            address = addressMap.get(addressChooser);
                            System.out.println("Nearest charging location for the chosen options is " + address);
                        } else {
                            System.out.println("Invalid options entered for the questions asked. Try again !\n");
                        }


                        System.out.println("\nEnter 1 if you want to find other charging points or enter anything else to exit\n");

                        String one = sc.nextLine();
                        if (!one.equals("1")) {
                            continueLoop = false;
                            start = false;
                            System.out.println("Thank you Terminating!");
                        }
                    }

                } else {
                    System.out.println("\nSorry wrong credentials. Try again\n");
                }
            }

            else if (option.equals("2")){
                 System.out.println("Enter Username\n");
                 username= sc.nextLine();
                 System.out.println("Enter password\n");
                 password= sc.nextLine();
                 users.put(username, password);
                 System.out.println("Successfully registered\n");

            }
            else if (option.equals("3")){
                System.out.println("Terminating.....");
                start=false;
            }

            else
            {
                System.out.println("Choose a right option\n");
            }



        }




    }


}


