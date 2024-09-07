package lk.ijse.gdse.postservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @Column(columnDefinition = "LONGBLOB")
    @Lob
    private byte[] image;

    public Post(String title, String description, byte[] imageBytes) {
        this.title = title;
        this.description = description;
        this.image = imageBytes;
    }
}
