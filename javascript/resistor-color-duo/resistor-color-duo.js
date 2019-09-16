const colourMap = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9
}

const getCodeValue = (code) => colourMap[code];

export const value = (inputColours) => {
  const result = inputColours.map((code) => colourMap[code]).join('');
  // return parseInt(result);
  return Number(result);
};








// second way of doing it
const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
export const value = input => input.map(i => COLORS.indexOf(i)).join('') | 0;




// third way of doing it
var COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];
export function value(colorArray) {
  return +colorArray.map(color => COLORS.indexOf(color)).join('')
}
//The "+" is a unary operator . It is used to cast a string into a number. cast-to-number-in-javascript-using-the-unary-operator
//https://medium.com/@nikjohn/cast-to-number-in-javascript-using-the-unary-operator-f4ca67c792ce




// fourth way of doing it
const colorCodes = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9
}

export const value = ([color1, color2]) => {
  return colorCodes[color1] * 10 + colorCodes[color2];
};





// Fifth way of doing it
export const value = colors => Number(colors.map(color => COLORS.indexOf(color)).join(''));
const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];





// Sixth way of doing it

const conversions = {
  black: '0',
  brown: '1',
  red: '2',
  orange: '3',
  yellow: '4',
  green: '5',
  blue: '6',
  violet: '7',
  grey: '8',
  white: '9',
};

export const value = colours =>
  +colours.reduce((output, colour) =>
    output + conversions[colour], '');









// Seventh way of doing it
const COLORS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white']

const colorCode = (color) => COLORS.indexOf(color);

export const value = colors => Number(colors.reduce((result, color) => result + colorCode(color), ''))





// Eighth way
export const value = ([color1, color2]) => COLORS.indexOf(color1) * 10 +
  COLORS.indexOf(color2)

export const COLORS = [
  'black',
  'brown',
  'red',
  'orange',
  'yellow',
  'green',
  'blue',
  'violet',
  'grey',
  'white',
]



// Ninth way
const COLOR_CODES = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9,
};

export function value(colors) {
  return colors.map(color => COLOR_CODES[color]).reduce((acc, digit) => acc * 10 + digit);
}




// Tenth way
const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

export const value = colors => colors.reduce((acc, val) => acc * 10 + COLORS.indexOf(val), 0)



// Eventh way
const COLORS = [
  "black", "brown", "red", "orange", "yellow",
  "green", "blue", "violet", "grey", "white"
];

const colorCode = colorStr => COLORS.indexOf(colorStr);

export const value = (colors) =>
  colors.reduce((acc, x) => acc * 10 + colorCode(x), 0);



// 12th way currying
const colorMap = {
  black: 0,
  brown: 1,
  red: 2,
  orange: 3,
  yellow: 4,
  green: 5,
  blue: 6,
  violet: 7,
  grey: 8,
  white: 9,
}

const getColorValue = colors => colorNames =>
  colorNames.map((colorName) =>
    colors[colorName.toLowerCase()]).join('');


export const value = (colorNames) => Number(getColorValue(colorMap)(colorNames);




    // 13th way
    export const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];

    export const value = (colors) => {
      return colors
        .map(color => COLORS.indexOf(color))
        .reduce((acc, index) => {
          return acc * 10 + index;
        }, 0);
    };





    // using module.exports;
    // const value = () => 10;
    // module.exports.value = value;

    // export the function directly;
    //export const value = () => 10;

    // use currying
    const colourMap = {
      black: 0,
      brown: 1,
      red: 2,
      orange: 3,
      yellow: 4,
      green: 5,
      blue: 6,
      violet: 7,
      grey: 8,
      white: 9,
    };

    const getColourValue = (colourMaps) => (colourNames) => colourNames.map((colourName) => colourMaps[colourName]).reduce((acc, colourValue) => (acc * 10) + colourValue);
    export const value = (colourNames) => getColourValue(colourMap)(colourNames);



    // use reduce
    const colourMap = {
      black: 0,
      brown: 1,
      red: 2,
      orange: 3,
      yellow: 4,
      green: 5,
      blue: 6,
      violet: 7,
      grey: 8,
      white: 9,
    };

    export const value = (colourNames) => {
      const result = colourNames.reduce((acc, colour) => acc + colourMap[colour], '')
      return Number(result);
    };




    // use map and reduce
    const colourMap = {
      black: 0,
      brown: 1,
      red: 2,
      orange: 3,
      yellow: 4,
      green: 5,
      blue: 6,
      violet: 7,
      grey: 8,
      white: 9,
    };

    export const value = (colourNames) => colourNames.map((colour) => colourMap[colour]).reduce((acc, colourValue) => (acc * 10) + colourValue, '');



    // use indexOf()
    const COLOURS = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];

    export const value = (colourNames) => colourNames.map(colour => COLOURS.indexOf(colour)).reduce((acc, colourValue) => (acc * 10) + colourValue);