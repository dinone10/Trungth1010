/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import space_detail.SpaceDetailDTO;

/**
 *
 * @author Admin
 */
public class Cart {

    private Map<String, SpaceDetailDTO> cart;

    public Cart() {
    }

    public Cart(Map<String, SpaceDetailDTO> cart) {
        this.cart = cart;
    }

    public Map<String, SpaceDetailDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, SpaceDetailDTO> cart) {
        this.cart = cart;
    }

    public List<SpaceDetailDTO> getList() {
        List<SpaceDetailDTO> list = new ArrayList<>();
        for (SpaceDetailDTO space : this.cart.values()) {
            list.add(space);
        }
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    public void add(SpaceDetailDTO space) {
        double count = Math.random();
        String _count = String.valueOf(count++);
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        cart.put(_count, space);
    }

    public boolean remove() {
        boolean check = false;
        try {
            if (this.cart != null) {
                //if (this.cart.containsKey(parkingDetailID)) {
                this.cart.clear();
                check = true;
                //}
            }
        } catch (Exception e) {
        }
        return check;
    }

    public void update(SpaceDetailDTO space) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(space.getSlotID())) {
            this.cart.replace(space.getSlotID(), space);
        }
    }

    public void add(OrderDetailDTO date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
