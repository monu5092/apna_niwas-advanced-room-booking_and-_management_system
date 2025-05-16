package com.example.ApnaHotel.entity;

import com.example.ApnaHotel.dto.BookingDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="users")
public class User  implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    private String password;

    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public @NotBlank(message = "Email is required") String getEmail() {return email;}
    public void setEmail(@NotBlank(message = "Email is required") String email) {this.email = email;}

    public @NotBlank(message = "Name is required") String getName() {return name;}
    public void setName(@NotBlank(message = "Name is required") String name) {this.name = name;}

    public @NotBlank(message = "Phone Number is required") String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(@NotBlank(message = "Phone Number is required") String phoneNumber) {
        this.phoneNumber = phoneNumber;}

    public void setPassword(@NotBlank(message = "Password is required") String password) {
        this.password = password;
    }
    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
