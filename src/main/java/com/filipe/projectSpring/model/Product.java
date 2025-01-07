package com.filipe.projectSpring.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT") //Opcional, mas indica para o JPA que essa string poderá ser um texto muito grande e não só um VARCHAR de 245 caracteres
    private String description;

    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category",   // nome da tabela que irá representar a junção das entidades
            joinColumns = @JoinColumn(name = "product_id"), // mapeamento da chave estrangeira da classe atual
            inverseJoinColumns = @JoinColumn(name = "category_id")) // mapeamento da chave estrangeira na outra classe do relacionamento
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product(){}
    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    public List<Order> getOrders() {
        return items.stream().map(OrderItem::getOrder).toList();
    }
}
