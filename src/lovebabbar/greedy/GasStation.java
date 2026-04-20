package lovebabbar.greedy;

/**
 * Initialization:
 * tank: Tracks the current gas in the tank as you traverse the stations.
 * total: Tracks the net gas balance for the entire trip.
 * start: Tracks the starting index of the gas station.
 *
 * Logic:
 * Iterate through all gas stations.
 * Calculate the net gas at each station (consume = gas[i] - cost[i]).
 * Add consume to tank (current gas balance) and total (overall gas balance).
 * If tank becomes negative, it means you cannot reach the next station from the current starting point. Reset tank to 0 and set start to the next station (i + 1).
 *
 * Final Check:
 * If total (overall gas balance) is negative, return -1 because completing the circuit is impossible.
 * Otherwise, return start, which is the index of the gas station to start the journey.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, start = 0; //start will give from where to start
        for (int i = 0; i < gas.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
            total += consume;
        }
        return total < 0 ? -1 : start;
    }
}
