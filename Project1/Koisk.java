package kiosk.dojun1;

import java.util.List;
import java.util.Scanner;

class Kiosk {
    private List<Menu> menu;
    private Scanner scanner;
    private Cart cart;

    public Kiosk(List<Menu> menu) {
        this.menu = menu;
        this.scanner = new Scanner(System.in);
        this.cart = new Cart();
    }

    public void start() {
        while (true) {
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getCategory());
            }
            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders  | 장바구니 확인 및 주문");
                System.out.println("5. Cancel  | 진행 중인 주문 취소");
            }
            System.out.println("0. 종료");
            System.out.print("번호 입력: ");

            if (!scanner.hasNextInt()) {
                System.out.println("숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            int Choice = scanner.nextInt();
            if (Choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (Choice > 0 && Choice <= menu.size()) {
                showMenu(menu.get(Choice - 1));
            } else if (Choice == 4 && !cart.isEmpty()) {
                Order();
            } else if (Choice == 5 && !cart.isEmpty()) {
                cancelOrder();
            } else {
                System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    private void showMenu(Menu selectedMenu) {
        while (true) {
            selectedMenu.showMenu();
            System.out.print("번호 입력 (0: 뒤로가기): ");

            if (!scanner.hasNextInt()) {
                System.out.println("숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            int menuChoice = scanner.nextInt();
            if (menuChoice == 0) return;

            List<MenuItem> items = selectedMenu.getItems();
            if (menuChoice < 1 || menuChoice > items.size()) {
                System.out.println("존재하지 않는 메뉴입니다.");
                continue;
            }

            MenuItem selectedItem = items.get(menuChoice - 1);
            System.out.println("\n[ 선택한 메뉴 ]");
            selectedItem.printItem();

            addToCart(selectedItem);
        }
    }

    private void addToCart(MenuItem item) {
        System.out.println("\n이 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인  2. 취소");

        if (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        if (choice == 1) {
            cart.addItem(item);
            System.out.println("\n[ 현재 장바구니 ]");
            cart.showCart();
        } else {
            System.out.println("추가 취소되었습니다.");
        }
    }

    private void Order() {
        cart.showCart();
        System.out.println("\n1. 주문   2. 메뉴로 돌아가기");
        System.out.print("번호 입력: ");

        if (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            scanner.next();
            return;
        }

        int confirmOrder = scanner.nextInt();

        if (confirmOrder == 1) {
            System.out.println("주문이 완료되었습니다. 총 금액: W " + cart.getTotal());
            cart.clearCart();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

    private void cancelOrder() {
        System.out.println("주문이 취소되었습니다.");
        cart.clearCart();
    }
}
