#include<iostream>
using namespace std;
int main() {
	int c;
	int max = 0, sum = 0;
	while (cin >> c) {
		sum += c;
		if (sum > max) {
			max = sum;
		}
		else if (sum < 0) {
			sum = 0;
		}
	}
	cout << max;
}