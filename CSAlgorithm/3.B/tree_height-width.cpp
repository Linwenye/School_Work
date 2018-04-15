//#include <stdio.h>
//#include <map>
//using namespace std;
//
//
//int * prefix;
//int * infix;
//int n;
//
//int prefix_point;
//
//
//struct node
//{
//	int key_value;
//	node *left;
//	node *right;
//};
//
//class btree
//{
//public:
//	// use prefix order and infix order to construct tree
//	btree(int *prefix, int *infix ,int n);
//	int height;
//	int width;
//private:
//	node* root;
//};
//
//btree::btree(int *prefix, int *infix, int n)
//{
//	map<int, int> infix_map;
//	root = new node;
//
//	for (int i=0;i<n;i++)
//	{
//		infix_map[infix[i]]=i;
//	}
//
//	for (int i=0;i<n;i++)
//	{
//		root->key_value = prefix[0];
//		//prefix[i]
//	}
//}
//
//node* construct_tree(int start, int node_i, int end) {
//
//}
//int main() {
//	int n = 0;
//	scanf("%d", &n);
//	printf("I have read the rules about plagiarism punishment\n");
//
//	int *prefix = new int[n];
//	int *infix = new int[n];
//	
//	for (int i = 0; i < n; i++)
//	{
//		scanf("%d", &prefix[i]);
//	}	
//	for (int i = 0; i < n; i++)
//	{
//		scanf("%d", &infix[i]);
//	}
//
//	btree *mytree = new btree(prefix, infix, n);
//	printf("%d\n", mytree->height);
//	printf("%d", mytree->width);
//	return 0;
//}
//
