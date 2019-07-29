class ResistorColorDuo {
  List<String> coloursMap = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];

  int value(List<String> colours) {
    return int.parse(colours.map((String colour) => coloursMap.indexOf(colour).toString()).join(''));
    return int.parse(colours.map((String colour) { return coloursMap.indexOf(colour).toString();}).join(''));
  }
}