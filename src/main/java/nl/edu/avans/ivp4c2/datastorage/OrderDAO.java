package nl.edu.avans.ivp4c2.datastorage;

import nl.edu.avans.ivp4c2.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *This DAO retrieves the order data and creates an Order object.
 *This DAO uses the ProductDAO to fill the Order with products
 * @author IVP4C2
 */
public class OrderDAO {

	public OrderDAO() {
		// Nothing to be initialized. This is a stateless class. Constructor
		// has been added to explicitely make this clear.
	}
	
	/*Retrieves all orders for a given tableNumber
	 * @param int tableNumber
	 * @return ArrayList<Order> */
	public ArrayList<Order> getTableOrder(int tableNumber) {
		ArrayList<Order> orders = new ArrayList<Order>();

		// First open a database connnection
		DatabaseConnection connection = new DatabaseConnection();
		if (connection.openConnection()) {
			// If a connection was successfully setup, execute the SELECT
			// statement.
			//Select all orders for a given tableNumber
			ResultSet resultset = connection
<<<<<<< HEAD
					.executeSQLSelectStatement("SELECT `o`.`order_id`, `o`.`send_on`, `s`.`name` FROM `order` `o` " +
                            "INNER JOIN `status` `s` ON `o`.`fk_status_id` = `s`.`status_id` " +
                            "INNER JOIN `kpt_table_order` `kto` on `kto`.`fk_order_id` = `o`.`order_id` " +
                            "WHERE `kto`.`fk_table_id` = '"+tableNumber+"';");

            if(resultset != null)
=======
					.executeSQLSelectStatement("SELECT  `order`.`order_id` ,  `order`.`send_on` ,  `status`.`name`, `destination`" +
                            "FROM `order`" +
                            "INNER JOIN `status`ON `status`.`status_id`= `order`.`fk_status_id`= `status`.`status_id`" +
                            "INNER JOIN `kpt_table_order` ON `kpt_table_order`.`fk_order_id`= `order`.`order_id`" +
                            "INNER JOIN `kpt_orderline`ON `kpt_orderline`.`fk_order_id` = `order`.`order_id`" +
                            "WHERE `kpt_table_order`.`fk_table_id`= '"+tableNumber+"'" +
                            "ORDER BY `destination` desc" );
            //AND `kpt_orderline`.`destination`= 1;


			if(resultset != null)
>>>>>>> 321e24f67e33ca674ac745e77bc3702846796908
            {
                try
                {
                    while(resultset.next())
                    {
                    	//Create new Order Object for each record
                        Date date  = resultset.getTimestamp("send_on");
                        String dateString = new SimpleDateFormat("HH:mm:ss").format(date);

                       Order newOrder = new Order(
                    		   resultset.getInt("order_id"),
                    		   resultset.getString("name"),
                    		   dateString,
                               resultset.getInt("destination")
                    		   );
                       
                           //Create new ProductDAO to retrieve and create Product Object for the order
                           ProductDAO productDAO = new ProductDAO();
                           ArrayList<Product> products = productDAO.getProduct(resultset.getInt("order_id")); //Returns an ArrayList with Products
                           for(Product p : products) { //Add product to the new Order
                               newOrder.addProduct(p);
                           }

                        orders.add(newOrder);

                    }
                    
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                    orders = null;
                }
            }

            connection.closeConnection();
        }
		//Return orders ArrayList to be used in TableDAO
		return orders;
	}
}
