class SnakeGame {
    LinkedList<Position> snake;
    int[][] food;
    int w;
    int h;
    int foodCount;
    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        this.food = food;
        foodCount = 0;
        snake = new LinkedList<>();
        snake.add(new Position(0, 0));
    }
    
    public int move(String direction) {
        Position head = snake.getFirst();
        Position newHead = new Position(head.x, head.y);
        Position tail = snake.removeLast();
        //判断方向
        if(direction.equals("U")) newHead.x--;
        else if(direction.equals("L")) newHead.y--;
        else if(direction.equals("R")) newHead.y++;
        else newHead.x++;
        //判断是否合理
        if(newHead.x < 0 || newHead.x == h || newHead.y < 0 || newHead.y == w || snake.contains(newHead))
            return -1;
        //判断是否吃到
        snake.addFirst(newHead);
        if(foodCount < food.length && newHead.x == food[foodCount][0] && newHead.y == food[foodCount][1]) {
            snake.addLast(tail);
            foodCount++;
        }
        return foodCount;
    }
}
class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        Position obj = (Position) o;
        if(this.x == obj.x && this.y == obj.y) return true;
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */