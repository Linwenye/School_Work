#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long inverse_str(int start, int end);
int my_str_comp(char* a, char* b, int length);
char* my_str_copy(char*a);
long merge(int start, int end);
vector<char*> vec;

int main() {

	long res;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		char *a = new char[11];
		cin >> a;
		vec.push_back(a);
	}
	res = inverse_str(0, n - 1);
	cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;
	cout << res;
}

long inverse_str(int start, int end) {

	long pair_count = 0;
	if (start < end) {
		int mid = (start + end) / 2;
		pair_count+=inverse_str(start, mid);
		pair_count+=inverse_str(mid+1, end);
		pair_count+=merge(start, end);
	}
	return pair_count;
}

long merge(int start, int end) {
	long res = 0;
	vector<char*> tmp;
	// 0 1 2 3 4  mid:2
	int mid = (start + end) / 2;
	int p1 = start;
	int p2 = mid + 1;
	while (p1 <= mid&&p2 <= end) {
		int comp = my_str_comp(vec[p1], vec[p2], 10);

		if (comp <=0) {
			tmp.push_back(vec[p1]);
			p1++;
		}
		else {
			// add reverse count:nums left in the previous array
			res += mid - p1 + 1;
			tmp.push_back(vec[p2]);
			p2++;
		}
	}
	while (p1 <= mid) {
		tmp.push_back(vec[p1]);
		p1++;
	}	
	while (p2 <= end) {
		tmp.push_back(vec[p2]);
		p2++;
	}

	int j = 0;
	for (int i = start; i <= end; i++) {
		
		vec[i] = tmp[j++];
	}
	return res;
}

int my_str_comp(char* a, char* b, int length) {
	for (int i = 0; i < length; i++) {
		if (a[i] < b[i]) {
			return -1;
		}
		else if (a[i] > b[i]) {
			return 1;
		}
	}
	return 0;
}

char* my_str_copy(char*a) {
	char res[10];
	for (int i = 0; i < 10; i++) {
		res[i] = a[i];
	}
	return res;
}
