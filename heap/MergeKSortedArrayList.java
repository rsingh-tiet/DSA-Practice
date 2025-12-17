import java.util.*;

public class MergeKSortedArrayList {

    static class Pair {
        int val;
        int listIndex;
        int elementIndex;

        Pair(int val, int listIndex, int elementIndex) {
            this.val = val;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }
// we can have comparable class that is implemented on pair 
// then we can have comparable
    public static ArrayList<Integer> mergeKLists(ArrayList<ArrayList<Integer>> lists) {

        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // 1. Put the first element of each list in min-heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new Pair(lists.get(i).get(0), i, 0));
            }
        }

        // 2. Process heap
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            result.add(p.val);

            int nextIndex = p.elementIndex + 1;

            // Push next element from same list
            if (nextIndex < lists.get(p.listIndex).size()) {
                pq.add(new Pair(
                    lists.get(p.listIndex).get(nextIndex),
                    p.listIndex,
                    nextIndex
                ));
            }
        }

        
        return result;
    }

    // 
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        lists.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11)));
        lists.add(new ArrayList<>(Arrays.asList(2, 5, 8)));
        lists.add(new ArrayList<>(Arrays.asList(3, 6, 9)));

        ArrayList<Integer> merged = mergeKLists(lists);

        System.out.println(merged);
    }
}
