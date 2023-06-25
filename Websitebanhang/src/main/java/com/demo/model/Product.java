package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor
@Entity
@Table(name="Products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Integer id;
    @NotBlank(message = "Không để trống tên!") String name;
    @NotBlank(message = "Không để trống ảnh!") String image;
    @NotNull(message = "Không để trống giá!") @Min(value = 1000, message = "Giá phải lớn hơn 1000Đ!") int price;


    @Temporal(TemporalType.DATE)
    @Column(name="Createdate")
    @DateTimeFormat(pattern = "dd/MM/yyy")
    @NotNull(message = "Không để trống ngày!") Date createDate = new Date() ;

    @ManyToOne @JoinColumn(name="Categoryid")
    @Valid Category category;
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

    // TODO: List<OrderDetail>
}
