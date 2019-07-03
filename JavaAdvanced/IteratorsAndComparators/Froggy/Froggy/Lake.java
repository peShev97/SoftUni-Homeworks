package IteratorsAndComparators.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    private int[] data;

    public Lake(int... data) {
        this.data = data;
    }

    private class LakeIterator implements Iterator<Integer> {
        private int cursor = data.length == 0 ? 0 : -2;

        private boolean isEvenCursor() {
            return cursor % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenCursor() && data.length > 2) {
                return true;
            } else if (!isEvenCursor() && data.length > 2) {
                return cursor < data.length - 2;
            } else {
                return cursor < data.length - 1;
            }
        }

        @Override
        public Integer next() {
            cursor += 2;

            if (cursor > data.length - 1) {
                cursor = 1;
            }

            return data[cursor];
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LakeIterator();
    }
}