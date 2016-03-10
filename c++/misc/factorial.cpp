#include <iostream>
#include <string.h>
//
// Test different methods of calculating factorial
//

// iterate over an interger, calculating the factorial
long iterativeFactorial(const int value)
{
	long answer = value;

	for (int i = value; i > 1; i--)
	{
		answer = answer * (i - 1);
	}

	return answer;
}

// recursively calculate factorial of a number
long recursiveFactorial(const int value)
{
	if (value <= 1)
	{
		// stop at 1. 
		return 1;
	}
	else
	{
		return (long) (value * recursiveFactorial(value - 1));
	}
}

int main(int argc, char **argv) 
{
	const long value = 23;
	long iAnswer = iterativeFactorial(value);
	std::cout << "iterative factorial is " << iAnswer << std::endl;

	long rAnswer = recursiveFactorial(value);
	std::cout << "recursive factorial is " << rAnswer << std::endl;
};
