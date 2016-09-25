package ca.ostrowski.acupofjava;

import java.util.Arrays;

public class Arrays {
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4};
        MyArr arr = new MyArr(integerArray);
        System.out.println(arr.toString());
        arr.add(10, 2);
        System.out.println(arr.toString());
        arr.remove(1);
        System.out.println(arr.toString());
    }
    static class MyArr {
        public Integer[] arr;

        public MyArr(Integer[] arr) {
            this.arr = arr;
        }

        @Override
        public String toString() {
            return "MyArr{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }

        public void add(int elem, int pos) {
            if (pos >= 0 && pos < arr.length) {
                //if something is already occupying the pos desired
                if (arr[pos] != null) {
                    //create new array with one additional slot
                    Integer[] temp = new Integer[arr.length * 2];
                    for (int i = 0; i < arr.length; i++) {
                        if (i >= pos) {
                            temp[i + 1] = arr[i];
                        } else {
                            //copy data to new array before pos
                            temp[i] = arr[i];
                        }
                    }
                    arr = temp;

                    temp[pos] = elem;
                } else {
                    arr[pos] = elem;
                }
            }
        }

        public void remove(int pos) {
            if (pos >= 0 && pos < arr.length) {
                if (arr[pos] == null) {
                    System.out.println("There is no element in that position");
                    return;
                }
                Integer[] temp = new Integer[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    if (i > pos) {
                        temp[i - 1] = arr[i];
                    } else if ( i < pos){
                        temp[i] = arr[i];
                    }
                }
                arr = temp;
            }
        }
    }
}
