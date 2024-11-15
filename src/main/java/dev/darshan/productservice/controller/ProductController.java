package dev.darshan.productservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

      @GetMapping
      public void getAllProducts(){


      }

      @GetMapping("{id}")
      public String getProductById(@PathVariable("id") Long id){
         return  "Here is product id: "+id;
      }

      @DeleteMapping("{id}")
      public void deleteProductById(){

      }
      @PostMapping
      public String createProduct(){
          return "Created new product with id:" + UUID.randomUUID();
      }

      @PutMapping ("{id}")
       public void upadateProductById(){

       }

}
