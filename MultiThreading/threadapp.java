import java.util.Arrays;

class SortingThread extends Thread {
    private final int[] arr;

    SortingThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        System.out.println("[SortingThread] sorted: " + Arrays.toString(copy));
    }
}

class SearchingThread extends Thread {
    private final int[] arr;
    private final int key;

    SearchingThread(int[] arr, int key) {
        this.arr = arr;
        this.key = key;
    }

    @Override
    public void run() {
        boolean found = false;
        for (int x : arr) {
            if (x == key) {
                found = true;
                break;
            }
        }
        System.out.println("[SearchingThread] key " + key + (found ? " found" : " not found"));
    }
}

class ResultThread extends Thread {
    private final int[] arr;

    ResultThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println("[ResultThread] input array: " + Arrays.toString(arr));
    }
}

class check {
    public static void main(String[] args) throws InterruptedException {
        int[] values = {5, 1, 8, 3, 7};

        Thread t1 = new SortingThread(values);
        Thread t2 = new SearchingThread(values, 3);
        Thread t3 = new ResultThread(values);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Main done");
    }
}
