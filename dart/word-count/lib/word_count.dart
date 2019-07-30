// class WordCount {
//   Map<String, int> countWords(String sentence) {
//     var exp = new RegExp(r"(\w+('\w+)?)");
//     return exp.allMatches(sentence)
//         .map((m) => m.group(0).toLowerCase())
//         .fold(new Map<String, int>(), (Map<String, int> counts, String word) {
//           if (counts.containsKey(word)) {
//             counts[word]++;
//           } else {
//             counts[word] = 1;
//           }

//           return counts;
//         });
//   }
// }



// class WordCount {
//   countWords(String val) {
//     var value = val
//         .toLowerCase()
//         .replaceAll(new RegExp(r"(' | ')"), " ")
//         .replaceAll(new RegExp(r"[.,?!:;""@&@\$%\^]+"), " ")
//         .replaceAll(new RegExp(r"\s+"), " ")
//         .trim();
//     var wordList = value.split(new RegExp(r"\s+"));
//     var wordSet = new Set.from(wordList);
//     var wordMap = new Map.fromIterable(wordSet,
//         key: (word) => word,
//         value: (word) => wordList.where((item) => item == word).length);
//     return wordMap;
//   }
// }


// class WordCount {
//   Map<String, int> countWords(String phrase) {
//     Map allWords = new Map();
//     new RegExp(r"(\w+'*\w+|\w+)").allMatches(phrase.toLowerCase()).forEach((match) =>
//       allWords[match.group(0)] = allWords.containsKey(match.group(0)) ? allWords[match.group(0)] + 1 : 1
//     );
//     return allWords;
//   }
// }


// class WordCount {
//   Map<String, int> countWords(String input) {
//     Map<String, int> counter = Map<String, int>();
//     Iterable<Match> words =
//         RegExp("\\w+'\\w|\\w+|\\d+").allMatches(input.toLowerCase());

//     for (Match word in words) {
//       counter.update(word.group(0), (value) => value + 1, ifAbsent: () => 1);
//     }
//     return counter;
//   }
// }


// class WordCount {
//   // Put your code here
//   Map<String, int> countWords(String word) {
//     var words = word.split(" ");
//     Map<String, int> index = new Map<String, int>();

//     for (var oneWord in words) {
//       if (index.containsKey(oneWord)) {
//         var count = index[oneWord];
//         count += 1;
//         index[oneWord] = count;
//       } else {
//         index[oneWord] = 1;
//       }
//     }
//     return index;
//   }
// }





////////////////////////////////// very good solution
// class WordCount {
//   Map<String, int> countWords(String s) => s.split(RegExp('\s')).fold(
//       <String, int>{},
//       (Map<String, int> map, String word) =>
//           map..update(word, (i) => ++i, ifAbsent: () => 1));
// }




// class WordCount {

//   Map<String, int> countWords(String str) {
    
//     // A map to store word and its count
//     var words = new Map<String, int>();

//     // Use regular expression to match words in string
//     new RegExp(r"(\w+)")
//       .allMatches(str)
//       .forEach((m) {
//         var word = m.group(0);
//         words.update(word, 
//                       (c) => c + 1,       // Increment word count if exists in map
//                       ifAbsent: () => 1); // If word not exist, add it into map with count equals 1
//       });

//     return words;
//   }
// }





// class WordCount {
//   Map countWords(String exp) {
//     RegExp sq = RegExp(r"( '|' )");
//     RegExp sc = RegExp(r"[^\w\']");
//     exp = exp.toLowerCase().replaceAll(sq, " ").replaceAll(sc, " ").trim();
//     var splitPhrase = exp.split(" ");
//     var result = new Map<String, int>.fromIterable(
//       splitPhrase, 
//       key: (w) => w, 
//       value: (w) => splitPhrase.where((item) => item == w).length);
//     return result;
//   }
// }




// class WordCount {
//   Map<String, int> countWords(String input) {
//     Map<String, int> counts = {};
//     var wordMatcher = new RegExp(r"(\w+(?:\'\w+)*)");
//     var matches = wordMatcher.allMatches(input);
//     countWord(String word) {
//       if (!counts.containsKey(word)) {
//         counts[word] = 1;
//       } else {
//         counts[word] += 1;
//       }
//     }
//     matches.forEach((item) => countWord(item.group(0)));
//     return counts;
//   }
// }




class WordCount {
  Map<String, int> countWords(String sentence) {
    Map<String, int> wordMap = {}; 
    List<String> matchWords = sentence.split(' ');
    for (String word in matchWords) {
      RegExp str = new RegExp('$word');
      Iterable<Match> matches = str.allMatches(sentence);
      wordMap[word] = matches.length;
      print(wordMap);
    }
    return wordMap;
  }
}


