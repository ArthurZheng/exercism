String reverse([String inputString = '']) => inputString.split('').reversed.join('');


String reverse(String str) {
  return str.length > 0
      ? str.split('').reduce((accum, letter) => letter + accum)
      : str;
}


String reverse([String str = '']) {
  // Put your code here
    List<String> reversed = [];

  for (String char in str.split('')) {
    reversed.insert(0, char);
  }

  return reversed.join('');
}


String reverse(String input) {
  return input.runes.fold("", (String a, int b) => String.fromCharCode(b) + a);
}


