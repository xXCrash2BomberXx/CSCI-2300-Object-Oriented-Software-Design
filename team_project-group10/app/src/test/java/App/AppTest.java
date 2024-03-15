package App;

import App.Model.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testStartCube () {
        Model model = new Model();
        assertTrue(model.isSolved());
    }

    @Test
    public void testColumnRotation () {
        Model model = new Model();
        assertTrue(model.isSolved());
        model.rotateColumnUp(200, 0, true);
        assertFalse(model.isSolved());
        model.rotateColumnDown(200, 0, true);
        assertTrue(model.isSolved());
    }

    @Test 
    public void testRowRotation() {
        Model model = new Model();
        assertTrue(model.isSolved());
        model.rotateRowLeft(0, 200, true);
        assertFalse(model.isSolved());
        model.rotateRowRight(0, 200, true);
        assertTrue(model.isSolved());
    }

    @Test 
    public void testFrontRotation() {
        Model model = new Model();
        model.rotateFrontCounterClockwise(true);
        assertFalse(model.isSolved());
        model.rotateFrontClockwise(true);
        assertTrue(model.isSolved());
    }

    @Test
    public void testDoubleRotation() {
        Model model = new Model();
        model.rotateFrontClockwise(true);
        model.rotateColumnUp(200, 0, true);
        assertFalse(model.isSolved());
    }

    @Test
    public void testFullRevolution() {
        Model model = new Model();
        for (int i = 0; i < 4; i++) {
            model.rotateColumnUp(200, 0, true);
        }
        assertTrue(model.isSolved());
    }

    @Test 
    public void testShuffle() {
        Model model = new Model();
        model.randomizeCube();
        assertFalse(model.isSolved());
    }
}
