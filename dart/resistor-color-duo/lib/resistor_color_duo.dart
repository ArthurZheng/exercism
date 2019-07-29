class ResistorColorDuo {
  List<String> coloursMap = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];

  int value(List<String> colours) {
    return int.parse(colours.map((String colour) => coloursMap.indexOf(colour).toString()).join(''));
    return int.parse(colours.map((String colour) { return coloursMap.indexOf(colour).toString();}).join(''));
  }
}

class ResistorColorDuo {
  // Put your code here
  // static const List<String> _colorMap = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
  List<String> _colorMap = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];

  int value(List<String> colors) {
    assert(colors.length == 2);
    return int.parse(colors.map((String color) => _colorMap.indexOf(color).toString()).join(''));
  }


  int value(List<String> colors) {
    List<int> codes = colors.fold([], (a, b) => a..add(colorCodes.indexOf(b)));
    return int.parse(codes.join());
  }


int value(List<String> pair) {
    return colors.indexOf(pair[0]) * 10 + colors.indexOf(pair[1]);
  }

  int value(List<String> args) {

    String result = '';

    args.forEach((color) {
      result += colors.indexOf(color).toString();
    });

    return int.parse(result);
  }


  }