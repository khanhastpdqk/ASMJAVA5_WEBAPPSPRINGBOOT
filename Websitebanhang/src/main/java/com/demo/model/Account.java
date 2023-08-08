package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "Accounts")

public class Account  implements Serializable {
    @Id
    @NotBlank(message = "Không để trống username!") String username;
    @NotBlank(message = "Không để trống password!") String password;
    @NotBlank(message = "Không để trống tên!") String fullname;
    @NotBlank(message = "Không để trống email!") @Email(message = "Sai định dạng email!") String email;
    @NotBlank(message = "Không để trống ảnh!") String photo;
    @NotNull boolean activated;
    @NotNull boolean admin;
    @OneToMany(mappedBy = "account")
    List<Order> orders;
    @OneToMany(mappedBy = "account")
    List<Cart> carts;

    //TODO
}