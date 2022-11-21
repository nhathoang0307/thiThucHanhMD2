package model;

import java.time.Instant;

public class Product {
    private Long id;
    private String name;
    private float price;
    private Long quantity;
    private String description;



    public Product(Long id, String name, float price, Long quantity,
                   String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }


    public Product() {
    }

    public static Product parseProduct(String record) {
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        String name = fields[1];
        float price = Float.parseFloat(fields[2]);
        Long quantity = Long.parseLong(fields[3]);
        String description = fields[4];

        return new Product(id, name, price, quantity, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


//    public String toString() {
//        String pattern = "MM-dd-yyyy HH:mm:ss";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String dateCreateAt = simpleDateFormat.format(this.createAt);
//        String dateUpdateAt = simpleDateFormat.format(Date.from(this.updateAt));
//
//        return String.format("%5s, %15s, %5s, %5s, %5s, %5s, %5s", this.id, this.name, this.price,
//                this.quantity, this.manufacturer, dateCreateAt, dateUpdateAt);
//    }
@Override
public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                id,
                name,
                price,
                quantity,
                description
        );
    }
}
