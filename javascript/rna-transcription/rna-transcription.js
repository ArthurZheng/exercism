export const toRna = (dna) => {
  const dnaString = ['G', 'C', 'T', 'A'];
  const dnaToRnaMapping = {
    'G': 'C',
    'C': 'G',
    'T': 'A',
    'A': 'U'
  }
  const isIncludedInDnaString = (key) => dnaString.includes(key);
  const inputDnaString = dna.split('');
  const lookUpDnaToRna = (key) => dnaToRnaMapping[key];
  const inputValidation = inputDnaString.map(isIncludedInDnaString);

  if (inputValidation.includes(false)) {
    throw new Error('Invalid input DNA.');
  }
  const result = inputDnaString.map(lookUpDnaToRna)
  return result.join('');
}



// way 2
var DnaTranscriber = function () {};

const rnaMap = {
  G: 'C',
  C: 'G',
  T: 'A',
  A: 'U'
};

DnaTranscriber.prototype.toRna = function (dna) {
  return dna.replace(/[GCTA]/g, l => {
    return rnaMap[l];
  });
};

module.exports = DnaTranscriber;

// Hmmm...to me, replace feels more logical since I am operating on a string.Here is a map version: DnaTranscriber.prototype.toRna = function (dna) {
//   return [...dna].map(l => {
//     return rnaMap[l];
//   }).join("");
// };

// The key difference is, with replace,
// if there is an unexpected letter in the input, that letter is preserved.With map, that letter disappears.



// way 3
var translation = {
  C: 'G',
  G: 'C',
  A: 'U',
  T: 'A'
}

var toRNA = function (strand) {
  return strand.split('').map(function (nt) {
    return translation[nt]
  }).join('')
}

module.exports = toRNA






// way 4
class Transcriptor {
  toRna(strand) {
    let mapping = new Map([
      ['G', 'C'],
      ['C', 'G'],
      ['T', 'A'],
      ['A', 'U'],
    ])

    return Array.from(strand, s => mapping.get(s)).join('');
  }
}

export default Transcriptor;




// way 5
var DnaTranscriber = function () {};

DnaTranscriber.prototype.toRna = function (dna) {
  var map = {
    C: 'G',
    G: 'C',
    A: 'U',
    T: 'A'
  };

  return dna.replace(/[CGAT]/g, function (nuc) {
    return map[nuc];
  });
};

module.exports = DnaTranscriber;



// way 6
const DnaTranscriber = function () {};

DnaTranscriber.prototype.toRna = function (dna) {
  const key = {
    G: "C",
    C: "G",
    T: "A",
    A: "U",
  };
  if (!dna.split("").every(item => key[item])) {
    throw new Error("Invalid input");
  }
  return dna
    .split("")
    .map(item => key[item])
    .join("");
};

module.exports = DnaTranscriber;


// way 7
var toRna = function (nt) {
  const trans = {
    C: 'G',
    G: 'C',
    A: 'U',
    T: 'A'
  };
  return nt.split('').map(function (base) {
    return trans[base];
  }).join('');
};
module.exports = toRna;


// way 8
"use strict";
var DnaTranscriber = function () {
  var RNA = {
    'G': 'C',
    'C': 'G',
    'T': 'A',
    'A': 'U'
  };
  var DNA = {
    'G': 'C',
    'C': 'G',
    'U': 'A',
    'A': 'T'
  };

  var transcribe = (map, regex) => {
    return (s) => {
      return s.replace(regex, (m) => {
        return map[m]
      });
    }
  };

  this.toRna = transcribe(RNA, /[GTCA]/g);

  this.toDna = transcribe(DNA, /[GCUA]/g);
};

module.exports = DnaTranscriber;


// way 9
export default class Transcriptor {
  toRna(dnaStrand) {
    const rnaEquivelant = {
      'G': 'C',
      'C': 'G',
      'T': 'A',
      'A': 'U'
    };

    return [...dnaStrand].reduce(
      (prev, current) => (prev + rnaEquivelant[current]), ""
    );
  }
}



// way 10
var DnaTranscriber = function () {};

DnaTranscriber.prototype.toRna = function (seq) {
  return transcribe(seq, true);
};

DnaTranscriber.prototype.toDna = function (seq) {
  return transcribe(seq, false);
};

var transcribe = function (seq, toRna) {
  var complements = {
    G: 'C',
    C: 'G',
    T: 'A',
    U: 'A',
    A: function () {
      return toRna ? 'U' : 'T'
    }()
  };
  return seq.replace(/./g, function (x) {
    return complements[x];
  });
}

module.exports = DnaTranscriber;



// way 11
var DnaTranscriber = function () {};

var converter = {
  C: 'G',
  G: 'C',
  A: 'U',
  T: 'A'
};

DnaTranscriber.prototype.toRna = function (dna) {
  result = [];
  dna.split("").forEach(function (letter) {
    result.push(converter[letter]);
  });
  result.toString();
  return result.join("");
};

module.exports = DnaTranscriber;



// way 12
module.exports = function (dna) {
  var rnaComplement = {
    G: 'C',
    C: 'G',
    T: 'A',
    A: 'U'
  };
  return dna.split('').reduce(function (transcription, nucleotide) {
    return transcription + rnaComplement[nucleotide];
  }, '');
};



// way 13
/*jslint white: true */
module.exports = function () {
  'use strict';

  var dnaComplements = {
      G: "C",
      C: "G",
      A: "U",
      T: "A"
    },
    rnaComplements = {
      G: "C",
      C: "G",
      U: "A",
      A: "T"
    },
    transcribe = function (strand, complements) {
      return strand.replace(/[A-Z]/g, function (nucleotide) {
        return complements[nucleotide];
      });
    };

  return {
    toRna: function (dna) {
      return transcribe(dna, dnaComplements);
    },

    toDna: function (rna) {
      return transcribe(rna, rnaComplements);
    }
  };
};



// way 14
var toRna = function toRNA(strand) {
  return strand.split('').map(function (base) {
    return {
      C: 'G',
      G: 'C',
      A: 'U',
      T: 'A'
    } [base];
  }).join('');
};