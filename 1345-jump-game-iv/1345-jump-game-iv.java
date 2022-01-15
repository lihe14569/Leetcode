class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> indiceValue = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            indiceValue.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // add the start `posiiton
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                
                int node = q.poll();
                if(node == arr.length - 1) return depth;
                List<Integer> values = indiceValue.get(arr[node]);
                values.add(node - 1);
                values.add(node + 1);
                
                for(int j : values) {
                    if(j >= 0 && j < arr.length && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                values.clear();
            }
            depth++;
        }
        return 0;
    }
}