// https://leetcode.com/problems/car-fleet/
// https://youtu.be/Pr6T-3yB9RM?si=ua_WvjBtTP03wcrQ

/*
Time Complexity: O(n log n) where n = length of list. List is sorted in reverse order.

Space Complexity: O(n) where n = length of list.
*/

class Solution {

    private List<Pair<Double, Double>> generateOneList(int[] position, int[] speed) {
        List<Pair<Double, Double>> result = new ArrayList<>();
        
        for (int i = 0; i < position.length; i++) {
            Double posAsDble = Double.valueOf(position[i]);
            Double speedAsDble = Double.valueOf(speed[i]);

            Pair<Double, Double> newCar = new Pair(posAsDble, speedAsDble);

            result.add(newCar);
        }

        return result;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Double, Double>> cars = generateOneList(position, speed);

        // Sort list by each car's position in reverse order
        cars.sort(Comparator.comparing(Pair<Double,Double>::getKey).reversed());

        // Create a stack that will only hold lead of each fleet
        Double targetAsInt = Double.valueOf(target);
        Stack<Double> stack = new Stack<>();

        // Iterate list        
        for (Pair<Double, Double> car: cars) {

            // Arrival Time = (target - position) / speed
            Double arrivalTime = (targetAsInt - car.getKey()) / car.getValue();
            stack.push(arrivalTime);

            // If car behind is moving faster than car ahead, both become a fleet.
            // ONLY keep the slowest car aka (2nd to last car).
            int size = stack.size();
            if (size >= 2 && stack.get(size - 1) <= stack.get(size - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
