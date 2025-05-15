package com.ecom.products;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper mapper;

    @Transactional
    public ProductDTO createProduct(ProductDTO dto){
       Product product = mapper.dtoToEntity(dto);
        //Product pro =convertDtoToEntity(dto);
        Product savedProduct = repository.save(product);
        //ProductDTO dtos =convertEntityToDto(pro);
        return mapper.entityToDTO(savedProduct);
       // return product;
    }

    private ProductDTO convertEntityToDto(Product pro) {
        ProductDTO dto = new ProductDTO();
        dto.setDescription(pro.getDescription());
        dto.setName(pro.getName());
        dto.setPrice(pro.getPrice());
        return dto;
    }

    private Product convertDtoToEntity(ProductDTO dto) {
        Product pro= new Product();
        pro.setName(dto.getName());
        pro.setDescription(dto.getDescription());
        pro.setPrice(dto.getPrice());
        return pro;
    }

    @Transactional
    public List<ProductDTO> getAllProducts(){

        List<Product> product  = repository.findAll();
        return product.stream().map(i->mapper.entityToDTO(i)).collect(Collectors.toList());
    }
}
