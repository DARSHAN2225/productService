package dev.darshan.productservice.Service;

import java.util.List;

import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.models.Product;

public interface ProductService {

    GenericProductDto creatProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProduct();
}
