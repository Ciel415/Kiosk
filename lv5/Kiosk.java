package kiosk.lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menu;
    private Scanner scanner;

    public Kiosk(List<Menu> menus) {
        this.menu = menus;
        this.scanner = new Scanner(System.in);
    }

    // Getter
    public List<Menu> getMenu() {
        return menu;
    }

    // Setter (필요한 경우 추가 가능)
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public void start() {
        while (true) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getCategory());
            }
            System.out.println("0. 종료 | 종료");
            System.out.print("메뉴를 선택하세요: ");

            if (!scanner.hasNextInt()) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                Menu selectedMenu = menu.get(choice - 1);
                showMenu(selectedMenu);
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }

            System.out.println();
        }
    }

    private void showMenu(Menu menu) {
        while (true) {
            menu.printMenu();
            System.out.print("메뉴를 선택하세요: ");

            if (!scanner.hasNextInt()) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= menu.getMenuItems().size()) {
                MenuItem selectedItem = menu.getMenuItems().get(choice - 1);
                System.out.println("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }

            System.out.println();
        }
    }
}