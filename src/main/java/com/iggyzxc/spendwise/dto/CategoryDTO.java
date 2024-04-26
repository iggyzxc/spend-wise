package com.iggyzxc.spendwise.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO used to transfer data between the client and server."
)
public record CategoryDTO(
        @Schema(
                description = "Unique identifier for the category."
        )
        Long id,

         @Schema(
                 description = "Name of the category."
         )
         String name) {
}
