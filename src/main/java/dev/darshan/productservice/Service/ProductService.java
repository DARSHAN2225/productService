package dev.darshan.productservice.Service;

import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.models.Product;

public interface ProductService {

    GenericProductDto creatProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);
}
