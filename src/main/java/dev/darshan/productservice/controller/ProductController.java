package dev.darshan.productservice.controller;

import dev.darshan.productservice.Service.ProductService;
import dev.darshan.productservice.dtos.ExceptionDto;
import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.execptions.NotFoundExecption;
import dev.darshan.productservice.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
// @Autowired
    // field injection
    private ProductService productService;

     // Construction injection
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }



    @GetMapping
        public List<GenericProductDto> getAllProducts() {
            return productService.getAllProduct();
        }


      @GetMapping("{id}")
      public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundExecption {

        return  productService.getProductById(id);
      }

      @DeleteMapping("{id}")
      public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){

        return new ResponseEntity<>(
                productService.deleteProduct(id), HttpStatus.OK
        );
      }



      @PostMapping
      public GenericProductDto createProduct(@RequestBody GenericProductDto product){
          return productService.creatProduct(product);
      }

      @PutMapping ("{id}")
       public GenericProductDto upadateProductById(@PathVariable("id") Long id){

        return productService.updateProduct(id);
       }

}
