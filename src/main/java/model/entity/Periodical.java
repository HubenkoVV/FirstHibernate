package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "periodical")
public class Periodical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idperiodical")
    private int id;
    @Column(name = "namePer")
    private String name;
    @Column(name = "pricePer")
    private String shortDescription;
    @Column(name = "short_description")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_has_periodical",
            joinColumns = { @JoinColumn(name = "idperiodical") },
            inverseJoinColumns = { @JoinColumn(name = "iduser") }
    )
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "periodical_has_payment",
            joinColumns = { @JoinColumn(name = "idperiodical") },
            inverseJoinColumns = { @JoinColumn(name = "idpayment") }
    )
    private List<Payment> payments;

    @OneToMany(mappedBy = "idPeriodical")
    private List<Article> articles;

    public Periodical() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Periodical that = (Periodical) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + shortDescription.hashCode();
        result = 31 * result + price;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (payments != null ? payments.hashCode() : 0);
        result = 31 * result + (articles != null ? articles.hashCode() : 0);
        return result;
    }
}
