package kiosk.dojun1;

import java.util.Objects;

class MenuItem {
    private String name;
    private double price;
    private String desc;
    private int quantity;

    public MenuItem(String name, double price, String descs) {
        this.name = name;
        this.price = price;
        this.desc = descs;
        this.quantity = 1;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDesc() { return desc; }
    public int getQuantity() { return  quantity;}

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void plusQuantity() { this.quantity++; }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof MenuItem)) {
            return false;
        }
        MenuItem otherItem = (MenuItem) other;
        return this.price == otherItem.price && this.name.equals(otherItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
    public void printItem() {
        System.out.println(name + " | W " + price + " | " + desc);
    }
}
