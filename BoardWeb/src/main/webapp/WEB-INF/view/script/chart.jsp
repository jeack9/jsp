<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // ajax 호출. 
      let centerAry = [["시도별", "센터개수"]];
      let url = "centerChart.do";
      fetch(url)
        .then(response => response.json())
        .then(result => {
          let keys = Object.keys(result);
          let values = Object.values(result);
          for(let i = 0; i < keys.length; i++){
            let center = [];
            center.push(keys[i]);
            center.push(values[i]);
            centerAry.push(center);
          }
          google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);
        })
        .catch(err => console.log(err));

      function drawChart() {
        var data = google.visualization.arrayToDataTable(centerAry);

        var options = {
          title: '시도별 센터개수'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
