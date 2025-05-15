package com.ecom.products;

//import org.mapstruct.Mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO entityToDTO(Product product);
    Product dtoToEntity(ProductDTO dto);
}
