package co.com.poli.backlog.client;

import co.com.poli.backlog.model.ProjectTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-projectTask")
@RequestMapping(value = "/task")
public interface ProjectTaskClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<ProjectTask> getTask(@PathVariable("id") Long id);
    @GetMapping()
    ResponseEntity<ProjectTask> getAllTaskById();
}
