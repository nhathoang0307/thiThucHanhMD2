package service;

import model.Product;

import java.util.List;

public interface IProductService {
     List<Product> showAllProduct();
     void addProduct(Product newProduct);
     void update(Product newProduct);
     void removeProductById(Long idProduct);
     List<Product> sortPriceASC();
     List<Product> sortPriceDESC();
    List<Product> sortNameASC();
     List<Product> sortNameDESC();
     List<Product> sortQuantityASC();
     List<Product> sortQuantityDESC();
     Product findById(Long id);
     List<Product> findByName(String name);

    public boolean existsById(long id);
}
