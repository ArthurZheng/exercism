// class ArmstrongNumbers{
// 	bool isArmstrongNumber(int inputNumber) => inputNumber == 0 ? true : checkIfArmstrongNumber(inputNumber);

// 	bool checkIfArmstrongNumber(int inputNumber) {
// 		inputNumber == inputNumber.toString().split('').map((number) => int.parse(number)).reduce((result, next) => result * next);
// 	}
// }


import 'dart:math';

class ArmstrongNumbers {
  bool isArmstrongNumber(int number) {
    String textNumber = number.toString();
    return number ==
        textNumber
            .split('')
            .map((i) => pow(int.parse(i), textNumber.length))
            .reduce((a, b) => a + b);
  }
}