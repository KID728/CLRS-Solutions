# ch2-Problems

## 2-1

a. In insertion sort, $T(n) = a*n^2 + b*n + c$, where $a, b, c$ are constants.So, $T(k) = a*k^2 + b*k + c$.All costs are $\frac nk *T(k)$ which is equal to $a*n*k + b*n + c*\frac nk$.

b. $T(n) - \frac nk*T(k) = c*n\lg n + c*n - \frac nk (c*k\lg k + c*k) = c*n*\lg(n/k)$

c. The largest value of $k$ is $\lg n$.

d. $k = \lg n$

## 2-2

b.

**Initialization**: We start by showing that the loop invariant holds before the first loop iteration, when $j = A.length$. The 3-4 steps ensure $A[j - 1] \leq A[j] $. So, $A[j - 1]$ is the least value in subarray $A[j - 1..A.length]$.

**Maintenance**: We assume that in $j$th iteration, $A[j-1]$ is the least value in subarray $A[j-1...A.length]$.Next, in $j -1$th iteration, because of $A[j - 2] \leq A[j -1]$, $A[j-2]$ is the least value in subarray $A[j-2..A.length]$.

**Termination**: At termination, $j = i + 1$, $A[i]$ is the least value in subarray $A[i..A.length]$.

c.

**Initialization**: Prior to the first iteration of the loop, we have $i = 1$, according to (b), $A[i]$ is the least value in subarray $A[i..A.length]$. Because the size of subarray $A[1..i] $ is $1$, we can consider that $A[1..i]$ is sorted.​

**Maintenance**: We assume that in $i$th iteration, $A[1..i]$ is sorted. And according to (b), $A[i]$ is the least value in subarray $A[i..A.length]$, we can deduce that $A[i] \leq A[i+1]$. Next, when $i+1$th iteration, $A[i+1]$ is the least one in $A[i + 1..A.length]$.So, $A[1..i+1]$ is sorted.

**Termination**: At termination, $i = A.length-1$. $A[1..A.length - 1]$ is sorted and $A[A.length - 1] \leq A[A.length]$.

d.

The worst-case running time of bubblesort is $\Theta(n^2)$

## 2-3

a. $\Theta(n)$

b.

1. $sum = 0$
2. **for** $i = 0$ **to** $n$
3. ​	$sum = sum + a_i*x^i$

consider computing $x^i$, the worst-case running time is $\Theta(n^2)$.

c.

**Initialization**: when $i = n$, $y = 0$

**Maintenance**:  At the start of the $i$th iteration, $y=\sum_{k=0}^{n - (i + 1)}a_(k+i+1) x^k$, after line 3:
$$
y = a_i + x* \sum_{k=0}^{n - (i + 1)}a_(k+i+1) x^k
$$

$$
y = a_i + \sum_{k=1}^{n - i}a_(k+i) x^k
$$

$$
y = \sum_{k=0}^{n-i} a_{k+i}x^k
$$

At the start of the $i - 1$th iteration, $y = \sum_{k=0}^{n-i} a_{k+i}x^k$, as same as the above deduction.

**Termination**: At the start of the least iteration  $i = 0$, $y = \sum_{k=0}^{n-1}a_(k+1)x^k$, after execute the next step:
$$
y =  a_0 + x* \sum_{k=1}^n a_kx^{k-1}
$$

$$
y =  \sum_{k=0}^n a_kx^k
$$

## 2-4

a. the five inversions of the array $\langle2,3,8,6,1 \rangle$

$pair(3, 4)$, $pair(1, 5)$, $pair(2, 5)$,$pair(3, 5)$, $pair(4, 5)$

b.

$\langle n, n-1,...,1 \rangle$

it have $\frac {n(n-1)}2$ numbers of inversions.

c.The inversions are more, the running time of insertion sort is longer.

d.Refer to *Introduction to algorithms [solutions].pdf*, [implement](../codes/src/com/kid/clrs/ch2/Problems4D.java) in Java.