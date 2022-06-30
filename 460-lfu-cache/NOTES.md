}
​
Node node = new Node(key, value);
DLList curList = freq.getOrDefault(1, new DLList());
curList.addHead(node);
size++;
​
if (size > capacity) {
if (curList.len > 1) {
curList.removeTail();
} else {
for (int i = 2; i <= maxFreq; i++) {
if (freq.get(i) != null && freq.get(i).len > 0) {
freq.get(i).removeTail();
break;
}
}
}
​
size--;
}
​
freq.put(1, curList);
}
}
```