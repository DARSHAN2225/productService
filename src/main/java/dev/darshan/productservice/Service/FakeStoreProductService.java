package dev.darshan.productservice.Service;

import dev.darshan.productservice.dtos.FakeStoreProductDto;
import dev.darshan.productservice.dtos.GenericProductDto;

import java.util.ArrayList;
import java.util.List;

import dev.darshan.productservice.execptions.NotFoundExecption;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {


    private RestTemplateBuilder restTemplateBuilder;

    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    private String productRequestsBaseUrl = "https://fakestoreapi.com/products";

    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

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

    public GenericProductDto creatProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, GenericProductDto.class);
        return response.getBody();
    }

    public GenericProductDto updateProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return  convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundExecption {
        //FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

         if(fakeStoreProductDto == null) {
             throw new NotFoundExecption("Product not found"+id + "doesent exist");
         }

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

    }

    @Override
    public List<GenericProductDto> getAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> answer = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {
            GenericProductDto product = new GenericProductDto();

            answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return answer;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback =restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response=restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }
}
