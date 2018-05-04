#include <stdio.h>
#include <map>
#include <algorithm>
using namespace std;

/*
树的最长路径！不一定通过根节点
*/
int *prefix;
int *infix;
int n = 0;

int prefix_point;

int left_height;
int right_height;

map<int, int> infix_map;

int get_prefix_inorder() {
	return infix_map[prefix[prefix_point++]];
}
int _height_seek(int start, int end) {
	if (start > end)
	{
		return 0;
	}
	else if (start == end) {
		prefix_point++;
		return 1;
	}
	else {
		int node_i = get_prefix_inorder();
		int left = _height_seek(start, node_i - 1);
		int right = _height_seek(node_i + 1, end);
		return 1 + max(left, right);
	}
}
void height_seek() {
	int node_i = get_prefix_inorder();
	left_height = _height_seek(0, node_i - 1);
	right_height = _height_seek(node_i + 1, n - 1);
}

int main() {
	scanf("%d", &n);

	prefix = new int[n];
	infix = new int[n];

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &prefix[i]);
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &infix[i]);
		infix_map[infix[i]] = i;
	}
	height_seek();

	delete[]prefix;
	delete[]infix;
	printf("I have read the rules about plagiarism punishment\n");
	printf("%d\n", max(left_height, right_height));
	printf("%d", left_height + right_height);
	return 0;
}

