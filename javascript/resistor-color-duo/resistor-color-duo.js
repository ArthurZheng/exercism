//
// This is only a SKELETON file for the 'Resistor Color Duo' exercise. It's been provided as a
// convenience to get you started writing code faster.
//


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

const getCodeValue = (code) => colourMap[code]

export const value = (inputColours) => {
  const result = inputColours.map((code) => colourMap[code]).join('')
  return parseInt(result);
};