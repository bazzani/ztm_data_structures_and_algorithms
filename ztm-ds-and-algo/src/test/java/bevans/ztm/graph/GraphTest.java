package bevans.ztm.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphTest {

    private Graph sut;

    @BeforeEach
    void setUp() {
        sut = new Graph();
    }


    @Test
    void shouldAddVertex() {
        // given
        // when
        sut.addVertex(1);
        var connectionsString = sut.showConnections();

        // then
        assertThat(connectionsString).isEqualTo("1-->");

        System.out.println(connectionsString);
    }

    @Test
    void shouldAddVerticesAndEdges() {
        // given
        sut.addVertex(0);
        sut.addVertex(1);
        sut.addVertex(2);
        sut.addVertex(3);
        sut.addVertex(4);
        sut.addVertex(5);
        sut.addVertex(6);

        // when
        sut.addEdge(3, 1);
        sut.addEdge(3, 4);
        sut.addEdge(4, 2);
        sut.addEdge(4, 5);
        sut.addEdge(1, 2);
        sut.addEdge(1, 0);
        sut.addEdge(0, 2);
        sut.addEdge(6, 5);

        var connectionsString = sut.showConnections();

        // then
        assertThat(connectionsString).isEqualTo("""
                0-->1 2
                1-->3 2 0
                2-->4 1 0
                3-->1 4
                4-->3 2 5
                5-->4 6
                6-->5""");
        System.out.println(connectionsString);
    }
}
