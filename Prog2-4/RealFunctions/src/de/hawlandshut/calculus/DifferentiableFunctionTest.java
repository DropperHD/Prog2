import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

import de.hawlandshut.calculus.*;

public class DifferentiableFunctionTest {
    @Test public void testDifferentiable() {
      assertTrue(
          "Differentiable must be interface",
          Differentiable.class.isInterface());
    }

    @Test public void testDiffExceptionType(){
      assertEquals(
          "DiffException must derive from Exception",
          DiffException.class.getSuperclass(),
          Exception.class);
    }

    @Test public void testConstantDiff() throws DiffException{
      Constant f = new Constant(3);

      assertTrue("Constant must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      assertTrue(d instanceof Constant);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.evaluateAt(x), 0, 1e-10);
      }
      

    }

    @Test public void testCubicPolynomialDiff() throws DiffException{
      CubicPolynomial f = new CubicPolynomial(-4,3,-2,1);

      assertTrue("CubicPolynomial must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      assertTrue(d instanceof CubicPolynomial);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.evaluateAt(x), -12*x*x+6*x-2, 1e-10);
      }
      

    }

    @Test public void testSineDiff() throws DiffException{
      Sine f = new Sine(2,3);

      assertTrue("Sine must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      assertTrue(d instanceof Cosine);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.evaluateAt(x), 6*Math.cos(3*x), 1e-10);
      }
      

    }

    @Test public void testCosineDiff() throws DiffException{
      Cosine f = new Cosine(2,3);

      assertTrue("Cosine must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      assertTrue(d instanceof Sine);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.evaluateAt(x), -6*Math.sin(3*x), 1e-10);
      }
      

    }

    @Test public void testExpDiff() throws DiffException{
      Exp f = new Exp();

      assertTrue("Exp must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      assertTrue(d instanceof Exp);

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.evaluateAt(x), Math.exp(x), 1e-10);
      }
      

    }

    @Test public void testLogDiff() throws DiffException{
      Log f = new Log();

      assertTrue("Exp must implement Differentiable", f instanceof Differentiable);

      RealFunction d = f.derive();

      for (double x = -10; x < 10; x+=0.1){
        assertEquals(d.inDomain(x), x > 0);
        if (d.inDomain(x))
          assertEquals(d.evaluateAt(x), 1/x, 1e-10);
      }
      

    }

}


