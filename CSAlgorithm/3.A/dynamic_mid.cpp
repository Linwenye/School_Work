#include <iostream>
#include <stdio.h>
#include <vector>
#include <queue>
#include <functional>
using namespace std;

/*
   scanf and printf more efficient than cin and cout

   using heap to dynamically get the mid num
*/

void print_mid();
void balance_size();

priority_queue<int> max_heap; //left part
priority_queue<int, vector<int>, greater<int> > min_heap; //right(greater) part

int main() {
	int num = 0;
	while (scanf("%d", &num) != EOF) {
		// insert to heap
		if (max_heap.empty()) {
			max_heap.push(num);
		}
		else {
			// choose to insert to exact side and  
			if (num >= max_heap.top()) {
				min_heap.push(num);
			}
			else {
				max_heap.push(num);
			}

			// maintain left and right size
			balance_size();

		}
		print_mid();
	}

	return 0;
}


void print_mid() {
	printf("%d ", max_heap.top());
}

void balance_size() {
	if ((int)max_heap.size() - (int)min_heap.size() > 1)
	{
		min_heap.push(max_heap.top());
		max_heap.pop();
	}
	else if (min_heap.size() > max_heap.size())
	{
		max_heap.push(min_heap.top());
		min_heap.pop();
	}
}