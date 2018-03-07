package base.ui;

import base.BacUnit;
import base.engine.BattleField;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 * Отображение состояния игрового поля.
 */
public final class Canvas extends JComponent {

    private int dimension;

    private int scale;

    private Dimension size;

    private BattleField battleField;

    private Observer<Integer> dimensionObserver;

    private List<Square> squares = Collections.emptyList();

    Canvas(final Observable<Integer> dimensionSource, int scale) {
//        this.dimension = dimension;
        this.scale = scale;
        dimensionObserver = new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer integer) {
                setDimension(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        dimensionSource.subscribe(dimensionObserver);

//        size = new Dimension(dimension * scale, dimension * scale);
//        setSize(size);
        clearDisplay();
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (Square square : squares) {
            g2d.setPaint(square.getColor());
            g2d.drawRect(square.getX(), square.getY(), square.getSize(), square.getSize());
            g2d.fillRect(square.getX(), square.getY(), square.getSize(), square.getSize());
        }
    }

    @Override
    public Dimension getMinimumSize() {
        return size;
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    @Override
    public Dimension getMaximumSize() {
        return size;
    }

    void setScale(int scale) {
        this.scale = scale;
        resize();
    }

    void setDimension(int dimension) {
        this.dimension = dimension;
        resize();
    }

    private void resize() {
        this.size = new Dimension(dimension * scale, dimension * scale);
        setSize(size);
        clearDisplay();
    }

    public void clearDisplay() {
        squares = Collections.singletonList(new Square(0, 0, dimension * scale, Color.black));
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }
}
