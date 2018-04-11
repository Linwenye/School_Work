#include <iostream>
#include <vector>

using namespace std;

void quick_sort(int start, int end);
void my_swap(int a, int b);

vector<int> vec;
int range_s, range_e;
int main() {

	int k, n;
	cin >> k >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		vec.push_back(tmp);
	}

	range_s = (n + 1) / 2 - k - 1;
	int i = range_s;

	range_e = (n + 1) / 2 + k - 1;

	quick_sort(0, n - 1);

	cout << vec[i];
	i = i + 1;
	for (; i < range_e + 1; i++) {
		cout << ' ' << vec[i];
	}
	return 0;
}

void quick_sort(int start, int end) {
	if (start < end && start<=range_e&&end>=range_s) {
		int cursor = start;

		// use the last num as the pivot
		for (int i = start; i <= end - 1; i++) {
			if (vec[i] < vec[end]) {
				my_swap(i, cursor);
				cursor++;
			}
		}
		my_swap(cursor, end);
		quick_sort(start,cursor-1);
		quick_sort(cursor + 1, end);
	}
}

void my_swap(int a, int b) {
	int t = vec[a];
	vec[a] = vec[b];
	vec[b] = t;
}

