package co.com.poli.backlog.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class Project {
    private Long id;
    private String name;
    private String identifier;
    private String description;
    private Date startDate;
    private Date endDate;
}
