package de.hawlandshut.iterablearray2D;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableArray2D implements Iterable<Double> {
    private final double[][] a2d;

    public IterableArray2D(double[][] doubles) {
        if(doubles == null)
            throw new IllegalArgumentException();
        for(double[] arrays : doubles)
            if(arrays == null || arrays.length == 0)
                throw new IllegalArgumentException();
        this.a2d = doubles;
    }

    public Iterator<Double> iterator() {
        return new Array2DIterator();
    }

    private class Array2DIterator implements Iterator<Double>{
        int arrayIndex = 0;
        int numberIndex = 0;
        int totalNumberIndex = 0;
        int maxNumberIndex = 0;

        private Array2DIterator(){
            for (double[] arrays : IterableArray2D.this.a2d)
                for(double numbers : arrays)
                    maxNumberIndex += 1;
        }

        @Override
        public boolean hasNext() {
            return totalNumberIndex < maxNumberIndex;
        }

        @Override
        public Double next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if(numberIndex == IterableArray2D.this.a2d[arrayIndex].length) {
                numberIndex = 0;
                arrayIndex += 1;
            }
            totalNumberIndex++;
            return IterableArray2D.this.a2d[arrayIndex][numberIndex++];
        }
    }
}
