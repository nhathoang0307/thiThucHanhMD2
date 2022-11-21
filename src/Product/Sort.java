package view.Product;

import model.Product;
import service.ProductService;
import utils.AppUtils;

import java.util.Scanner;

public class Sort {
    public static Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    public static ManagerProductView managerProductView = new ManagerProductView();


    public void menuSort() {
        System.out.println("\t--------------------------------------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░[SẮP XẾP]░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░---");
        System.out.println("\t-------------------------CHỌN CHỨC NĂNG THEO SỐ (ĐỂ TIẾP TỤC)-------------------------");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--                             【1】. SẮP XẾP GIẢM DẦN THEO GIÁ                      --");
        System.out.println("\t--                             【2】. SẮP XẾP TĂNG DẦN THEO GIÁ                      --");
        System.out.println("\t--                             【3】. SẮP XẾP GIẢM DẦN THEO TÊN                      --");
        System.out.println("\t--                             【4】. SẮP XẾP TĂNG DẦN THEO TÊN                      --");
        System.out.println("\t--                             【5】. SẮP XẾP GIẢM DẦN THEO SỐ LƯỢNG                 --");
        System.out.println("\t--                             【6】. SẮP XẾP TĂNG DẦN THEO SỐ LƯỢNG                 --");
        System.out.println("\t--                             【7】. QUAY LẠI MENU                                  --");
        System.out.println("\t--                             【0】. THOÁT CHƯƠNG TRÌNH                             --");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--------------------------------------------------------------------------------------");
        String choice;
        do {
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN CHỨC NĂNG: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sortPriceASC();
                    menuSort();
                    break;
                case "2":
                    sortPriceDESC();
                    menuSort();
                    break;
                case "3":
                    sortNameASC();
                    menuSort();
                    break;
                case "4":
                    sortNameDESC();
                    menuSort();
                    break;
                case "5":
                    sortQuantityASC();
                    menuSort();
                    break;
                case "6":
                    sortQuantityDESC();
                    menuSort();
                    break;
                case "7":
                    managerProductView.menuProduct();
                    break;
                case "0":
                    System.exit(5);
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
            }
        } while (choice != "0");
    }

    public void sortPriceASC() {
        System.out.println("\t----------------SẮP XẾP TĂNG DẦN THEO GIÁ-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortPriceASC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void sortPriceDESC() {
        System.out.println("\t----------------SẮP XẾP GIẢM DẦN THEO GIÁ-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortPriceDESC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void sortQuantityASC() {
        System.out.println("\t----------------SẮP XẾP GIẢM DẦN THEO SỐ LƯỢNG-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortQuantityASC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void sortQuantityDESC() {
        System.out.println("\t----------------SẮP XẾP TĂNG DẦN THEO SỐ LƯỢNG-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortQuantityDESC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void sortNameASC() {
        System.out.println("\t----------------SẮP XẾP TÊN THEO Z-A-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortNameASC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void sortNameDESC() {
        System.out.println("\t----------------SẮP XẾP TÊN THEO A-Z-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product product : productService.sortNameDESC()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }
}
