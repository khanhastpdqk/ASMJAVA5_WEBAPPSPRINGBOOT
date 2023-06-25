package com.demo.model;

import lombok.*;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Categories")
public class Category {
    @Id @NotBlank(message = "Không để trống ID!") String id;
      String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
