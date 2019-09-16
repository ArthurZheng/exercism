const GIGA_MILLI_SECONDS = 1000000000 * 1000;
export const gigasecond = (inputDate) => {
  return new Date(inputDate.getTime() + GIGA_MILLI_SECONDS)
}



// way 2
export const gigasecond = input => new Date(Number(input) + 10e11);



// way 3
var Gigasecond = function (date) {

  this.currentdate = date;
};

Gigasecond.prototype.date = function () {
  return new Date(this.currentdate.getTime() + 1e12);
};

module.exports = Gigasecond;




/// way 4
var Gigasecond = function (aDate) {
  this.startDate = aDate;
}

Gigasecond.prototype.date = function () {
  var endDate = new Date(this.startDate.getTime() + Math.pow(10, 12));
  endDate.setHours(0, 0, 0, 0);
  return endDate;
}

module.exports = Gigasecond;




// way 5
export const gigasecond = (startDate) => {
  var start = startDate.getTime();
  var end = new Date(start + 1000000000000);
  return end;
};


// way 6
export const gigasecond = (startDate) => {
  var startTime = startDate.getTime();
  var endDate = new Date(startTime + 1000000000000);
  return endDate;
}


//way 7
const GIGASECOND = Math.pow(10, 12)

export const gigasecond = (date) => {
  return new Date(date.getTime() + GIGASECOND)
};




// way 8
const GIGASECOND_IN_MILLIS = Math.pow(10, 12);

export const gigasecond = (date) => {
  return new Date(date.getTime() + GIGASECOND_IN_MILLIS)
};


// way 9

export const gigasecond = (date) => {
  let new_date = new Date(date);
  new_date.setUTCSeconds(new_date.getSeconds() + Math.pow(10, 9));
  return new_date;
};


// way 10
export const gigasecond = (date) => {
  const gigaSeconds = Math.pow(10, 9)
  date.setUTCSeconds(date.getSeconds() + gigaSeconds)
  return date
};



// way 11
export const gigasecond = date => new Date(date.getTime() + Math.pow(10, 12));
export const gigasecond = date => new Date(date.getTime() + Math.pow(10, 12));
export const gigasecond = date => new Date(date.getTime() + Math.pow(10, 12));
// way 12
const Gigasecond = 10e11

export const gigasecond = (date) => new Date(date.getTime() + Gigasecond)


// way 13
export const gigasecond = date => {
  let newDate = new Date(date);
  newDate.setSeconds(date.getSeconds() + 10 ** 9);
  return newDate;
};


// way 14