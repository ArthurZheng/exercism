import 'dart:math';

class DifferenceOfSquares {
  List<int> generateRange(int upTo) => Iterable.generate(upTo, (i) => i + 1).toList();

  int squareOfSum(int upTo) => pow(generateRange(upTo).reduce((curr, next) => curr + next), 2);

  int sumOfSquare(int upTo) => generateRange(upTo).fold(0, (curr, next) => curr + pow(next, 2));

  int differenceOfSquares(int upTo) => squareOfSum(upTo) - sumOfSquare(upTo);

  }



// class DifferenceOfSquares {
//   int squareOfSum(int inputNumber){
//     final sumOfRange =  generateList(inputNumber).reduce((curr, next) => curr + next);
//     return sumOfRange * sumOfRange;
// 	}

//   int sumOfSquare(int inputNumber) => generateList(inputNumber).fold(0, (current, next) => current + (next * next));

//   List<int> generateList(int inputNumber) => new List<int>.generate(inputNumber, (i) => i + 1);

//   int differenceOfSquares(int inputNumber) => this.squareOfSum(inputNumber) - this.sumOfSquare(inputNumber);
// }


//////////////////////////////////////////////////////////

// class DifferenceOfSquares {
//   int _sum(list) => list.reduce((value, element) => value + element);

//   int _square(number) => number * number;

//   int squareOfSums(int upToNumber) => _square(_sum(new Iterable.generate(upToNumber+1)));

//   int sumOfSquares(int upToNumber) => _sum(new Iterable.generate(upToNumber+1, _square));

//   int difference(int upToNumber) => squareOfSums(upToNumber) - sumOfSquares(upToNumber);
// }


// import 'dart:math';

// class DifferenceOfSquares {

//   List<int> listTo(int max){
//     return new List<int>.generate(max , (i) => i + 1);
//   }

//   int squareOfSum(int upTo) {
//     final sum = listTo(upTo).fold(0, (sum, number) => sum + number);
//     final sumSqr = pow(sum, 2);
//     return sumSqr;
//   }
  
//   int sumOfSquare(int upTo) {
//     final squaresSum = listTo(upTo).fold(0, (sum, number) => sum + pow(number, 2));
//     return squaresSum;
//   }

//   int differenceOfSquares(int upTo){
//     return squareOfSum(upTo) - sumOfSquare(upTo);
//   }
// }


// class DifferenceOfSquares {

//   int sumOfSquare(int toNumber) =>
//     new Iterable.generate(toNumber)
//       .map((i)=>i+1)
//       .map((i)=>i*i)
//       .reduce((a,b)=>a+b);

//   int squareOfSum(int toNumber) => 
//     ((int i)=>(i*i))(new Iterable.generate(toNumber)
//       .map((i)=>i+1)
//       .reduce((a,b)=>a+b));

//   int differenceOfSquares(int toNumber) {
//     return (sumOfSquare(toNumber)-squareOfSum(toNumber)).abs();
//   }
// }






// class DifferenceOfSquares {
  
//   List<int> list(val) => new Iterable.generate(val, (i) => i + 1);
//   int square(val) => val * val;
//   int sum(left, right) => left + right;
//   int squareOfSums(int val) => square(list(val).reduce(sum));
//   int sumOfSquares(int val) => list(val).map(square).reduce(sum);
//   int difference(int val) => squareOfSums(val) - sumOfSquares(val);
// }


// import 'dart:math';

// class DifferenceOfSquares {

//   _sum(list) => list.reduce((a,b) => a + b);
//   _gen(n) => new Iterable.generate(n, (i) => i + 1);

//   int squareOfSums(int len) =>
//     pow(_sum(_gen(len)), 2);

//   int sumOfSquares(int len) =>
//     _sum(_gen(len).map((n) => pow(n, 2)));

//   int difference(int len) =>
//     squareOfSums(len) - sumOfSquares(len);
// }



// import 'dart:math';

// class DifferenceOfSquares {
//   int rangeIterator(int n, int Function(int acc, int item) f) => new List.generate(n, (val) => val + 1).fold<int>(0, f);

//   int squareOfSum(int n) => pow(rangeIterator(n, (acc, item) => item + acc), 2).toInt();

//   int sumOfSquare(int n) => rangeIterator(n, (acc, item) => pow(item, 2).toInt() + acc);

//   int differenceOfSquares(int n) => squareOfSum(n) - sumOfSquare(n);
// }


// import 'dart:math';

// class DifferenceOfSquares {
// 	num sumOfSquare(int input) => 
// 			List<int>.generate(input, (i) => i+1)
// 			.map((i) => i*i)
// 			.reduce((a, b) => a+b);


// 	num squareOfSum(int input) => 
// 			pow(List<int>.generate(input, (i) => i+1)
// 					.reduce((a, b) => a+b), 2);


// 	num differenceOfSquares(int input) => 
// 			squareOfSum(input) - sumOfSquare(input);
// }



// class DifferenceOfSquares {
//   int squareOfSum(int number) {
//     var sum = new List.generate(number, (i) => i + 1)
//         .fold(0, (int a, int b) => a + b);
//     return sum * sum;
//   }

//   int sumOfSquare(int number) {
//     return new List.generate(number, (i) => i + 1)
//         .map((i) => i * i)
//         .fold(0, (int a, int b) => a + b);
//   }

//   int differenceOfSquares(int number) {
//     return squareOfSum(number) - sumOfSquare(number);
//   }
// }

