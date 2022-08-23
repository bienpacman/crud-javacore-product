package view;

import service.ProductService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("_________________Menu___________________");
        System.out.println("1. Show danh sách ");
        System.out.println("2. Thêm sản phẩm ");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm ");
        System.out.println("5. Sắp xếp giá");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file ");
        System.out.println("8. Ghi từ file");
        System.out.println("9. Thoát");
        System.out.println("__________________________________________");
    }

    public static void main(String[] args) {
        boolean exit = false;
        ProductService productService = new ProductService();
        int productId;
        while (true) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            Integer choice = null;
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        productService.show();
                        break;
                    case 2:
                        productService.add();
                        break;
                    case 3:
                        productId = productService.inputId();
                        productService.edit(productId);
                        break;
                    case 4:
                        productId = productService.inputId();
                        productService.delete(productId);
                        break;
                    case 5:
                        System.out.println("___ Sắp xếp giá sản phẩm __");
                        System.out.println("1. Sắp xếp giá tăng dần");
                        System.out.println("2. Sắp xếp giá giảm dần ");
                        System.out.println("3. Thoát");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                productService.sortProductByPrice1();
                                break;
                            case 2:
                                productService.sortProductByPrice2();
                                break;
                            case 3:
                                showMenu();
                                break;
                        }
                    case 6:
                        productService.getMax();
                        break;
                    case 7:
                        productService.productList = productService.readAndWrite.reader();
                        System.out.println("Đọc file thành công !!");
                        break;
                    case 8:
                        productService.readAndWrite.write(productService.productList);
                        System.out.println("ghi file thành công !!!");
                }
                if (exit) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai rồi 1 Nhập lại đi :");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
