package service;

import model.Product;
import utils.CSVUtils;

import java.time.Instant;
import java.util.*;

public class ProductService implements IProductService {

    public String PATH = "G:\\Module2\\thucHanhKetThucModule2\\daTa\\product1.csv";

    private static ProductService productService;

    public ProductService() {

    }

    public static ProductService getProductService() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public List<Product> showAllProduct() {
        List<Product> products = new ArrayList<>();
        List<String> records = CSVUtils.read(PATH);
        for (String record : records) {
            products.add(Product.parseProduct(record));
        }
        return products;
    }

    public void addProduct(Product newProduct) {
        List<Product> products = new ArrayList<>();
        products.add(newProduct);
        CSVUtils.write(PATH, products);
    }

    public void update(Product newProduct) {
        List<Product> products = showAllProduct();
        for (Product p : products) {
            if (p.getId().equals(newProduct.getId())) {
                if (newProduct.getName() != null && !newProduct.getName().isEmpty())
                    p.setName(newProduct.getName());
                if (newProduct.getPrice() != 0.0)
                    p.setPrice(newProduct.getPrice());
                if (newProduct.getQuantity() != null)
                    p.setQuantity(newProduct.getQuantity());
                if (newProduct.getDescription() != null && !newProduct.getDescription().isEmpty())
                    p.setDescription(newProduct.getDescription());
                CSVUtils.writeUpdate(PATH, products);
                break;
            }
        }
    }

    public void removeProductById(Long idProduct) {
        List<Product> products = showAllProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(idProduct)) {
                products.remove(i);
                break;
            }
        }
        CSVUtils.writeUpdate(PATH, products);
    }

    public List<Product> sortPriceASC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o1.getPrice() - o2.getPrice();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public List<Product> sortPriceDESC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o2.getPrice() - o1.getPrice();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });

        return products;
    }

    public List<Product> sortNameASC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o2.getName().compareTo(o1.getName());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public List<Product> sortNameDESC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o1.getName().compareTo(o2.getName());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public List<Product> sortQuantityASC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o2.getQuantity() - (o1.getQuantity());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public List<Product> sortQuantityDESC() {
        List<Product> products = showAllProduct();
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = o1.getQuantity() - (o2.getQuantity());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        return products;
    }

    public Product findById(Long id) {
        List<Product> products = showAllProduct();
        for (Product product : products) {
            if (product.getId().equals(id))
                return product;
        }
        return null;
    }

    public List<Product> findByName(String name) {
        List<Product> products = showAllProduct();
        List<Product> results = new ArrayList<>();
        int check = 0;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(product);
                check++;
            }
        }
        if (check != 0) {
            return results;
        } else {
            return null;
        }
    }
    public boolean existsById(long id) {
        List<Product> products = showAllProduct();
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
