import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static junit.framework.TestCase.assertEquals;

public class TriangleClassifierTest {

    @Test
    @DisplayName("Testing triangle")
    public void testTriangle() {
        int a = 4, b = 2, c = 5;

        String expected = "tam giác thường";
        TriangleClassifier triangle = new TriangleClassifier(a, b, c);
        String result = triangle.classify();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing Isosceles Triangle")
    public void testIsoscelesTriangle() {
        int a = 4, b = 4, c = 5;

        String expected = "tam giác cân";
        TriangleClassifier triangle = new TriangleClassifier(a, b, c);
        String result = triangle.classify();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing Equilateral Triangle")
    public void testEquilateralTriangle() {
        int a = 4, b = 4, c = 4;

        String expected = "tam giác đều";
        TriangleClassifier triangle = new TriangleClassifier(a, b, c);
        String result = triangle.classify();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing Square Triangle")
    public void testSquareTriangle() {
        int a = 3, b = 4, c = 5;

        String expected = "tam giác vuông";
        TriangleClassifier triangle = new TriangleClassifier(a, b, c);
        String result = triangle.classify();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing not Triangle")
    public void testNotTriangle() {
        int a = 3, b = 4, c = 50;

        String expected = "không phải là tam giác";
        TriangleClassifier triangle = new TriangleClassifier(a, b, c);
        String result = triangle.classify();
        assertEquals(expected, result);
    }

}
