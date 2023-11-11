// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["3월", "", "4월", "", "5월", "", "6월", "", "7월", "", "8월", "", "9월"],
    datasets: [{
      label: "Sessions",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: [5, 10, 15, 20, 20, 25, 30, 32, 40, 55, 65, 80, 95],
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
          max: 100,
          maxTicksLimit: 10
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

// 데이터 및 옵션 설정
var data = {
  labels: ["자율주행", "장애물 통과", "배터리", "부피", "데이터 수집"],
  datasets: [
    {
      label: "모체로봇",
      backgroundColor: "rgba(0, 255, 255, 0.1)",
      borderColor: "#00ffff",

      data: [80, 80, 75, 90, 95],
    },
    {
      label: "소형로봇", // 새로운 데이터셋의 레이블
      backgroundColor: "rgba(00, 255, 00, 0.1)", // 초록색으로 변경
      borderColor: "#00ff00", // 초록색으로 변경
      borderWidth: 2,
      data: [70, 90, 65, 42, 95], // 새로운 데이터셋의 데이터
    }
],

};

var options = {
  scale: {
    pointLabels: {
      fontSize: 12,
      labelOffset: 30,
      maxLines: 2,
    },
    angleLines: {
      display: true,
    },
    ticks: {
      suggestedMin: 0,
      suggestedMax: 100,
    },
  },
};

// Radar Chart 생성
var ctx = document.getElementById("myRadarChart").getContext("2d");
var myRadarChart = new Chart(ctx, {
  type: "radar",
  data: data,
  options: options,
});

// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
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


// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
// var ctx = document.getElementById("myPieChart");
// var myPieChart = new Chart(ctx, {
//   type: 'pie',
//   data: {
//     labels: ["Blue", "Red", "Yellow", "Green"],
//     datasets: [{
//       data: [12.21, 15.58, 11.25, 8.32],
//       backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
//     }],
//   },
// });


// $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=52ac719bc95d0e3986c20c7769558d6f&units=metric', function(result) {
//   ('.ctemp').append(result.main.temp);
//   $('.lowtemp').append(result.main.temp_min);
//   $('.hightemp').append(result.main.temp_max);
//    result.weather[0].icon
//   var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon + '.png" alt="' + result.weather[0].description + '">'
//   $('.icon').html(wiconUrl);

//   createChart(result);
//   });


// function createChart(weatherData) {
//   var timeLabels = [];
//   var temperatureData = [];

//   for (var i = 0; i < 40; i++) {
//     var ctime = weatherData.list[i].dt;
//     var ctemp = weatherData.list[i].main.temp;
//     var currentTime = convertTime(ctime);

//     timeLabels.push(currentTime);
//     temperatureData.push(ctemp);
//   }

//   var ctx = document.getElementById('weatherChart').getContext('2d');
//   var weatherChart = new Chart(ctx, {
//     type: 'line',
//     data: {
//       labels: timeLabels,
//       datasets: [{
//         label: '온도 (°C)',
//         data: temperatureData,
//         borderColor: 'rgba(75, 192, 192, 1)',
//         backgroundColor: 'rgba(75, 192, 192, 0.2)',
//         borderWidth: 1,
//         fill: true
//       }]
//     },
//     options: {
//       scales: {
//         y: {
//           beginAtZero: true
//         }
//       }
//     }
//   });
// }
// function convertTime(t) {
//   var ot = new Date(t * 1000);
//   var datetime = ot.getDate();
//   var hour = ot.getHours();
//   return datetime + '일-' + hour + '시';
// }


$.getJSON('https://api.openweathermap.org/data/2.5/forecast?lat=37.5683&lon=126.9778&appid=52ac719bc95d0e3986c20c7769558d6f&units=metric', function(result) {

for(var i = 0; i < 40; i++) {
  var ctime = result.list[i].dt;
  var ctemp = result.list[i].main.temp;
  var currentTime = convertTime(ctime);
  var tableHtml = '<tr>' +
                    '<td>' + currentTime + '</td>' +
                    '<td>' + ctemp + '</td>' +
                  '</tr>';

  $('tbody').append(tableHtml);
}

function convertTime(t) {
  var ot = new Date(t * 1000); // ot = original time
  // Mon Jul 17 2023 16:31:23 GMT+0900 (한국 표준시)

  var datetime = ot.getDate();
  var hour = ot.getHours();

  return datetime + '일-' + hour + '시'
}

createChart(result.list);

});

function createChart(weatherData) {
// 그래프를 그릴 데이터 배열 생성
var timeLabels = [];
var temperatureData = [];

for (var i = 0; i < 40; i++) {
var ctime = weatherData[i].dt;
var ctemp = weatherData[i].main.temp;
var currentTime = convertTime(ctime);

timeLabels.push(currentTime);
temperatureData.push(ctemp);
}
var ctx = document.getElementById('weatherChart').getContext('2d');
var weatherChart = new Chart(ctx, {
type: 'line', // 선 그래프를 사용합니다.
data: {
  labels: timeLabels, // x축 레이블 (시간)
  datasets: [{
    label: 'Temperature (°C)',
    data: temperatureData, // y축 데이터 (온도)
    borderColor: 'rgba(75, 192, 192, 1)', // 선의 색상
    borderWidth: 2 // 선의 굵기
  }]
},
options: {
  responsive: false // 차트 크기를 조절하지 않도록 설정
}
});
}
function convertTime(t) {
var ot = new Date(t * 1000);
var datetime = ot.getDate();
var hour = ot.getHours();
return datetime + '일-' + hour + '시';
}

// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function number_format(number, decimals, dec_point, thousands_sep) {
  // *     example: number_format(1234.56, 2, ',', ' ');
  // *     return: '1 234,56'
  number = (number + '').replace(',', '').replace(' ', '');
  var n = !isFinite(+number) ? 0 : +number,
    prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
    sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
    dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
    s = '',
    toFixedFix = function(n, prec) {
      var k = Math.pow(10, prec);
      return '' + Math.round(n * k) / k;
    };
  // Fix for IE parseFloat(0.55).toFixed(0) = 0;
  s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
  if (s[0].length > 3) {
    s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
  }
  if ((s[1] || '').length < prec) {
    s[1] = s[1] || '';
    s[1] += new Array(prec - s[1].length + 1).join('0');
  }
  return s.join(dec);
}

