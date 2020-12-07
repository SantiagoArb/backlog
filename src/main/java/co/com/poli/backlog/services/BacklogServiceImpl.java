package co.com.poli.backlog.services;

import co.com.poli.backlog.domain.Backlog;
import co.com.poli.backlog.repository.BacklogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BacklogServiceImpl implements BacklogService{

    private final BacklogRepository backlogRepository;

    public BacklogServiceImpl(BacklogRepository backlogRepository) {
        this.backlogRepository = backlogRepository;
    }

    @Override
    public List<Backlog> getBacklogAll() {
        return this.backlogRepository.findAll();
    }

    @Override
    public Backlog createBacklog(Backlog backlog) {
        Backlog backlogBD = backlogRepository.findByProjectIdentifier(backlog.getProjectIdentifier());
        if(backlogBD!=null){
            return backlogBD;
        }
        return this.backlogRepository.save(backlog);
    }

    @Override
    public Backlog updateBacklog(Backlog backlog) {
        return null;
    }

    @Override
    public Backlog deleteBacklog(Backlog backlog) {
        return null;
    }

    @Override
    public Backlog getBacklog(Long id) {
        Backlog backlog = backlogRepository.findById(id).orElse(null);
        return backlog;
    }

    @Override
    public Backlog getByNumberId(String projectIdentifier) {
        return this.backlogRepository.findByProjectIdentifier(projectIdentifier);
    }
}
