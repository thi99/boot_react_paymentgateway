package thi.backend.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String passWord;

    private String email;

    private String role;

    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    @Embedded
    @ElementCollection
    @CollectionTable(name = "payment_information",joinColumns = @JoinColumn(name="user_id"))
    private List<PaymentInformation> paymentInformation = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    private LocalDateTime createdAt;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String passWord, String email, String role, String mobile, List<Address> address, List<PaymentInformation> paymentInformation, List<Rating> ratings, List<Review> reviews, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
        this.mobile = mobile;
        this.address = address;
//        this.paymentInformation = paymentInformation;
        this.ratings = ratings;
        this.reviews = reviews;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<PaymentInformation> getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(List<PaymentInformation> paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
