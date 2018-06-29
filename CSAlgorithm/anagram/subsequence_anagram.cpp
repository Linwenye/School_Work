//#include <stdio.h>
//#include <string>
//
//using namespace std;
//string str_arr;
//unsigned short *res;
//int main() {
//	str_arr = "";
//	res = 0;
//	char tmp;
//	while (scanf("%c", &tmp) != EOF)
//	{
//		str_arr.push_back(tmp);
//	}
//	int n = str_arr.length();
//	for (unsigned int i = 0; i < n; ++i)
//	{
//		//i as the center
//		unsigned int tmp_length = 1;
//		unsigned int distance_p = 1;
//		while (true)
//		{
//			if (i - distance_p<0 || i + distance_p>str_arr.length())
//			{
//				break;
//			}
//			else if (str_arr[i - distance_p] == str_arr[i + distance_p])
//			{
//				tmp_length += 2;
//				distance_p++;
//			}
//			else {
//				break;
//			}
//		}
//
//		// between i and i-1 as center
//		tmp_length = 0;
//		distance_p = 0;
//		while (true)
//		{
//			if (i - 1 - distance_p<0 || i + distance_p>str_arr.length())
//			{
//				break;
//			}
//			else if (str_arr[i - 1 - distance_p] == str_arr[i + distance_p])
//			{
//				tmp_length += 2;
//				distance_p++;
//			}
//			else {
//				break;
//			}
//		}
//	}
//
//	printf("I have read the rules about plagiarism punishment\n");
//	printf("%hu", res);
//	printf("d");
//}