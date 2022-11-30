package SQL.Queries;

import Actors.Address;
import Actors.Customer;
import Actors.Staff;
import Order.Order;
import Product.Bike;
import Product.Frame;
import Product.HandleBar;
import Product.Wheels;
import SQL.DbConnection;
import SQL.Password;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

import static SQL.Queries.Actors.SQLStaff.insertStaffTable;
import static SQL.Queries.Order.SQLOrder.insertOrder;
import static SQL.Queries.Product.SQLFrame.insertFrame;
import static SQL.Queries.Product.SQLHandleBar.insertHandleBar;
import static SQL.Queries.Product.SQLWheels.insertWheels;

public class SQLUtils {

    public static void isValidPrimaryKey(int pKey, String tableName) throws InvalidPrimaryKeyException {
        if (pKey < 0){
            throw new InvalidPrimaryKeyException(tableName + ": " + pKey);
        }
    }


//    Populating database utils
    public static void setDatabase() throws SQLException {
        deleteDatabase();
        populateDatabase();
    }
    private static void populateDatabase() {
//        First insert all the components of a bike
        Wheels wheels1 = insertWheels(new Wheels(24, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "HS127", 1, 21.49, "Schwalbe", 61));
        Wheels wheels2 = insertWheels(new Wheels(24, Wheels.Style.MOUNTAIN, Wheels.BrakeType.DISKBRAKE, "Land Cruiser", 2, 19.99, "Schwalbe", 12));
        Wheels wheels3 = insertWheels(new Wheels(24, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "Wheelchair Rightrun", 3, 26.99, "Schwalbe", 46));
        Wheels wheels4 = insertWheels(new Wheels(24, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "Halfords Hybrid", 4, 13.00, "Halfords", 69));
        Wheels wheels5 = insertWheels(new Wheels(20, Wheels.Style.MOUNTAIN, Wheels.BrakeType.RIM, "BMX Tyre", 5, 12.00, "Halfords", 24));
        Wheels wheels6 = insertWheels(new Wheels(20, Wheels.Style.MOUNTAIN, Wheels.BrakeType.RIM, "Black Jack", 6, 9.99, "Bontrager", 69));
        Wheels wheels7 = insertWheels(new Wheels(18, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "Essentials Kids", 7, 12.00, "Halfords", 14));
        Wheels wheels8 = insertWheels(new Wheels(16, Wheels.Style.ROAD, Wheels.BrakeType.DISKBRAKE, "Marathon Plus", 8, 32.65, "Schwalbe", 23));

        Frame frame1 = insertFrame(new Frame(160, 2, false, "Superstar Caliper", 1, 1398.99, "Cinelli", 4));
        Frame frame2 = insertFrame(new Frame(166, 5, true, "Mega 290 Carbon Mountain", 2, 1889.99, "Nukeproof", 1));
        Frame frame3 = insertFrame(new Frame(166, 1, false, "Scout 290 Alloy MTB", 4, 349.99, "Nukeproof", 36));
        Frame frame4 = insertFrame(new Frame(155, 3, false, "Vitesse EVO", 5, 999.99, "Vitus", 17));
        Frame frame5 = insertFrame(new Frame(172, 7, true, "Giga 290 Carbon Frame", 6, 2799.99, "Nukeproof", 5));
        Frame frame6 = insertFrame(new Frame(172, 2, false, "Mmmbop Hardtail", 7, 209.99, "Ragley", 89));

        HandleBar handleBar1 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "HB-M11 Pro Riser-Bar", 1, 26.43, "XLC", 120));
        HandleBar handleBar2 = insertHandleBar(new HandleBar(HandleBar.Style.HIGH, "HB-C08 Comp Ergo-Bar", 2, 18.00, "XLC", 74));
        HandleBar handleBar3 = insertHandleBar(new HandleBar(HandleBar.Style.HIGH, "HB-T03 Pro Tri-Bar", 3, 45.86, "XLC", 54));
        HandleBar handleBar4 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "HB-C02 Trekking Handlebar", 4, 15.89, "XLC", 28));
        HandleBar handleBar5 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "SL 70 XPLR", 5, 125.00, "ZIPP", 17));
        HandleBar handleBar6 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "Alumina Base Bar", 6, 79.00, "Vuka", 95));
        HandleBar handleBar7 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "Descendant Riser", 7, 75.00, "Truvative", 64));
        HandleBar handleBar8 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "Course 80 Ergonomic", 8, 60.00, "ZIPP", 28));

        Bike bike1 = new Bike(wheels1, frame3, handleBar4);
        Bike bike2 = new Bike(wheels6, frame5, handleBar2);
        Bike bike3 = new Bike(wheels1, frame4, handleBar1);
        Bike bike4 = new Bike(wheels5, frame2, handleBar6);
        Bike bike5 = new Bike(wheels5, frame3, handleBar5);
        Bike bike6 = new Bike(wheels3, frame6, handleBar8);
        Bike bike7 = new Bike(wheels8, frame1, handleBar3);
        Bike bike8 = new Bike(wheels2, frame4, handleBar2);


        Address address1 = new Address(14, "Mappin Steet", "Sheffield", "S1 4DT");
        Address address2 = new Address(6, "Blundell Road", "Hightown", "L38 9EQ");
        Address address3 = new Address(468, "Aberford Road", "Stanley", "WF3 4AG");
        Address address4 = new Address(3, "Meadowside", "Wendron", "TR13 0LT");
        Address address5 = new Address(3, "Woodlands Close", "Barrow-Upon-Humber", "DN19 7DX");
        Address address6 = new Address(4, "North Hall", "St Ishmaels", "SA62 3SW");
        Address address7 = new Address(35, "Luke Street", "London", "EC2A 4LH");
        Address address8 = new Address(153, "Kingsland Road", "Birmingham", "B44 9QA");

        Customer customer1 = new Customer("Alex", "Surname", address1);
        Customer customer2 = new Customer("Oscar", "Surname", address2);
        Customer customer3 = new Customer("Tahir", "Surname", address3);
        Customer customer4 = new Customer("Bryon", "Gallacher", address4);
        Customer customer5 = new Customer("Margot ", "Niles", address5);
        Customer customer6 = new Customer("Rachael ", "Marshall", address6);
        Customer customer7 = new Customer("Mike ", "Stuart", address7);
        Customer customer8 = new Customer("Josephine ", "Tyler", address8);

        Order order1 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer1, bike1);
        Order order2 = new Order(Date.valueOf(LocalDate.now()), Order.Status.CONFIRMED, customer2, bike2);
        Order order3 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer3, bike3);
        Order order4 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer4, bike4);
        Order order5 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer5, bike5);
        Order order6 = new Order(Date.valueOf(LocalDate.now()), Order.Status.CONFIRMED, customer6, bike6);
        Order order7 = new Order(Date.valueOf(LocalDate.now()), Order.Status.FULFILLED, customer7, bike7);
        Order order8 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer8, bike8);

        insertOrder(order1);
        insertOrder(order2);
        insertOrder(order3);
        insertOrder(order4);
        insertOrder(order5);
        insertOrder(order6);
        insertOrder(order7);
        insertOrder(order8);

        //        Inserts staff
        byte[][] salts = new byte[4][4];
        Arrays.fill(salts, Password.getSalt());
        insertStaffTable(new Staff("Staff1", Password.hashPassword("d1Z2n2^0hT0x", salts[0])[0], salts[0]));
        insertStaffTable(new Staff("Staff2", Password.hashPassword("5tG57O&c&j1z", salts[1])[0], salts[1]));
        insertStaffTable(new Staff("Staff3", Password.hashPassword("s45M6!JswuVG", salts[2])[0], salts[2]));
        insertStaffTable(new Staff("test", Password.hashPassword("test", salts[3])[0], salts[3]));
    }
    private static void deleteDatabase() throws SQLException {
        Connection con = DbConnection.getCon();
        con.prepareStatement("DELETE FROM `team002`.`Order`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Customer`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Bike`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Address`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Wheels`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`FrameSet`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Handlebar`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Product`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Staff`;").executeUpdate();

    }


}
