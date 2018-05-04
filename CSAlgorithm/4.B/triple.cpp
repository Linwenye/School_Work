#include <iostream>
#include <algorithm>
using namespace std;
int main() {
	int n, aim;
	cin >> n >> aim;
	int count=0;

	int *arr = new int[n];
	for (int i=0;i<n;i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n);
	for (int i=0;i<n-2;i++)
	{
		int left_pointer = i + 1;
		int right_pointer = n - 1;
		while (left_pointer<right_pointer)
		{
			int this_sum = arr[i] + arr[left_pointer] + arr[right_pointer];
			if (this_sum<aim)
			{
				left_pointer++;
			}
			else if (this_sum>aim)
			{
				right_pointer--;
			}
			else
			{
				left_pointer++;
				right_pointer--;
				count++;
			}
		}
	}
	cout << "wo yi yue du guan yu chao xi de shuo ming\n";
	cout << count;
	return 0;
}