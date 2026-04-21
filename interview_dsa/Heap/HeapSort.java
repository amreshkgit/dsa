package Heap;


import java.util.stream.IntStream;

/*
  Min heap - Parent node is always less equal to its child node
  Max heap - Parent node is always greater than or equal to child node

  Heap ki liye complete binary tree must hai , complete binary tree wo jiske pass all node has leaf node
  starting from left
  Yadi complete binary tree nahi hoga to linear array me convert karna difficult ho jayega

  For the heapify step, we're examining every item in the tree and moving it downwards until it's
  larger than its children.Since   our tree height is O(logN), we could do up to O(logN)moves.
  Across all n nodes , that's an overall time complexity of O(nlogn)
  Refer link - https://www.interviewcake.com/concept/java/heapsort
 */
public class HeapSort {
    //This input array may a array not heap so, we need to build the heap
    // if input provided as heap then we can skip the build heap
    public void sort(int heap[]) {
        int heapSize = heap.length;

        //Step 1. Build Heap Time complexity O(N)

        // Build heap (rearrange array) order of O(n) , we skip this part of input is heap
        //Here n is number of nodes in the array
        // n / 2 - 1 to 0 is all internal nodes
        //Range of internal nodes 0 to n/2 floor - 1
        //Range of leafs n/2 floor to n-1
        //here we are doing bottom up approach we can heapify index i if there left and right subtree is not heap
        //so we are making lower as heap in order to heapify the upper nodes
        //heapSize/2 -1 karne ka matable ye hai ki leaf node jo hai wo single node hai aur wo apne app me
        // complete binary tree hai to usko exclude kar rahe hai from build heap isliye start hamara n/2 se hoga
        // tree hamara distribute hota hai n, n/2, n/4 ...etc yadi hamara leaf node n/4 hai aur isko exclude kar
        //denge to start hamara n/2 se hoga na
        //ek aur baat build heap karte samay humlog right to left jayenge matlabe elment left se lete right ki
        //aur jayenge
        for (int i = heapSize / 2 - 1; i >= 0; i--)
            heapify(heap, i, heapSize);

        //Step 2. Extract Max
        // One by one extract an element from heap
        // extract max for n-1 if n number of element
        //This for loop is running from n-1 to 1
        for (int i = heapSize - 1; i > 0; i--) {
            // Move current root to end
            int temp = heap[0]; // swap heap root with last element
            heap[0] = heap[i]; // arr[i] is last element
            heap[i] = temp;

            // call max heapify on the reduced heap
            heapify(heap, 0,i); // here 0th element is root and i current size of heap
        }
    }

    void buildHeap(int arr[], int n)
    {
        // Index of last non-leaf node
        //(n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        // if we will heapify just internal nodes then our entire array will be heap
        //if we apply heapify left to right that mean top down in tree
        //heapify the nodes near the leaves first because their left and right subtree
        //will be following the heap property and heapify the parent internal nodes(bottom up approach)
        // (n / 2) - 1 to 0 is nothing but internal nodes, we are moving reverse order that bottom up order
        //we can't heapify given index i until there left and right subtree is not a heap that is reason we trying
        // to make lower as heap in order to heapify upper nodes
        //because in worst case we moving from o the node to furthest node
        // which nothing but height of the tree and we peforming this opertaion to all internal nodes i.e. n/2
        //
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    // Time complexity n(logN) space o(logN)
    void heapify(int heap[], int curr, int heapSize) {
        /**
         *  There is two stopping condition
         *  1. reach leaf
         *  2. cur element is > left and cur element is greater > Right
         */
        int largest = curr;  // Initialize largest as root
        int l = 2 * curr + 1;  // left child = 2*i + 1
        int r = 2 * curr + 2;  // right child= 2*i + 2

        // If left child is larger than root
        if (l < heapSize && heap[l] > heap[largest]) // to check if we hit leaf node l < heapSize
            largest = l;

        // If right child is larger than largest so far
        if (r < heapSize && heap[r] > heap[largest]) // // to check if we hit leaf node r < heapSize
            largest = r;

        // If largest is not root
        if (largest != curr) {
            int tmp = heap[curr];
            heap[curr] = heap[largest];
            heap[largest] = tmp;

            // Recursively heapify the affected sub-tree
            heapify(heap, largest,heapSize);
        }
    }

    //Use min heapify to sort element by desc
    void minHeapify(int heap[], int curr, int heapSize) {
        int smallest = curr;  // Initialize smallest as root
        int l = 2 * curr + 1;  // left child = 2*i + 1
        int r = 2 * curr + 2;  // right child= 2*i + 2

        // If left child is larger than root
        if (l < heapSize && heap[l] < heap[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < heapSize && heap[r] < heap[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != curr) {
            int tmp = heap[curr];
            heap[curr] = heap[smallest];
            heap[smallest] = tmp;

            // Recursively heapify the affected sub-tree
            minHeapify(heap, smallest,heapSize);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
       //Arrays.stream(arr).collect(Collectors.joining(","));
        IntStream.of(arr).forEach(e -> System.out.print(e+" "));
       /* int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();*/
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] arr1 = {1, 14, 10, 8, 7};
        int[] arr3 = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        int n = arr3.length;

        //buildHeap(arr, n);

        //printHeap(arr, n);


        HeapSort ob = new HeapSort();
        ob.sort(arr);
        //ob.buildHeap(arr3,n);

        //System.out.println("Sorted array is");
        printArray(arr);

    }
}