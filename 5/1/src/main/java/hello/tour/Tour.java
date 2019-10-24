package hello.tour;
import javax.persistence.*;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @TableGenerator(name="tour", table="tour", schema="bookstore")
//    @Column(name = "id", updatable = false, nullable = false)


    private Integer id;
    private String name;
    private Integer price;
    private float numsOfDay;
    private String typeOfTour;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public float getNumsOfDay() {
        return numsOfDay;
    }

    public void setNumsOfDay(float numsOfDay) {
        this.numsOfDay = numsOfDay;
    }

    public String getTypeOfTour() {
        return typeOfTour;
    }

    public void setTypeOfTour(String typeOfTour) {
        this.typeOfTour = typeOfTour;
    }
}
