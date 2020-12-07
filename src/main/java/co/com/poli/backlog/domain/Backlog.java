package co.com.poli.backlog.domain;

import co.com.poli.backlog.model.Project;
import co.com.poli.backlog.model.ProjectTask;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tbl_backlog")
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El identificador no debe ser vacio")
    private String projectIdentifier;
    @Column(name = "project_id")
    private Long projectId;
    @Transient
    private Project project;
    @Transient
    private List<ProjectTask> projectTask;


}
