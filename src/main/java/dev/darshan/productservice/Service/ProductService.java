package dev.darshan.productservice.Service;

import java.util.List;

import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.execptions.NotFoundExecption;

public interface ProductService {

    GenericProductDto creatProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundExecption;

    List<GenericProductDto> getAllProduct();

   GenericProductDto deleteProduct(Long id);

   GenericProductDto updateProduct(Long id);
}
