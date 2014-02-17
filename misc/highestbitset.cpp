#include <cstdio>
#include <string.h>
#include <iostream>

int main(int argc, char **argv) 
{
	// check if the highest bit in a character is set

	unsigned int test = 0x8000;

	// create a sample set
	int samples[3];
	samples[0] = 0x7FFF; // no
	samples[1] = 0xCCFF; // yes
	samples[2] = 0x8383; // yes

	for (int i = 0; i < 3; i++)
	{
		if (test & samples[i])
		{
			std::cout << std::hex << "0x" << (unsigned int) samples[i] << " has the higesth bit set" << std::endl;
		}
		else
		{
			std::cout << std::hex << "0x" << (unsigned int) samples[i] << " does not have the highest bit set" << std::endl;
		}
	}

	return 0;
};
