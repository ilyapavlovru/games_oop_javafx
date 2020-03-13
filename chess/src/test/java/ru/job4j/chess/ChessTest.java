package ru.job4j.chess;

import org.hamcrest.core.Is;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class ChessTest {
    @Test
    public void whenBishopBlackHasSourcePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = Cell.C1;
        Cell result = bishopBlack.position();
        assertThat(result, is(expected));
    }

    @Test
    public void whenBishopBlackCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = Cell.D2;
        BishopBlack bb = (BishopBlack) bishopBlack.copy(Cell.D2);
        Cell result = bb.position();
        assertThat(result, is(expected));
    }

    @Test
    public void whenBishopGoFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D2);
        Cell[] result = bishopBlack.way(bishopBlack.position(), Cell.G5);  //  D2, E3, F4, G5
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void whenBishopGoNoDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D2);
        Cell[] result = bishopBlack.way(bishopBlack.position(), Cell.F2);
    }

    @Test
    public void whenBishopCannotGoToAnotherBishop() {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.D2);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.F4);
//        Cell[] result = bishopBlack1.way(bishopBlack1.position(), bishopBlack2.position());
//        Cell[] expected = {bishopBlack1.position()};
//        assertThat(result, is(expected));

        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        boolean result = logic.move(bishopBlack1.position(), bishopBlack2.position());
        assertThat(result, is(false));
    }
}
