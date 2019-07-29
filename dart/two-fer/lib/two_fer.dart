String twofer([String name = "you"]) => "One for $name, one for me.";


String twofer([String name]) {
  return 'One for ${name ?? 'you'}, one for me.';
}