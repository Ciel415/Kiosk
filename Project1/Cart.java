package kiosk.dojun1;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<MenuItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        for (MenuItem cartItem : cartItems) {
            if (cartItem.getName().equals(item.getName())) {
                cartItem.plusQuantity();
                System.out.println(item.getName() + "의 수량이 증가했습니다. (수량: " + cartItem.getQuantity() + ")");
                return;
            }
        }

        item.setQuantity(1);
        cartItems.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public void showCart() {

        System.out.println("\n[ 장바구니 목록 ]");
        double total = 0;

        for (MenuItem item : cartItems) {
            double itemTotal = item.getPrice() * item.getQuantity();
            total += itemTotal;

            System.out.println(item.getName() + " | 가격: W " + item.getPrice() + " | 수량: " + item.getQuantity() + " | 총액: W " + itemTotal);
        }

        System.out.println("\n장바구니 총 금액: W " + total);
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("장바구니를 비웠습니다.");
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
        }
}
