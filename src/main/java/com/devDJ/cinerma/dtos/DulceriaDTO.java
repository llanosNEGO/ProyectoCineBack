package com.devDJ.cinerma.dtos;

import lombok.Data;
import java.util.List;

@Data
public class DulceriaDTO {
    private String title;
    private List<String> description;
    private Double cost;
    private String category;
    private String urlImage;
}