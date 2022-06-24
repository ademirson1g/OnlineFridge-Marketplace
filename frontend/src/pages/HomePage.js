// Everyone can see
import React, {Component} from 'react';
import $ from 'jquery';

export default class Homepage extends Component {

	// Jquery Code for Time Date
	jQueryCode = () => {
	  $(function() {
	  
		// Time function to get the date/time
		function time() {
		  
		  var date = new Date(),
			hours = date.getHours(), 
			minutes = date.getMinutes().toString(),
			ante, 
			greeting, 
			dd = date.getDate().toString(),
			userName = "User"; 
	
		  if (hours < 12) {
			ante = "AM";
			greeting = "Morning";
		  } else if (hours === 12 && hours >= 3) {
			ante = "PM";
			greeting = "Afternoon"
		  } else {
			ante = "PM";
			greeting = "Evening";
		  }
	  
		  if (hours === 0) {
			hours = 12;
			
		  } else if (hours !== 12) {
			hours = hours % 12;
		  }
	  
		  if (minutes.length < 2) {
			minutes = "0" + minutes;
		  }
	  
		  if (dd.length < 2) {
			dd = "0" + dd;
		  }
	  
		  Date.prototype.monthNames = [
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		  ];
	  
		  Date.prototype.weekNames = [
			"Sunday",
			"Monday",
			"Tuesday",
			"Wednesday",
			"Thursday",
			"Friday",
			"Saturday"
		  ];
		  
		  Date.prototype.getMonthName = function() {
			return this.monthNames[this.getMonth()];
		  };
		  
		  Date.prototype.getWeekName = function() {
			return this.weekNames[this.getDay()];
		  };
	  
		  $("#time").html(hours + ":" + minutes + " " + ante);
		  $("#day").html(date.getWeekName() + ", " + date.getMonthName() + " " + dd);
		  $("#greeting").html("Good " + greeting + ", " + userName + ".");
		  
		  setInterval(time, 1000);
		}
		time();
	  });
	  
	}
  
	componentDidMount() {
	  this.jQueryCode()
	}
  
	render() { 
	  return (
		<div className="container">
		 <div className="row flex-column justify-content-center align-items-center text-center">
		  <div className="col-sm-12 col-md-10 col-lg-8">
		   <h1 id="time">12:00 AM</h1>
		   <h3 id="day" className="display-5">Monday, January 01</h3>
		   <h2 id="greeting">Good Morning</h2>
		  </div>
		  </div>
		  </div>	  
	  )
	}
  }
  