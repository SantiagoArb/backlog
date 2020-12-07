package co.com.poli.backlog.services;

import co.com.poli.backlog.domain.Backlog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BacklogServiceImplTest {
    @Autowired
    public BacklogService backlogService;

    @Test
    private void GetBacklogTest(){

        Backlog backlog = new Backlog();
        backlog.setId(1L);
        backlog.setProjectId(1L);
        backlog.setProjectIdentifier("1010");
        Mockito.when(backlogService.getBacklog(Mockito.anyLong())).thenReturn(backlog);

        assertEquals(backlog.toString(), backlogService.getBacklog(1L).toString());

    }

}