package service;

import comparator.SortProductByPrice1;
import comparator.SortProductByPrice2;
import config.ReadAndWrite;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductService {
    public ArrayList<Product> productList =  new ArrayList<>();
    public ReadAndWrite readAndWrite =  new ReadAndWrite();

    Scanner scanner = new Scanner(System.in);

    public void add() {
        int id = (productList.size()> 0 ) ? (productList.size() + 1) : 1;
        System.out.println("Product id +" + id );
        String name = inputName();
        double price = inputPrice();
        Integer amount = inputAmount();
        String describe = inputDescribe();

        Product product = new Product(id,name,price,amount,describe);
        productList.add(product);
    }

    private String inputDescribe() {
        System.out.println("Ghi chú :");
        return scanner.nextLine();
    }

    private Integer inputAmount() {
        System.out.println("Nhập số lượng :");
        while (true){
            try {
                Integer quantity = Integer.parseInt((scanner.nextLine()));
                if (quantity < 0){
                    throw new NumberFormatException();
                }
                return quantity ;
            }catch (NumberFormatException e){
                System.err.println("Số lượng không hợp lệ ! Nhập lại đi");
            }
        }
    }

    private double inputPrice() {
        System.out.println("Nhập giá :");
        while (true){
            try {
                double price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new NumberFormatException();
                }
                return price;
            }catch (NumberFormatException e){
                System.err.println("Nhập sai giá !! Vui lòng Nhập lại :");
            }
        }
    }

    private String inputName() {
        System.out.println("Nhập tên sản phẩm :");
        return scanner.nextLine();
    }

    public int inputId () {
        System.out.print("Nhập id :");
        while (true){
            try {
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            }catch (NumberFormatException e){
                System.out.println("Id Không tồn tại !! Vui lòng nhập lại :");
            }
        }
    }
    public void edit(int id) {
        boolean isExited = false;
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == id ){
                isExited = true;;
                productList.get(i).setName(inputName());
                productList.get(i).setPrice(inputPrice());
                productList.get(i).setAmount(inputAmount());
                productList.get(i).setDescribe(inputDescribe());
                break;
            }
        }
        if (!isExited){
            System.out.printf("id = %d không tồn tại . \n", id);
        }
    }

    public void delete(int id ){
        Product product = null;
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() ==id){
                product = productList.get(i);
                break;
            }
        }
        if (product != null){
            productList.remove(product);
        }else {
            System.out.printf("id = %id không tồn tại . \n", id);
        }
    }
    public void show() {
        System.out.println("____________________________Danh Sách Sản Phẩm_____________________________");
        System.out.println();
        System.out.printf("%-10s%-21s%-17s%-14s%s\n", "ID", "Tên sản phẩm", "Giá", "Số lượng ", "Ghi chú");
        for (Product product : productList) {
            System.out.println("_____________________________________________________________________________");
            System.out.printf("%-14s%-17s%-19s%-14s%s\n", product.getId(), product.getName(), product.getPrice(), product.getAmount(), product.getDescribe());
        }
    }
    public void sortProductByPrice1() {
        Collections.sort(productList, new SortProductByPrice1());
    }

    public void sortProductByPrice2() {
        Collections.sort(productList, new SortProductByPrice2());
    }

    public double getMax() {
        while (true){
            try {
                double max = productList.get(0).getPrice();
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getPrice() > max) {
                        max = productList.get(i).getPrice();
                        System.out.println("Sản phẩm có giá lớn nhất là :" + max);
                        return max;
                    }
                    else if (productList == null){
                        throw new IndexOutOfBoundsException();
                    }
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("không có sản phẩm !!");
                break;

            }
        }
        return 0;
    }
}
