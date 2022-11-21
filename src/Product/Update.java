package view.Product;

import model.Product;
import service.ProductService;
import utils.AppUtils;

import java.util.Scanner;

public class Update {
    public static Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    public static ManagerProductView managerProductView = new ManagerProductView();

    public void Menuupdate() {
        do {
            managerProductView.showALl();
            System.out.println("NHẬP ID SẢN PHẨM CẦN SỬA");
            Long idProductEdit = AppUtils.retryParseLong();
            if (productService.existsById(idProductEdit) == true) {
                for (Product product : productService.showAllProduct()) {
                    if (idProductEdit.equals(product.getId())) {
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
                        String descriptionEdit;
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
                                descriptionEdit = AppUtils.beNotEmply("MÔ TẢ");
                                newProduct.setDescription(descriptionEdit);
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
                                descriptionEdit = AppUtils.beNotEmply("MÔ TẢ");
                                newProduct.setName(nameEdit);
                                newProduct.setPrice(priceEdit);
                                newProduct.setQuantity(quantityEdit);
                                newProduct.setDescription(descriptionEdit);
                                productService.update(newProduct);
                                System.out.println("BẠN ĐÃ THAY ĐỔI THÀNH CÔNG");

                                break;
                            case "6":
                                managerProductView.menuProduct();
                                break;
                            case "0":
                                System.exit(5);
                        }
                    }
                }
            } else {
                System.out.println("KHÔNG TÌM THẤY ID SẢN PHẨM");
            }
        }while (AppUtils.isRetry());
    }
}
