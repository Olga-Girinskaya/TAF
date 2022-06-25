package dbEntities;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Name")
    public String name;

    @Column(name="Description")
    public String description;

    @Column(name="Completed")
    public Boolean completed;

    @Column(name="StartDate")
    public Timestamp startDate;

    @Column(name="EndDate")
    public Timestamp endDate;

    @Column(name="ParentId")
    public Integer parentId;
}
