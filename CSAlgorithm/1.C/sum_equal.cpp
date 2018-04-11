#include <iostream>
#include <vector>
using namespace std;
int main() {
	int n;
	cin >> n;
	vector<int> arr(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int num;
	cin >> num;
	int start = 0;
	int end = n-1;

	while (1) {
		if (start >= end) {
			break;
		}
		int sum = arr[start] + arr[end];
		if ( sum == num) {
			cout << arr[start] << ' ' << arr[end] << endl;
			start++;
			end--;
		}
		else if (sum < num) {
			start++;
		}
		else {
			end--;
		}
	}

	return 0;

}