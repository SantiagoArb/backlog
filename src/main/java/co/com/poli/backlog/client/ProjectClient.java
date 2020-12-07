package co.com.poli.backlog.client;

import co.com.poli.backlog.model.Project;
import co.com.poli.backlog.model.ProjectTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-project")
@RequestMapping(value = "/project")
public interface ProjectClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Project> getProject(@PathVariable("id") Long id);
}
