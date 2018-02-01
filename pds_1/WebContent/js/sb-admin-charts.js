// Chart.js scripts
// -- Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';
// -- Area Chart Example
var state;
function changeState() {
    state=document.getElementById("states").value;
    test(state);
}

var ctx = document.getElementById("myAreaChart");
 
var text=test(state); 
 
function test(state) { 

    myFunction(function(d) {
        //processing the data
    	obj=JSON.parse(d);  
    	var c1 =obj.pro[0].id;
        var c2 = obj.pro[1].id;
        var c3 = obj.pro[2].id;
        var c4 = obj.pro[3].id;
        
        var s1 = (String)(obj.pro[4].id);
        var s2 = (String)(obj.pro[5].id);
        var s3 = (String)(obj.pro[6].id);
        var s4 = (String)(obj.pro[7].id);
    
    	//var d_s = parseInt(obj.pro[0].id);
    	//var k_s = parseInt(obj.pro[1].state); 
    	var myLineChart = new Chart(ctx, {
    		
    		  type: 'line',
    		  data: {
    		    labels: [ s1,s2,s3,s4],
    		    datasets: [{
    		      label: "Number of Depot",
    		      lineTension: 0.3,
    		      backgroundColor: "rgba(2,117,216,0.2)",
    		      borderColor: "rgba(2,117,216,1)",
    		      pointRadius: 5,
    		      pointBackgroundColor: "rgba(2,117,216,1)",
    		      pointBorderColor: "rgba(255,255,255,0.8)",
    		      pointHoverRadius: 5,
    		      pointHoverBackgroundColor: "rgba(2,117,216,1)",
    		      pointHitRadius: 20,
    		      pointBorderWidth: 2,
    		   //   data:    [ parseInt(obj.pro[0].id) ,parseInt(obj.pro[1].id)],
    		      data:    [c1,c2,c3,c4],
    		      }],
    		  },
    		  options: {
    		    scales: {
    		      xAxes: [{
    		        time: {
    		          unit: 'date'
    		        },
    		        gridLines: {
    		          display: false
    		        },
    		        ticks: {
    		          maxTicksLimit: 7
    		        }
    		      }],
    		      yAxes: [{
    		        ticks: {
    		          min: 0,
    		          max: 50,
    		          maxTicksLimit: 5
    		        },
    		        gridLines: {
    		          color: "rgba(0, 0, 0, .125)",
    		        }
    		      }],
    		    },
    		    legend: {
    		      display: false
    		    }
    		  }
    		}); 
    }); 
}
function myFunction(callback) {
    var data; 
    $.ajax({
    	url : 'Servlet1',
    	type: "GET",
    	async: false,
		data : { state: state} ,
		success : function(responseText) {
		 data = responseText ; 
            callback(data);
        },
        error: function () {}
    }); // ajax asynchronus request 
    //the following line wouldn't work, since the function returns immediately
    //return data; // return data from the ajax request
}
//////////
 
		
// -- Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["January", "February", "March", "April", "May", "June"],
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [4215, 5312, 6251, 7841, 9821, 14984],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
// -- Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Blue", "Red", "Yellow", "Green"],
    datasets: [{
      data: [12.21, 15.58, 11.25, 8.32],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
    }],
  },
});
