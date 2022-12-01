package SQL;

import Actors.Address;
import Actors.Customer;
import Actors.Staff;
import Order.Order;
import Product.*;
import SQL.Queries.Product.SQLFrame;
import SQL.Queries.Product.SQLProduct;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static SQL.Queries.Order.SQLOrder.getOrder;
import static SQL.Queries.Product.SQLProduct.decrementStock;
import static SQL.Queries.Product.SQLFrame.*;
import static SQL.Queries.SQLUtils.setDatabase;


public class QueriesMain {

//    Main
    public static void main(String[] args) throws SQLException {
        System.out.println("Setting database...");


        setDatabase();
        Order order = getOrder(-1);
        if (order != null){
            ArrayList<Order> order2 = getOrder(order.getCustomer().getForename(), order.getCustomer().getSurname(), order.getCustomer()
                    .getAddress().getHouseNo(), order.getCustomer()
                    .getAddress().getPostCode());
            System.out.println(order2.get(0).getDate());
        }
        ArrayList<Order> order3 = getOrder(Order.Status.CONFIRMED);
        System.out.println(order3);
        System.out.println(order3.get(0).getBike().getWheels().getStock());
        decrementStock(order3.get(0));
        order3 = getOrder(Order.Status.CONFIRMED);
        System.out.println(order3.get(0).getBike().getWheels().getStock());

        System.out.println(SQLFrame.getAllFrame());

        SQLProduct.addStock(1, "Schwalbe", 1);

    }
}


