/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entities.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbeans.ProductFacade;

/**
 *
 * @author team2
 */
public class Cart {

    ProductFacade pf = lookupProductFacadeBean();

    //tạo 1 map chứa giỏ hàng
    Map<Integer, Item> map = null;

    public Cart() {
        //khởi tạo giỏ hàng
        map = new HashMap();

    }

    public void add(int id, int quantity, String size) {
        //nếu item chưa có trong cart thì tạo mới và thêm vào cart
        int count = 0;
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            if (entry.getValue().getId() == id && entry.getValue().getSize().equals(size) == true) {
                entry.getValue().setQuantity(entry.getValue().getQuantity() + 1);
                count = 1;
                break;
            }
        }
        if (count == 0) {
            Product product = pf.find(id);
            Item item = new Item(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDiscount(),
                    size,
                    quantity);
            map.put(map.size() + 1, item);
        }
    }

    public void delete(int id, String size) {
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            if (entry.getValue().getId() == id && entry.getValue().getSize().equals(size) == true) {
                map.remove(entry.getKey());
                break;
            }
        }
    }

    public void update(int id, int quantity, String size) {
        for (Map.Entry<Integer, Item> entry : map.entrySet()) {
            if (entry.getValue().getId() == id && entry.getValue().getSize().equals(size) == true) {
                entry.getValue().setQuantity(quantity);
                break;
            }
        }
    }

    public void empty() {
        map.clear();
    }

    //lấy ra danh sách các món hàng trong giỏ hàng
    public Collection<Item> getItems() {
        return map.values();
    }

    public Double getTotal() {
        double total = 0;
        for (Item item : map.values()) {
            total += item.getCost();
        }
        return total;
    }

    public int getNumOfProducts() {
        //lấy ra số lượng phần tử trong list
        return map.size();
    }

    //insert code => call enterprise bean
    private ProductFacade lookupProductFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductFacade) c.lookup("java:global/clothes-shop/ProductFacade!sessionbeans.ProductFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
