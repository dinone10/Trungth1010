/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart {
    private Map<String, ProductDTO> cart;

    public Cart() {
    }

    public Cart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }
    public List<ProductDTO> getList() {
        List<ProductDTO> list = new ArrayList<>();
        for (ProductDTO vegetable : this.cart.values()) {
            list.add(vegetable);
        }
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }
    public void add(ProductDTO vegetable) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(vegetable.getProductID())) {
            int currentQuantity = this.cart.get(vegetable.getProductID()).getQuantity();
            vegetable.setQuantity(currentQuantity + vegetable.getQuantity());
        }
        cart.put(vegetable.getProductID(), vegetable);
    }
    
//     public boolean add(ProductDTO vegetable) {
//        boolean check = false;
//        try {
//            if (this.cart == null) {
//                this.cart = new HashMap<>();
//            }
//            if (this.cart.containsKey(vegetable.getProductID())) {
//                int currentQuantity = this.cart.get(vegetable.getProductID()).getQuantity();
//                vegetable.setQuantity(currentQuantity + vegetable.getQuantity());
//            }
//            this.cart.put(vegetable.getProductID(), vegetable);
//            check = true;
//        } catch (Exception e) {
//        }
//        return check;
//    }
     public boolean remove(String productID) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(productID)) {
                    this.cart.remove(productID);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

   public void update(ProductDTO product) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(product.getProductID())) {
            this.cart.replace(product.getProductID(), product);
        }
    }
}
