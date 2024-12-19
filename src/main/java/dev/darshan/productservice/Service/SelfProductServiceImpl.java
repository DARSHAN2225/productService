package dev.darshan.productservice.Service;

import dev.darshan.productservice.dtos.GenericProductDto;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    @Override
    public GenericProductDto getProductById(Long id) {
         return null;    }

         @Override
         public GenericProductDto creatProduct(GenericProductDto product) {
             // TODO Auto-generated method stub
             return null;
         }
    @Override
    public List<GenericProductDto> getAllProduct() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {

        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id) {
        return null;
    }
}
