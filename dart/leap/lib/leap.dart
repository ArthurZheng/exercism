class Leap{
	bool leapYear(int year) => year % 4 == 0 || (year % 100 != 0 && year % 400 == 0);
}


class Year {
  // Put your code here
  int _x;
  Year (this._x);
  bool isLeap(){
		if(_x%400 ==0)
			return true;
		else if(_x%100 ==0)
			return false;
		else if(_x%4==0)
			return true;
		else
			return false;
  }
}



class Year {
  // Put your code here
  int _year;
  Year(this._year);
  bool isLeap()=> _year%4==0 &&(_year%100 !=0 || _year%400==0);
  
}


class Leap{
	bool leapYear(int year) => year % 4 == 0 || (year % 100 != 0 && year % 400 == 0);
	bool leapYear(int year) => year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}


class Year {
	int year;
	Year(this.year)
	bool isLeap() { return _divBy(4) && (!_divBy(100) || _divBy(400)); }
	bool _divBy(int n) => year % n == 0; }	
}

