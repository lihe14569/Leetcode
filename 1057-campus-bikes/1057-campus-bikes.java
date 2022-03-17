class Solution {
    int[] closestBikeIndex = new int[1001];
    List<List<int[]>> bikeWorkerList = new ArrayList<>();
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < workers.length; i++) {
            List<int[]> bikeList = new ArrayList<>();
            int[] worker = workers[i];
            for(int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int distance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                bikeList.add(new int[]{distance, j});
            }
            Collections.sort(bikeList, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            bikeWorkerList.add(bikeList);
            closestBikeIndex[i] = 0;
            addClosestBikeToPq(pq, i);
        }
        boolean[] takenBikes = new boolean[bikes.length];
        int[] takenWorkers = new int[workers.length];
        Arrays.fill(takenWorkers, -1);
        
        
        while(!pq.isEmpty()) {
            int[] workerBike = pq.poll();
            int worker = workerBike[1];
            int bike = workerBike[2];
            if(takenWorkers[worker] == -1 && !takenBikes[bike]) {
                takenWorkers[worker] = bike;
                takenBikes[bike] = true;
            } else {
                addClosestBikeToPq(pq, worker);
            }
        }
        return takenWorkers;
    }
    public void addClosestBikeToPq(PriorityQueue<int[]> pq, int worker) {
        int[] closestBike = bikeWorkerList.get(worker).get(closestBikeIndex[worker]);
        closestBikeIndex[worker]++;
        int[] workBikePair = new int[]{closestBike[0], worker, closestBike[1]};
        pq.offer(workBikePair);
    }
}