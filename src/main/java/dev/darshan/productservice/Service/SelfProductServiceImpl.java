package dev.darshan.productservice.Service;

import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.models.Product;
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
}
