// export const colorCode = (colour) => {
//   switch (colour) {
//     case 'black':
//       return 0;
//       break;
//     case 'white':
//       return 9;
//       break;
//     case 'orange':
//       return 3;
//       break;
//   }

// };
// export const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]




// second way of doing it;
const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];

const colorCode = (name) => COLORS.indexOf(name);

// either this 
// module.exports = {
//   COLORS,
//   colorCode
// };

// or this
export {
  COLORS,
  colorCode
};





// third way of doing it
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
  white: 9,
}
export const colorCode = key => colorCodes[key];
export const COLORS = Object.keys(colorCodes);





// Fourth way of doing it
export const colorCode = (code) => {
  return COLORS.findIndex(x => x == code);
};
export const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"];




// Fifth way of doing it
export const colorCode = colorName => {
  let idx = COLORS.indexOf(colorName);
  if (idx != -1) {
    return idx;
  }
  throw new Error(`Unknown color: ${colorName}`);
};

export const COLORS = [
  "black",
  "brown",
  "red",
  "orange",
  "yellow",
  "green",
  "blue",
  "violet",
  "grey",
  "white"
];




// Sixth way of doing it
const colorMap = {
  "black": 0,
  "brown": 1,
  "red": 2,
  "orange": 3,
  "yellow": 4,
  "green": 5,
  "blue": 6,
  "violet": 7,
  "grey": 8,
  "white": 9
}

const COLORS = Object.keys(colorMap)
const colorCode = s => colorMap[s]

export {
  colorCode,
  COLORS
}




//Seventh way of doing it
export const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]
export const colorCode = (str) => (COLORS.indexOf(




      // Eighth way of doing it
      export const COLORS = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]
      export const colorCode = (str) => (COLORS.indexOf(str) !== -1) ? COLORS.indexOf(str) : false






      // Jun's final way of doing it
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

      const COLORS = Object.keys(colourMap)
      const colorCode = (code) => colourMap[code]

      module.exports = {
        colorCode,
        COLORS
      }