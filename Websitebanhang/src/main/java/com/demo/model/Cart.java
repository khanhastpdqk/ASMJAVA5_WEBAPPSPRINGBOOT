package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name="Cart")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;
    @ManyToOne @JoinColumn(name="username")
    @Valid Account account;
    @OneToMany(mappedBy = "cart")
    List<CartDetail> cartDetails;
}
