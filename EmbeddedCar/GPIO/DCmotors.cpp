#include "GPIOlib.h"

using namespace GPIO;

void stop(){

	stopLeft();
	stopRight();
	delay(1000);
}

int main()
{
	init();

	//Move forward

	controlLeft(FORWARD,50);
	controlRight(FORWARD,50);
	delay(3000);

	//Stop
	stop();
	turnTo(30);
	delay(1000);
	turnTo(-30);
	delay(1000);
	stop();

	//Move backward
	controlLeft(BACKWARD,50);
	controlRight(BACKWARD,50);
	delay(1000);

	//Stop
	stop();

	//2 motors can work at different speeds.
	controlLeft(FORWARD,30);
	controlRight(FORWARD,40);
	delay(1000);

	//Stop
	stop();

	//Even directions can differ from each other.
	controlLeft(BACKWARD,35);
	controlRight(FORWARD,20);
	delay(1000);

	//Don't forget to stop all motors before exiting.
	stop();
	return 0;
}
