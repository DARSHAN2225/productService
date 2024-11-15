package dev.darshan.productservice.controller;

import dev.darshan.productservice.Service.ProductService;
import dev.darshan.productservice.dtos.GenericProductDto;
import dev.darshan.productservice.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
      public void getAllProducts(){


      }

      @GetMapping("{id}")
      public GenericProductDto getProductById(@PathVariable("id") Long id){

        return  productService.getProductById(id);
      }

      @DeleteMapping("{id}")
      public void deleteProductById(){

      }
      @PostMapping
      public GenericProductDto createProduct(@RequestBody GenericProductDto product){
          return productService.creatProduct(product);
      }

      @PutMapping ("{id}")
       public void upadateProductById(){

       }

}
