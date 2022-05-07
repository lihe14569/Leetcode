method1 brute force i, j k represents three numbers
method2:
1. 首先我们判断 a[i]a[i] 是否可以作为 11。如果 a[i] < \textit{max\_k}a[i]<max_k，那么它就可以作为 11，我们就找到了一组满足 132132 模式的三元组；
​
2. 随后我们判断 a[i]a[i] 是否可以作为 33，以此找出哪些可以真正作为 22 的元素。我们将 a[i]a[i] 不断地与单调栈栈顶的元素进行比较，如果 a[i]a[i] 较大，那么栈顶元素可以真正作为 22，将其弹出并更新 \textit{max\_k}max_k；
​
3.最后我们将 a[i]a[i] 作为 22 的候选元素放入单调栈中。这里可以进行一个优化，即如果 a[i] \leq \textit{max\_k}a[i]≤max_k，那么我们也没有必要将 a[i]a[i] 放入栈中，因为即使它在未来被弹出，也不会将 \textit{max\_k}max_k 更新为更大的值。
​
4.在枚举完所有的元素后，如果仍未找到满足 132132 模式的三元组，那就说明其不存在。
​
链接：https://leetcode-cn.com/problems/132-pattern/solution/132mo-shi-by-leetcode-solution-ye89/
​
​