import java.util.Scanner;

public class shellRotate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no of rows:");
        int row = scn.nextInt();
        System.out.println("Enter no of cols:");
        int col = scn.nextInt();

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Enter element at row %d col %d: ", i + 1, j + 1);
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println("\nOriginal Array:");
        display(arr);

        System.out.println("Enter shell number (1-based):");
        int s = scn.nextInt();
        System.out.println("Enter rotation count:");
        int r = scn.nextInt();

        rotateShell(arr, s, r);

        System.out.println("\nArray after rotation:");
        display(arr);

        scn.close();
    }

    public static void rotateShell(int[][] arr, int s, int r) {
        // to 1D
        int[] oneD = shellTo1D(arr, s);
        System.out.println("Shell in 1D before rotation:");
        for (int val : oneD) System.out.print(val + " ");
        System.out.println();

        // rotate
        rotate(oneD, r);

        System.out.println("Shell in 1D after rotation:");
        for (int val : oneD) System.out.print(val + " ");
        System.out.println();

        // update 2D
        updateShell(arr, s, oneD);
    }

    public static int[] shellTo1D(int[][] arr, int s) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;

        int size = 2 * (maxRow - minRow + maxCol - minCol);
        int[] oneD = new int[size];
        int idx = 0;

        // left wall
        for (int i = minRow; i <= maxRow; i++) {
            oneD[idx++] = arr[i][minCol];
        }

        // bottom wall
        for (int j = minCol + 1; j <= maxCol; j++) {
            oneD[idx++] = arr[maxRow][j];
        }

        // right wall
        for (int i = maxRow - 1; i >= minRow; i--) {
            oneD[idx++] = arr[i][maxCol];
        }

        // top wall
        for (int j = maxCol - 1; j > minCol; j--) {
            oneD[idx++] = arr[minRow][j];
        }

        return oneD;
    }

    public static void updateShell(int[][] arr, int s, int[] oneD) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;

        int idx = 0;

        // left wall
        for (int i = minRow; i <= maxRow; i++) {
            arr[i][minCol] = oneD[idx++];
        }

        // bottom wall
        for (int j = minCol + 1; j <= maxCol; j++) {
            arr[maxRow][j] = oneD[idx++];
        }

        // right wall
        for (int i = maxRow - 1; i >= minRow; i--) {
            arr[i][maxCol] = oneD[idx++];
        }

        // top wall
        for (int j = maxCol - 1; j > minCol; j--) {
            arr[minRow][j] = oneD[idx++];
        }
    }

    public static void rotate(int[] oneD, int r) {
        r = r % oneD.length;
        if (r < 0) {
            r += oneD.length;
        }
        reverse(oneD, 0, oneD.length - r - 1);
        reverse(oneD, oneD.length - r, oneD.length - 1);
        reverse(oneD, 0, oneD.length - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void display(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
