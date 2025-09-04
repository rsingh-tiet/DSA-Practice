import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mereOverlap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read first line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // first number is n

        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine()); // read next line
            arr[j][0] = Integer.parseInt(st.nextToken());
            arr[j][1] = Integer.parseInt(st.nextToken());
         }

// ╔═╦╗╔╦╗╔═╦═╦╦╦╦╗╔═╗
// ║╚╣║║║╚╣╚╣╔╣╔╣║╚╣═╣ 
// ╠╗║╚╝║║╠╗║╚╣║║║║║═╣
// ╚═╩══╩═╩═╩═╩╝╚╩═╩═╝

// ▄▀ █▀▀▄ █▀▀ ▄▀▄ ▀█▀ ▄▀▄ █▀▀▄ ▄▀▀ 
// █░ █▐█▀ █▀▀ █▀█ ░█░ █░█ █▐█▀ ░▀▄ 
// ░▀ ▀░▀▀ ▀▀▀ ▀░▀ ░▀░ ░▀░ ▀░▀▀ ▀▀

        
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j][0] + " " + arr[j][1]);
        }
        // Sorting

    }
}
