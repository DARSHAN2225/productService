package dev.darshan.productservice.Service;

import dev.darshan.productservice.dtos.GenericProductDto;

import java.util.ArrayList;
import java.util.List;

import dev.darshan.productservice.execptions.NotFoundExecption;
import dev.darshan.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.darshan.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {


    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }



    public GenericProductDto creatProduct(GenericProductDto product) {

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.creatProduct(product));
    }

    public GenericProductDto updateProduct(Long id){

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProduct(id));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundExecption {

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));

    }

    @Override
    public List<GenericProductDto> getAllProduct() {

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProduct()){
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }

        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {


        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
