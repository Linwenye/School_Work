#include "GPIOlib.h"
#include <cstdio>
#include <cmath>
using namespace std;
using namespace GPIO;

void stop(){

	stopLeft();
	stopRight();
	delay(1000);
}

int main()
{
	init();
	double allDistanceLeft = 0.0;
	double allDistanceRight = 0.0;
	//Move forward
	for(int i =0;i<10;i++){
		resetCounter();
		controlLeft(FORWARD,50);
		controlRight(FORWARD,50);
		delay(500);

		double distanceLeft = 0;
		double distanceRight = 0;

		int readingLeft = 0, readingRight = 0;
		getCounter(&readingLeft, &readingRight);
		if (readingLeft == -1 || readingRight == -1)
		{
			printf("Error!\n");
			continue;
		}
	//Distance is in mm.
		distanceLeft = readingLeft*63.4*M_PI / 390.0;
		distanceRight = readingRight*63.4*M_PI / 390.0;

		allDistanceLeft = distanceLeft+allDistanceLeft;
		allDistanceRight = distanceRight+allDistanceRight;
		printf("Left %.2lf cm, right %.2lf cm\n", distanceLeft / 10.0, distanceRight / 10.0);
		printf("Total: Left %.2lf cm, right %.2lf cm\n", allDistanceLeft / 10.0, allDistanceRight / 10.0);
	}
	stop();
	return 0;
}
