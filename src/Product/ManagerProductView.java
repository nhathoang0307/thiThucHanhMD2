package view.Product;

import model.Product;
import service.ProductService;
import utils.AppUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductView {
    public static Scanner scanner = new Scanner(System.in);

    private final ProductService productService;

    public ManagerProductView() {
        productService = ProductService.getProductService();
    }

    public static Sort sort = new Sort();
    public static Update update = new Update();


    public void menuProduct() {
        System.out.println("\t--------------------------------------------------------------------------------------");
        System.out.println("\t--░░░░░░░░░░░░░░░░░░░░░░░░░[CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM]░░░░░░░░░░░░░░░░░░░░░░░░░---");
        System.out.println("\t-------------------------CHỌN CHỨC NĂNG THEO SỐ (ĐỂ TIẾP TỤC)-------------------------");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--                             【1】. XEM DANH SÁCH                                  --");
        System.out.println("\t--                             【2】. THÊM MỚI                                       --");
        System.out.println("\t--                             【3】. CẬP NHẬT                                       --");
        System.out.println("\t--                             【4】. XÓA                                            --");
        System.out.println("\t--                             【5】. SẮP XẾP                                        --");
        System.out.println("\t--                             【6】. TÌM KIẾM SẢN PHẨM CÓ GIÁ ĐẮT NHẤT              --");
        System.out.println("\t--                             【7】. ĐỌC TỪ FILE                                    --");
        System.out.println("\t--                             【8】. GHI TỪ FILE                                    --");
        System.out.println("\t--                             【0】. THOÁT CHƯƠNG TRÌNH                             --");
        System.out.println("\t--                                                                                  --");
        System.out.println("\t--------------------------------------------------------------------------------------");
        String choice;
        do {
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN CHỨC NĂNG: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showALlcheck();
                    menuProduct();
                    break;
                case "2":
                    addProduct();
                    menuProduct();
                    break;
                case "3":
                    update.Menuupdate();
                    menuProduct();
                    break;
                case "4":
                    removeProduct();
                    menuProduct();
                    break;
                case "5":
                    sort.menuSort();
                    menuProduct();
                    break;
                case "6":
                    findExProduct();
                    menuProduct();
                case "7":
                    readProduct();
                    menuProduct();
                    break;
                case "8":
                    writeProduct();
                    menuProduct();
                    break;
                case "0":
                    System.exit(5);
                default:
                    System.out.println("NHẬP KHÔNG ĐÚNG, XIN NHẬP LẠI");
            }
        } while (choice != "0");
    }


    public void removeProduct() {
        do {
            showALl();
            System.out.println("NHẬP ID CẦN XÓA:");
            Long idProductDel = AppUtils.retryParseLong();
            if (productService.existsById(idProductDel) == true) {
                productService.removeProductById(idProductDel);
                System.out.println("NHẬP 'Y' ĐỂ XÁC NHẬN | NHẬP 'N' ĐỂ HỦY ");
                String confirm = scanner.nextLine().toLowerCase();
                if (confirm.equals("y")) {
                    System.out.println("BẠN ĐÃ XÓA SẢN PHẨM THÀNH CÔNG");
                } else {
                    menuProduct();
                }
            } else {
                System.out.println("KHÔNG TÌM THẤY ID CẦN XÓA");
            }
        } while (AppUtils.isRetry());

    }


    public void showALl() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "MÔ TẢ");
        System.out.println();
        for (Product product : productService.showAllProduct()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
        }
    }

    public void showALlcheck() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "MÔ TẢ");
        System.out.println();
        int count = 0;
        for (Product product : productService.showAllProduct()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    product.getDescription());
            count++;
            if (count == 5) {
                System.out.println("");
                System.out.println("NHẤN ENTER ĐỂ TIẾP TỤC");
                scanner.nextLine();
                count = 0;
            }
        }
    }

    public void addProduct() {
        do {
            long id = System.currentTimeMillis() / 1000;
            System.out.println("NHẬP TÊN SẢN PHẨM");
            String name = AppUtils.beNotEmply("TÊN SẢN PHẨM");
            System.out.println("NHẬP GIÁ");
            float price = AppUtils.retryParseFloat();
            System.out.println("NHẬP SỐ LƯỢNG");
            Long quantity = AppUtils.retryParseLong();
            System.out.println("NHẬP MÔ TẢ");
            String description = AppUtils.retryString("MÔ TẢ");
            Instant createAT = Instant.now();
            Product product = new Product(id, name, price, quantity, description);
            productService.addProduct(product);
            System.out.println("ĐÃ THÊM SẢN PHẨM THÀNH CÔNG ");
        } while (AppUtils.isRetry());
    }

    public void update() {
        do {

            showALl();
            System.out.println("NHẬP ID SẢN PHẨM CẦN SỬA");
            Long idProductEdit = Long.parseLong(scanner.nextLine());
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--░░░░░░░░░░░░░░░░░░░░[THAY ĐỔI SẢN PHẨM]░░░░░░░░░░░░░░░--");
            System.out.println("\t----------------------------------------------------------");
            System.out.println("\t--                                                      --");
            System.out.println("\t--               【1】. THAY ĐỔI TÊN SẢN PHẨM            --");
            System.out.println("\t--               【2】. THAY ĐỔI SỐ LƯỢNG                --");
            System.out.println("\t--               【3】. THAY ĐỔI GIÁ                     --");
            System.out.println("\t--               【4】. THAY ĐỔI MÔ TẢ                   --");
            System.out.println("\t--               【5】. THAY ĐỔI TẤT CẢ                  --");
            System.out.println("\t--               【6】. QUAY LẠI                         --");
            System.out.println("\t--               【0】. THOÁT CHƯƠNG TRÌNH               --");
            System.out.println("\t--                                                      --");
            System.out.println("\t----------------------------------------------------------");
            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░  CHỌN SỐ: ");
            Product newProduct = new Product();
            newProduct.setId(idProductEdit);
            String nameEdit;
            float priceEdit;
            Long quantityEdit;
            String manufacturerEdit;
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM: ");
                    newProduct.setName(nameEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY TÊN THÀNH CÔNG");

                    break;
                case "2":
                    System.out.print("NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = Long.parseLong(scanner.nextLine());
                    newProduct.setQuantity(quantityEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI SỐ LƯỢNG THÀNH CÔNG");
                    break;
                case "3":
                    System.out.print("NHẬP GIÁ MỚI: ");
                    priceEdit = Float.parseFloat(scanner.nextLine());
                    newProduct.setPrice(priceEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI SẢN LƯỢNG THÀNH CÔNG");
                    break;
                case "4":
                    System.out.print("NHẬP MÔ TẢ MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("MÔ TẢ");
                    newProduct.setDescription(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI MÔ TẢ THÀNH CÔNG");
                    break;
                case "5":
                    System.out.print("NHẬP TÊN SẢN PHẨM MỚI: ");
                    nameEdit = AppUtils.beNotEmply("TÊN SẢN PHẨM: ");
                    System.out.print("NHẬP SỐ LƯỢNG MỚI: ");
                    quantityEdit = Long.parseLong(scanner.nextLine());
                    System.out.print("NHẬP GIÁ MỚI: ");
                    priceEdit = Float.parseFloat(scanner.nextLine());
                    System.out.print("NHẬP MÔ TẢ MỚI: ");
                    manufacturerEdit = AppUtils.beNotEmply("MÔ TẢ");
                    newProduct.setName(nameEdit);
                    newProduct.setPrice(priceEdit);
                    newProduct.setQuantity(quantityEdit);
                    newProduct.setDescription(manufacturerEdit);
                    productService.update(newProduct);
                    System.out.println("BẠN ĐÃ THAY ĐỔI THÀNH CÔNG");

                    break;
                case "6":
                    menuProduct();
                    break;
                case "0":
                    System.exit(5);
            }
        } while (AppUtils.isRetry());
    }

    public void findExProducttest() {
        System.out.println("\t----------------SẢN PHẨM CÓ GIÁ ĐẮT NHẤT-------------------------");
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
            break;
        }
    }

    public void findExProduct() {
        List<Product> productssort = productService.sortPriceDESC();
        List<Product> producthigh = new ArrayList<>();
        for (Product p : productssort) {
            producthigh.add(p);
            break;
        }
        System.out.println("\t----------------CÁC SẢN PHẨM CÓ GIÁ ĐẮT NHẤT-------------------------");
        System.out.printf("%-17s %-20s %-15s %-20s %-15s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "NHÀ SẢN XUẤT");
        System.out.println();
        for (Product phigh : producthigh) {
            for (Product product : productService.sortPriceDESC()) {
                if (phigh.getPrice() == product.getPrice()) {
                    System.out.printf("%-17s %-20s %-15s %-20s %-15S\n",
                            "【" + product.getId() + "】",
                            product.getName(),
                            product.getQuantity(),
                            AppUtils.doubleToVND(product.getPrice()),
                            product.getDescription());
                }
            }
        }
    }

    public void readProduct() {
        List<Product> productList = ProductService.getProductService().showAllProduct();
        System.out.println("ĐỌC FILE SẼ XÓA HẾT DANH SÁCH TRONG BỘ NHỚ!");
        System.out.println("NHẤN 'Q' ĐỂ HỦY | NHẤN PHÍM BẤT KÌ ĐỂ THỰC HIỆ  ");

        String chosen = scanner.nextLine().toLowerCase();
        if (chosen.equals("q")) {
            return;
        }
        productList.clear();
        FileInputStream fis;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        try {
            fis = new FileInputStream("data/product1.csv");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Product product = new Product();
                product.parseProduct(line);

                productList.add(product);
            }

            fis.close();
            reader.close();
            bufferedReader.close();
            System.out.println("ĐỌC THÀNH CÔNG!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeProduct() {
        List<Product> productList = ProductService.getProductService().showAllProduct();
        System.out.println("LƯU VÀO FILE!");
        System.out.println("NHẤN 'Y' ĐỂ BẮT ĐẦU LƯU: ");
        String chosen = scanner.nextLine().toLowerCase();
        if (!(chosen.equals("y"))) {
            return;
        }
        System.out.println("Bắt đầu lưu: ");
        FileOutputStream file;
        try {
            file = new FileOutputStream("data/product1.csv");

            for (Product product : productList) {
                String line = product.toString();
                byte[] b = line.getBytes(StandardCharsets.UTF_8);
                file.write(b);
            }

            file.close();
            System.out.println("=> LƯU THÀNH CÔNG, NHẤN PHÍM BẤT KÌ ĐỂ QUAY TRỞ LẠI");
            scanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
