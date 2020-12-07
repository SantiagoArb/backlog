package co.com.poli.backlog.services;

import co.com.poli.backlog.domain.Backlog;

import java.util.List;

public interface BacklogService {
    List<Backlog> getBacklogAll();

    Backlog createBacklog(Backlog backlog);

    Backlog updateBacklog(Backlog backlog);

    Backlog deleteBacklog(Backlog backlog);

    Backlog getBacklog(Long id);

    Backlog getByNumberId(String numberID);
}
