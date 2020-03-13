package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

//        if (!isDiagonal(source, dest)) {
//            throw new IllegalStateException(
//                    String.format("Could not way by diagonal from %s to %s", source, dest)
//            );
//        }


        int size = abs(dest.x - source.x) + 1;  // количество шагов-клеток для перемещения фигуры
        Cell[] steps = new Cell[size];
        steps[0] = source;
        int deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : -1;
        for (int index = 1; index < size; index++) {
            int x = steps[index - 1].x + deltaX;
            int y = steps[index - 1].y + deltaY;
            steps[index] = Cell.findBy(x,y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
