package co.com.poli.backlog.controller;

import co.com.poli.backlog.domain.Backlog;
import co.com.poli.backlog.model.ErrorMessage;
import co.com.poli.backlog.services.BacklogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/backlog")
public class BackLogController {

    private final BacklogService backlogService;

    public BackLogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }

    @GetMapping(value = "/get")
    public String create(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Backlog> createBacklog(@Valid @RequestBody Backlog backlog, BindingResult result){

        if ( result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));

        }
        Backlog backlogBD = this.backlogService.createBacklog(backlog);
        return ResponseEntity.status(HttpStatus.CREATED).body(backlogBD);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Backlog> getBacklog(@PathVariable("id") Long id) {
        System.out.println(id);
        Backlog backlogBd  = backlogService.getBacklog(id);
        if (null == backlogBd) {
           return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(backlogBd);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
