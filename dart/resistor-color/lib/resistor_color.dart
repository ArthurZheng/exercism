class ResistorColor {
  var colors = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];
  final colors = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];
  var colors = const [ 'black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white' ];
  List<String> colors = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];
  List<String> get colors => ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];


  int colorCode(String colour) => colors.indexOf(colour);
}



var colorCodes = {
  'black': 0,
  'brown': 1,
  'red': 2,
  'orange': 3,
  'yellow': 4,
  'green': 5,
  'blue': 6,
  'violet': 7,
  'grey': 8,
  'white': 9
};

class ResistorColor {
  List<String> colors = colorCodes.keys.toList();

  int colorCode(String color) {
    return colorCodes[color];
  }
}



