class Isogram {
	bool isIsogram(String inputString) => inputString.isEmpty? true : (inputString.split('').toSet().length == inputString.length);
}

class Isogram {
  bool isIsogram(String word) {
    String cleanWord = word.toLowerCase().replaceAll(new RegExp(r'\W'), '');
    return cleanWord.split('').toSet().length == cleanWord.length;
  }
}


class Isogram {
  RegExp _rep = RegExp(r'(\w)\1+', caseSensitive: false);

  bool isIsogram(String word) {
    List<String> lettersSorted = word.split('');
    lettersSorted.sort();

    return !this._rep.hasMatch(lettersSorted.join());
  }
}



class Isogram {
    bool isIsogram(String input) {
        List<String> filtered = input.toLowerCase().split("").where((l) => !['-', ' '].contains(l)).toList();
        Set<String>  uniqueElements = Set.from(filtered);
        return (filtered.length == uniqueElements.length);
    }
}


class Isogram {
  bool isIsogram(String word) {
    RegExp exp = RegExp(r"[-| ]");
    List letters = word.toLowerCase().replaceAllMapped(exp, (m) => "").split("");
    return letters.length == letters.toSet().length;
  }
}





class Isogram {
  bool isIsogram(String input) {
    var sanitized = input.toLowerCase().replaceAll(RegExp("[ -]"), '');
    return sanitized.split('').toSet().length == sanitized.length;
  }
}


class Isogram {
  bool isIsogram(String text) => text.toLowerCase().replaceAll(new RegExp(r'\W'), '').split('').toSet().length == text.length;
}