
var scrabbleScoreMap = { 
	1: ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' ],
	2: ['D', 'G'],
	3: ['B', 'C', 'M', 'P'],
	4: ['F', 'H', 'V', 'W', 'Y'],
	5: ['K'],
	8: ['J', 'X'],
	10: ['Q', 'Z'],
  };
  
int score(String inputString){
    var inputStringList = inputString.split('').toList();
    var result = inputString.map((letter) => scrabbleScoreMap.values.map(idx, elementList) => elementList.contains(letter)?? idx : 0);
    
    return int.parse(result);
  }


////////////////////////////////////////////////////////////////////////////
  int score(String word) {
  Map<String, int> letterValues = {
    "a": 1, "b": 3, "c": 3, "d": 2, "e": 1,
    "f": 4, "g": 2, "h": 4, "i": 1, "j": 8,
    "k": 5, "l": 1, "m": 3, "n": 1, "o": 1,
    "p": 3, "q": 10, "r": 1, "s": 1, "t": 1,
    "u": 1, "v": 4, "w": 4, "x": 8, "y": 4,
    "z": 10
  };

  return word.toLowerCase()
      .split('')
      .fold(0, (score, letter) => score + letterValues[letter]);
}
////////////////////////////////////////////////////////////////////////////

var values = {
  "AEIOULNRST": 1,
  "DG": 2,
  "BCMP": 3,
  "FHVWY": 4,
  "K": 5,
  "JX": 8,
  "QZ": 10
};

int score(String word) {
  return word.split('').fold(0, (int total, letter) {
    var valuesKey = values.keys.singleWhere((String key) => key.contains(letter.toUpperCase()));
    return total + values[valuesKey];
  });
}

////////////////////////////////////////////////////////////////////////////

int score(String word) =>
    word.split('').fold(0, (val, char) => val + charScore(char));

int charScore(String c) =>
    map[map.keys.firstWhere((k) => k.contains(c.toLowerCase()))];

Map<String, int> map = {
  'aeioulnrst': 1,
  'dg': 2,
  'bcmp': 3,
  'fhvwy': 4,
  'k': 5,
  'jx': 8,
  'qz': 10,
};


////////////////////////////////////////////////////////////////////////////
int score(String word) {
  var totalScore = 0;

  for (var letter in word.toUpperCase().split('')) {
    for (var key in _scoringMap.keys) {
      if (_scoringMap[key].contains(letter)) {
        totalScore += key;
        break;
      }
    }
  }

  return totalScore;
}

Map<int, List<String>> _scoringMap = const {
  1: ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],
  2: ['D', 'G'],
  3: ['B', 'C', 'M', 'P'],
  4: ['F', 'H', 'V', 'W', 'Y'],
  5: ['K'],
  8: ['J', 'X'],
  10: ['Q', 'Z']
};

////////////////////////////////////////////////////////////////////////////

int score(String word) {
  return word.isEmpty
      ? 0
      : word
          .split('')
          .map((char) => scorePerChar(char))
          .reduce((sum, elem) => sum + elem);
}

int scorePerChar(String char) {
  char = char.toUpperCase();
  switch (char) {
    case 'A':
    case 'E':
    case 'I':
    case 'O':
    case 'U':
    case 'L':
    case 'N':
    case 'R':
    case 'S':
    case 'T':
      return 1;
      break;
    case 'D':
    case 'G':
      return 2;
      break;
    case 'B':
    case 'C':
    case 'M':
    case 'P':
      return 3;
      break;
    case 'F':
    case 'H':
    case 'V':
    case 'W':
    case 'Y':
      return 4;
      break;
    case 'K':
      return 5;
      break;
    case 'J':
    case 'X':
      return 8;
      break;
    case 'Q':
    case 'Z':
      return 10;
      break;
    default:
      return 0;
  }
}

////////////////////////////////////////////////////////

int score([String word = '']) {
  if (word != null && word.isNotEmpty) {
    // get a list of the characters
    final letters = word.trim().toUpperCase().split('');
    // aggregate values of each letter and return final value
    return letters.fold(0, (total, currentLetter) => total += letterValueMap[currentLetter]);
  }

  // default to returning zero
  return 0;
}

final letterValueMap = const {
  'A': 1,
  'B': 3,
  'C': 3,
  'D': 2,
  'E': 1,
  'F': 4,
  'G': 2,
  'H': 4,
  'I': 1,
  'J': 8,
  'K': 5,
  'L': 1,
  'M': 3,
  'N': 1,
  'O': 1,
  'P': 3,
  'Q': 10,
  'R': 1,
  'S': 1,
  'T': 1,
  'U': 1,
  'V': 4,
  'W': 4,
  'X': 8,
  'Y': 4,
  'Z': 10
};

////////////////////////////////////////////////////////


int score(String inputString) => inputString.isEmpty ? 0 : inputString.split('').map((letter) => scorePerLetter(letter)).fold(0, (sum, next) => sum + next);
int score(String inputString) => inputString.isEmpty ? 0 : inputString.split('').map((letter) => scorePerLetter(letter)).reduce((curr, next) => curr + next);

int scorePerLetter(String letter) {
	letter = letter.toUpperCase();
	switch(letter) {
    case 'A':
    case 'E':
    case 'I':
    case 'O':
    case 'U':
    case 'L':
    case 'N':
    case 'R':
    case 'S':
    case 'T':
      return 1;
      break;
    case 'D':
    case 'G':
      return 2;
      break;
    case 'B':
    case 'C':
    case 'M':
    case 'P':
      return 3;
      break;
    case 'F':
    case 'H':
    case 'V':
    case 'W':
    case 'Y':
      return 4;
      break;
    case 'K':
      return 5;
      break;
    case 'J':
    case 'X':
      return 8;
      break;
    case 'Q':
    case 'Z':
      return 10;
      break;
    default:
      return 0;
  }
	
}