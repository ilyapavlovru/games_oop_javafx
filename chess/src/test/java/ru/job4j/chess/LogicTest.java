package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class LogicTest {
    @Test
    public void whenBishopCannotGoToAnotherBishop() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.D2);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.F4);
        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        boolean result = logic.move(bishopBlack1.position(), bishopBlack2.position());
        assertThat(result, is(false));
    }

    @Test
    public void whenBishopCannotGoOverAnotherFigure() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.D2);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.F4);
        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        Cell newPosition = Cell.H6;
        boolean result = logic.move(bishopBlack1.position(), newPosition);
        assertThat(result, is(false));
    }
}
