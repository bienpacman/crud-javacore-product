package config;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {
    public void write(ArrayList<Product> products) throws IOException {
        try {
            File file = new File("C:\\Users\\phamv\\Downloads\\MD5\\demoProducts\\src\\product.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Id,Name,Price,Quantity,Describe");
            bufferedWriter.newLine();
            for (Product product: products) {
                bufferedWriter.write(product.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Product> reader(){
        File file = new File("C:\\Users\\phamv\\Downloads\\MD5\\demoProducts\\src\\product.csv");
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str ;
            while ((str = bufferedReader.readLine()) != null){
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String describe = arr[4];

                products.add(new Product(id, name,price ,quantity ,describe ));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return products;
    }
}
