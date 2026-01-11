package developer.diary.diary.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "categories", schema = "diary_schema")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icon;

    @Column(name = "is_global")
    private Boolean isGlobal = false;

    @Column(name = "system_type")
    private String systemType;

    @Column(name = "user_id")
    private UUID userId;
}
