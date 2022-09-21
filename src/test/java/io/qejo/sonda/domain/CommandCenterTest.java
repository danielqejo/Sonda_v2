package io.qejo.sonda.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static io.qejo.sonda.domain.Action.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommandCenterTest {

    @Mock
    private Plateau plateau;

    @Mock
    private Probe probe;

    private CommandCenter subject;

    @BeforeEach
    void setUp() {
        subject = new CommandCenter(plateau, probe);
    }

    @Test
    void shouldReceiveCommands() {
        when(probe.move()).thenReturn(probe);
        when(probe.turnLeft()).thenReturn(probe);
        when(probe.turnRight()).thenReturn(probe);

        subject.act(List.of(L, R, M));

        InOrder inOrder = inOrder(probe);
        inOrder.verify(probe).turnLeft();
        inOrder.verify(probe).turnRight();
        inOrder.verify(probe).move();
    }

}
